package com.meli.obtenerdiploma.integracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

  @Autowired
  MockMvc mockMvc;


  ObjectWriter writer = new ObjectMapper()
    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
    .writer();

  @Test
  void createStudentOk() throws Exception {
    String msj = "";
    StudentDTO s = new StudentDTO(1L, "Nahuel", msj, 10.5d, Arrays.asList(
      new SubjectDTO("Matematicas", 10d),
      new SubjectDTO("Ciencia", 10d),
      new SubjectDTO("Literatura", 10d)
    ));

    String sPayload = this.writer.writeValueAsString(s);

    var request = post("/student/registerStudent")
      .contentType(MediaType.APPLICATION_JSON)
      .content(sPayload);

    MvcResult result = mockMvc.perform(request).andDo(print()).andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }

  @Test
  void getStudentError() throws Exception {
    int id = 1000;
    var request = get("/student/getStudent/"+id);
    mockMvc.perform(request)
      .andExpect(status().is4xxClientError());
  }

  @Test
  void getStudentOk() throws Exception {
    int id = 2;
    String msj = "El alumno Perro ha obtenido un promedio de 1. Puedes mejorar.";
    StudentDTO s = new StudentDTO(2L, "Perro", msj, 1.0, Arrays.asList(
      new SubjectDTO("Matematicas", 1d),
      new SubjectDTO("Ciencia", 1d),
      new SubjectDTO("Literatura", 1d)
    ));

    String sPayload = this.writer.writeValueAsString(s);

    var request = get("/student/getStudent/"+id);

    MvcResult result = mockMvc.perform(request)
      .andDo(print())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    assertEquals(sPayload, result.getResponse().getContentAsString());
  }

  @Test
  void deleteStudentOk() throws Exception {
    int id = 1;

    var request = get("/student/removeStudent/"+id);
    MvcResult result = mockMvc.perform(request).andDo(print()).andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }

  @Test
  void deleteStudentNotExistingOk() throws Exception {
    int id = 100;

    var request = get("/student/removeStudent/"+id);
    MvcResult result = mockMvc.perform(request).andDo(print()).andReturn();

    assertEquals(200, result.getResponse().getStatus());
  }

  @Test
  void modifyEstudentsOk() throws Exception {

    String msj = "";
    StudentDTO s = new StudentDTO(2L, "Perro", msj, 10.5d, Arrays.asList(
      new SubjectDTO("Matematicas", 1d),
      new SubjectDTO("Ciencia", 1d),
      new SubjectDTO("Literatura", 1d)
    ));

    String sPayload = this.writer.writeValueAsString(s);

    var request = post("/student/modifyStudent")
      .contentType(MediaType.APPLICATION_JSON)
      .content(sPayload);

    mockMvc.perform(request)
      .andDo(print())
      .andExpect(status().isOk())
      .andReturn();

    request = get("/student/getStudent/"+2L);

    MvcResult result = mockMvc.perform(request).andReturn();
    var sResult = new ObjectMapper().readValue(result.getResponse().getContentAsString(), StudentDTO.class);

    assertEquals(sPayload, result.getResponse().getContentAsString());
    assertEquals(1.0, sResult.getAverageScore());
  }

  @Test
  void listStudentsOk() throws Exception {

    var request = get("/student/listStudents");

    mockMvc.perform(request)
      .andDo(print())
      .andExpect(status().isOk())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName").value("Nahuel"));

  }
}
