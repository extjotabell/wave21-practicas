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

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

  @Autowired
  MockMvc mockMvc;

  ObjectWriter writer = new ObjectMapper()
    .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
    .writer();

  @Test
  void analyzeScoreDesaprobadoOk() throws Exception {
    var subjects = Arrays.asList(
      new SubjectDTO("Matematicas", 1d),
      new SubjectDTO("Ciencia", 1d),
      new SubjectDTO("Literatura", 1d)
    );

    StudentDTO student = new StudentDTO(
      2L,
      "Perro",
      "El alumno Perro ha obtenido un promedio de 1. Puedes mejorar.",
      1.0,
      subjects
    );

    String sPayload = this.writer.writeValueAsString(student);

    var request = get("/analyzeScores/2");
    var result = mockMvc.perform(request)
      .andDo(print())
      .andExpect(content().contentType(MediaType.APPLICATION_JSON))
      .andReturn();

    assertEquals(sPayload, result.getResponse().getContentAsString());
  }
}
