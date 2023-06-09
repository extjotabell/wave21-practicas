package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("POST - /student/registerStudent - HappyPath")
    void registerStudentIntegrationTestOk() throws Exception {

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);

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

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.5)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);

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

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);

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

        StudentDTO studentDTO = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDTO);

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
