package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ResponseDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class TestStudentController {

@Autowired
MockMvc mockMvc;

@Test
void TestRegisterUser() throws Exception{

    StudentDTO stu = new StudentDTO(4L, "Marta","soy marta",0.0, getListWithSubjectAVG10());
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    String jsonPayload = writer.writeValueAsString(stu);
    String responseJson = writer.writeValueAsString(new ResponseDTO(stu.getId(),"El estudiante ha sido registrado correctamente"));
    MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
}


@Test
public void testGetUser() throws Exception{
    mockMvc.perform(get("/student/getStudent/{id}", 5L))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Marta"));
}

@Test
@DisplayName("Modificar el estudiante")
void testModifyStudent() throws Exception {
    StudentDTO stu = new StudentDTO(5L, "Marta","soy marta",0.0, getListWithSubjectAVG10());
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    String jsonPayload = writer.writeValueAsString(stu);
    String responseJson = writer.writeValueAsString(new ResponseDTO(stu.getId(),"El estudiante ha sido modificado correctamente"));
    MvcResult mvcResult = mockMvc.perform(post("/student/modifyStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(mvcResult1 -> mvcResult1.getResponse().getContentAsString().equals(responseJson))
            .andReturn();

}

    List<SubjectDTO> getListWithSubjectAVG10(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Quimica", 10.0));
        subjects.add(new SubjectDTO("Matematica", 10.0));
        subjects.add(new SubjectDTO("Lengua", 10.0));
        subjects.add(new SubjectDTO("Fisica", 10.0));
        subjects.add(new SubjectDTO("Artistica", 10.0));
        return subjects;
    }
}

