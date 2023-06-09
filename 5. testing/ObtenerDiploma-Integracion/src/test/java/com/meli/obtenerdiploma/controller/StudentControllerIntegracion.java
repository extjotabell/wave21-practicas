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
import org.springframework.http.MediaType;
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

public class StudentControllerIntegracion {

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
    @DisplayName("Integration test students 001 - Creation of new Student")
    public void testRegisterStudentIntegration() throws Exception{
        String jsonPayload = writer.writeValueAsString(_expectedStudent);

        mockMvc.perform(post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration test students 002 - Get student by id")
    public void testGetByIdStudent() throws Exception{
        String responseJson = writer.writeValueAsString(_expectedStudent);
        ResultMatcher expectedJson = content().json(responseJson);

        mockMvc.perform(get("/student/getStudent/{id}",_expectedStudent.getId()))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(expectedJson);
    }

    @Test
    @DisplayName("Integration test students 003 - Get student by id with non existent id")
    public void testGetByIdStudentWithException() throws Exception{
        mockMvc.perform(get("/student/getStudent/{id}",99999))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    @DisplayName("Integration test students 004 - Delete student by id")
    public void testDeleByIdStudent() throws Exception{
        mockMvc.perform(get("/student/removeStudent/{id}",_expectedStudent.getId()))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration test students 005 - Modify student by id")
    public void testModifyByIdStudent() throws Exception{
        _expectedStudent.setId(90L);
        mockMvc.perform(post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(writer.writeValueAsString(_expectedStudent)))
                .andDo(print())
                .andExpect(status().isOk());
    }

}
