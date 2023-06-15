package com.meli.obtenerdiploma.integration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    private static ObjectWriter writer;
    static StudentDAO studentDAO = new StudentDAO();

    SubjectDTO matematica;
    SubjectDTO fisica;
    SubjectDTO quimica;

    StudentDTO student;


    @BeforeAll
    static void initialize(){
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
    }

    @BeforeEach
    public void beforeEach(){
        matematica = new SubjectDTO("Matematica", 10.0);
        fisica = new SubjectDTO("Fisica", 5.0);
        quimica = new SubjectDTO("Quimica", 6.0);

        student = new StudentDTO(1L, "Fabri", "El alumno Fabri ha obtenido un promedio de 7. Puedes mejorar.", 7.0, List.of(matematica,fisica,quimica));

        if (! studentDAO.exists(student)){
            studentDAO.save(student);
        }
    }

    @Test
    @DisplayName("POST - /student/registerStudent - HappyPath")
    void registerStudentIntegrationTestOk() throws Exception {

        String payloadDto = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @DisplayName("POST - /student/registerStudent - HappyPath")
    void registerStudentIntegrationTestInvalidParameters() throws Exception {
        String payloadDto = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @DisplayName("GET - /getStudent/{id} - HappyPath")
    void getStudentIntegrationTestOk() throws Exception {

        String payloadDto = writer.writeValueAsString(student);

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(payloadDto,mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("POST - /modifyStudent - HappyPath")
    void modifyStudentIntegrationTestOk() throws Exception {

        String payloadDto = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(jsonPath("$").doesNotExist());

    }

    @Test
    @DisplayName("GET - /removeStudent/{id} - HappyPath")
    void removeStudentIntegrationTestOk() throws Exception {

        String payloadDto = writer.writeValueAsString(student);

        mockMvc.perform(get("/student/removeStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @DisplayName("GET - /listStudents - HappyPath")
    void listStudentIntegrationTestOk() throws Exception {

        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$").isArray());
    }
}