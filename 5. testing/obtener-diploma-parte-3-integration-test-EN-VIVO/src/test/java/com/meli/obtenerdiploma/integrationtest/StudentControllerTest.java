package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.NestedServletException;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer =  new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    public void registerStudentOKTest() throws Exception {
        // Arrange
        StudentDTO requestBodyDTO = new StudentDTO();
        requestBodyDTO.setStudentName("Jose");
        requestBodyDTO.setSubjects(Arrays.asList(new SubjectDTO("Fisica", 10D),
                new SubjectDTO("Matemática", 10D), new SubjectDTO("Música", 5D)));

        String requestJson = writer.writeValueAsString(requestBodyDTO);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(request).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void registerStudentNOKTest() throws Exception {
        // Arrange
        StudentDTO requestBodyDTO = new StudentDTO();
        requestBodyDTO.setStudentName("");
        requestBodyDTO.setSubjects(Arrays.asList(new SubjectDTO("Fisica", 10D),
                new SubjectDTO("Matemática", 10D), new SubjectDTO("Música", 5D)));


        String requestJson = writer.writeValueAsString(requestBodyDTO);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(request).andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void getStudentOKTest() throws Exception {
        // Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setMessage(null);
        studentDTO.setAverageScore(null);
        studentDTO.setSubjects(Arrays.asList(new SubjectDTO("Matemática",10.0),
                new SubjectDTO("Química", 4.0), new SubjectDTO("Física", 8.0)));

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher body = MockMvcResultMatchers.content().json(writer.writeValueAsString(studentDTO));

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}", 1L);
        mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 2L))
                .andDo(print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(body);
    }

    @Test
    public void getStudentNOKTest() throws Exception {
        assertThrows(NestedServletException.class, () ->{
            mockMvc.perform(MockMvcRequestBuilders.get("/student/getStudent/{id}", 3333L))
                    .andDo(print()).andReturn();
        });
    }

    @Test
    public void modifyStudentOKTest() throws Exception {
        // Arrange
        StudentDTO requestBodyDTO = new StudentDTO();
        requestBodyDTO.setStudentName("Jose");
        requestBodyDTO.setSubjects(Arrays.asList(new SubjectDTO("Fisica", 10D),
                new SubjectDTO("Matemática", 10D), new SubjectDTO("Música", 5D)));

        String requestJson = writer.writeValueAsString(requestBodyDTO);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(request).andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void modifyStudentNOKTest() throws Exception {
        // Arrange
        StudentDTO requestBodyDTO = new StudentDTO();
        requestBodyDTO.setStudentName("");
        requestBodyDTO.setSubjects(Arrays.asList(new SubjectDTO("Fisica", 10D),
                new SubjectDTO("Matemática", 10D), new SubjectDTO("Música", 5D)));

        String requestJson = writer.writeValueAsString(requestBodyDTO);

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        mockMvc.perform(request).andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void removeStudentOKTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", 1L))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void removeStudentNOKTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/removeStudent/{id}", "test"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().is4xxClientError());
    }

    @Test
    public void listStudentsOKTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON));
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].studentName").value("Jose"))
//                .andExpect(MockMvcResultMatchers.jsonPath("$[0].id").value(10L))
//                .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(22));
    }
}