package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    StudentDTO studentDTOMock;

    @BeforeEach
    void setUp() {
        studentDTOMock= mockStudentDTO();
    }

    @Test
    void registerStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(studentDTOMock);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    void getStudent() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andReturn();

        Assertions.assertEquals(mvcResult.getResponse().getContentType(),"application/json");
    }

    @Test
    void getStudentThrowsException() throws Exception {
        mockMvc.perform(get("/student/getStudent/{id}", 2000L))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof StudentNotFoundException))
                .andReturn();
    }

    @Test
    void modifyStudent() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        studentDTOMock.setId(1L);
        String jsonPayload = writer.writeValueAsString(studentDTOMock);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(jsonPath("$").doesNotExist());
    }

    @Test
    @Disabled
    void removeStudent() throws Exception {
        mockMvc.perform(get("/student/removeStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").doesNotExist())
                .andReturn();
    }

    @Test
    void listStudents() throws Exception {
        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty())
                .andExpect(mvcResult -> mvcResult.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    private StudentDTO mockStudentDTO(){
        List<SubjectDTO> subjects= new ArrayList<>();
        SubjectDTO subject1= new SubjectDTO("Matematicas",6.5);
        SubjectDTO subject2= new SubjectDTO("Lengua",10d);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO student= new StudentDTO(4l,"Juan","No se",subjects.stream().collect(Collectors.averagingDouble(SubjectDTO::getScore)),subjects);
        return student;
    }
}