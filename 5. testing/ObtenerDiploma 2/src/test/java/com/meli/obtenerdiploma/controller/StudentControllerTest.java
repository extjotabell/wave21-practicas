package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
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

    @Mock
    IStudentService _iStudentService;

    @InjectMocks
    StudentController _studentController;

    //Test get methods

    @Test
    @DisplayName("US0001 - getStudent Integration Test")
    void getStudentTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"));
    }

    @Test
    @DisplayName("US0002 - listStudents Integration Test")
    void listStudentsTest() throws  Exception {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(_iStudentService.getAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = _studentController.listStudents();

        // assert
        verify(_iStudentService, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }

    @Test
    @DisplayName("US0003 - removeStudent Ok Integration Test")
    void removeStudentTestOk() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        mockMvc.perform(get("/student/removeStudent/{id}", 2L))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("US0004 - removeStudent Fail Integration Test")
    public void removeStudentTestFail() throws Exception{
        mockMvc.perform(get("/student/getStudent/{id}",78))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    //Test post methods

    @Test
    @DisplayName("US0005 - registerStudent Ok Integration Test")
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
    @DisplayName("US0006 - registerStudent fail Integration Test")
    void registerStudentTestFail() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 56))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"));
    }

    @Test
    @DisplayName("US007 - modifyStudent Ok Integration Test")
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
