package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
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

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("GET - /analyzeScores/{studentId} - BadPath")
    void anlyzeScoresIntegrationTestOk() throws Exception {

        StudentDTO studentDTO = new StudentDTO(20L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 8.50)));
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id 10 no se encuetra registrado.");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);
        String errorExpected = writer.writeValueAsString(errorDTO);

        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", 10)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andReturn();

        assertEquals(errorExpected, mvcResult.getResponse().getContentAsString());
    }
}
