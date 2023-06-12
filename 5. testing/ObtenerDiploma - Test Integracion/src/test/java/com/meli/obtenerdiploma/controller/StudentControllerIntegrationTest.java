package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    static void beforeAll() {

        /*StudentDAO repo = new StudentDAO();
        SubjectDTO subject1 = new SubjectDTO("Math", 10D);
        SubjectDTO subject2 = new SubjectDTO("Science", 7D);
        SubjectDTO subject3 = new SubjectDTO("History", 9D);
        SubjectDTO subject4 = new SubjectDTO("Biology", 5D);

        List<SubjectDTO> subjects1 = Arrays.asList(subject1,subject2,subject3,subject4);
        List<SubjectDTO> subjects2 = Arrays.asList(subject1,subject4);


        StudentDTO studentDto = new StudentDTO(null, "Juan",null,null, new ArrayList<>());
        studentDto.setSubjects(subjects1);
        StudentDTO studentDto2 = new StudentDTO(null, "Pepe",null,null, new ArrayList<>());
        studentDto2.setSubjects(subjects2);


        repo.save(studentDto);
        repo.save(studentDto2);*/


    }


    // /registerStudent
    @Test
    public void testIntegrationRegisterStudent() throws Exception {

        StudentDTO studentDto = new StudentDTO(10L, "Juan",null,null, new ArrayList<>());


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadDto = writer.writeValueAsString(studentDto);
        MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
                        .contentType(APPLICATION_JSON)
                        .content(payloadDto))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(payloadDto,mvcResult.getResponse().getContentAsString());

    }

    @Test
    // /getStudent/{id}
    public void testIntegrationGetStudent() throws Exception{
        StudentDAO repo = new StudentDAO();
        SubjectDTO subject1 = new SubjectDTO("Math", 10D);
        SubjectDTO subject2 = new SubjectDTO("Science", 7D);
        SubjectDTO subject3 = new SubjectDTO("History", 9D);
        SubjectDTO subject4 = new SubjectDTO("Biology", 5D);

        List<SubjectDTO> subjects1 = Arrays.asList(subject1,subject2,subject3,subject4);
        List<SubjectDTO> subjects2 = Arrays.asList(subject1,subject4);


        StudentDTO studentDto = new StudentDTO(1L, "Juan",null,null, new ArrayList<>());
        studentDto.setSubjects(subjects1);
        StudentDTO studentDto2 = new StudentDTO(2L, "Pepe",null,null, new ArrayList<>());
        studentDto2.setSubjects(subjects2);


        repo.save(studentDto);
        repo.save(studentDto2);

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}",1L))
                .andExpect(status().isOk())
                .andReturn();

       String jsonResponse = mvcResult.getResponse().getContentAsString();

        ClassPathResource resource = new ClassPathResource("juan.json");
        String expectedJson = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        JSONAssert.assertEquals(expectedJson, jsonResponse, false);



    }



    ///removeStudent/{id}
    @Test
    public void testIntegrationRemoveStudent() throws Exception{
        //"/analyzeScores/{studentId}
        MvcResult mvcResult = mockMvc.perform(get("/student/removeStudent/{id}",1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.ret").value(true))
                .andReturn();
    }

    // /listStudents


}
