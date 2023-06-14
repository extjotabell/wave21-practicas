package com.otenerdiploma.OtenerDiploma.Integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.otenerdiploma.OtenerDiploma.controller.ObtenerDiplomaController;
import com.otenerdiploma.OtenerDiploma.exception.StudentNotFoundException;
import com.otenerdiploma.OtenerDiploma.model.StudentDTO;
import com.otenerdiploma.OtenerDiploma.model.SubjectDTO;
import com.otenerdiploma.OtenerDiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private IObtenerDiplomaService service;


    @Test
    public void testAnalyzeScoreValidResponse() throws Exception {
        Long studentId = 1L;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematica", 9.0));
        subjects.add(new SubjectDTO("Fisica", 7.0));
        subjects.add(new SubjectDTO("Quimica", 6.0));
        StudentDTO expectedResponse = new StudentDTO(
                studentId, "Juan",
                "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",
                7.33, subjects
        );

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponseString = writer.writeValueAsString(expectedResponse);

        when(service.analyzeScores(studentId)).thenReturn(expectedResponse);

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print()).andExpect(status().isOk()).andExpect(content().contentType("application/json"))
                .andReturn();
        assertEquals(expectedResponseString, result.getResponse().getContentAsString());
    }

    @Test
    public void testAnalyzeScoreBadRequest() throws Exception {
        Double studentId = -1.5;

        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print()).andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    public void studentNotFound() throws Exception {
        Long studentId = 1000000L;
        when(service.analyzeScores(studentId)).thenThrow(new StudentNotFoundException(studentId));
        MvcResult result = this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", studentId))
                .andDo(print()).andExpect(status().isNotFound())
                .andExpect(jsonPath("$.description").value("El alumno con Id " + studentId +" no se encuetra registrado."))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andReturn();
    }

}
