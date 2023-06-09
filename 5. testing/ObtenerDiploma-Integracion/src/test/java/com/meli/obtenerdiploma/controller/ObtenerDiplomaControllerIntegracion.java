package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ObtenerDiplomaControllerIntegracion {
    @Autowired
    MockMvc mockMvc;

    static StudentDAO studentDAO = new StudentDAO();
    StudentDTO _expectedStudent;
    private static ObjectWriter writer;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }

    @BeforeEach
    void beforeEach() {
        _expectedStudent = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        if( ! studentDAO.exists( _expectedStudent ) )
            studentDAO.save( _expectedStudent );
    }

    @Test
    @DisplayName("Integration test 01 - analyze score success")
    public void testAnalyzeScores() throws Exception{
        _expectedStudent.setAverageScore(6.0);
        _expectedStudent.setMessage("El alumno Marco ha obtenido un promedio de 6.00. Puedes mejorar.");
        String responseJson = writer.writeValueAsString(_expectedStudent);
        ResultMatcher expectedJson = content().json(responseJson);

        mockMvc.perform(get("/analyzeScores/{studentId}", _expectedStudent.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(expectedJson);
    }


    @Test
    @DisplayName("Integration test 02 - analyze score exception")
    void testAnalyzeScoresWithException() throws Exception {
        mockMvc.perform(get("/analyzeScores/{studentId}", 999))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

}
