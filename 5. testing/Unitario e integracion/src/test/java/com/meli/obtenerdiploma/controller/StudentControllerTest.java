package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.dto.response.ResponseDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

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
class StudentControllerTest {
    @Autowired
    MockMvc mockMvc;

    //Get methods

    @Test
    @DisplayName("getStudent Integration Test")
    void getStudentTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }

    @Test
    @DisplayName("listStudents Integration Test")
    void listStudentsTest() throws  Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[1].studentName").value("Pedro"))
                .andReturn();
    }

    @Test
    @DisplayName("removeStudent Ok Integration Test")
    void removeStudentTestOk() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        mockMvc.perform(get("/student/removeStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("removeStudent Fail Integration Test")
    public void removeStudentTestFail() throws Exception{
        mockMvc.perform(get("/student/getStudent/{id}",78))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    //Post methods

    @Test
    @DisplayName("registerStudent Ok Integration Test")
    void registerStudentTestOk() throws  Exception{
        //Arrange
        List<SubjectDTO> subjects = List.of(
          new SubjectDTO("Programacion", 8.0),
          new SubjectDTO("Bases de Datos", 7.5)
        );
        StudentDTO studentDTO = new StudentDTO(3L, "Javier", "", 8.0, subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDTO = writer.writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDTO))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void registerStudentTestFail() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 56))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    @DisplayName("modifyStudent Ok Integration Test")
    void modifyStudentTestOk() throws  Exception{
        //Arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Programacion", 8.0)
        );
        StudentDTO studentDTO = new StudentDTO(3L, "Pepe", "", 8.0, subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDTO = writer.writeValueAsString(studentDTO);
        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDTO))
                .andDo(print())
                .andExpect(status().isOk());
    }
}