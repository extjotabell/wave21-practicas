package com.meli.obtenerdiploma.integrationTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    void registerStudent() throws Exception {
        StudentDTO mockeado = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(mockeado);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void registerStudentWithoutSubjects() throws Exception {
        StudentDTO mockeado = new StudentDTO(9L, "Juan", new ArrayList<>());
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(mockeado);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La lista de materias no puede estar vacia."))
                .andReturn();
    }

    @Test
    void getStudent() throws Exception {
        //Arrange
        StudentDTO mockeado = new StudentDTO(1L, "Juan",null,null, Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String responseJsonAsString = writer.writeValueAsString(mockeado);

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                //.andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJsonAsString,mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getStudentNotFoundID() throws Exception {
        //Arrange
        StudentDTO mockeado = new StudentDTO(1L, "Juan",null,null, Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String responseJsonAsString = writer.writeValueAsString(mockeado);

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}", 8))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 8 no se encuetra registrado."))
                .andReturn();
    }

    @Test
    void modifyStudent() throws Exception {
        StudentDTO mockeado = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(mockeado);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void removeStudent() throws Exception {
        StudentDTO mockeado = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(mockeado);

        mockMvc.perform(get("/student/removeStudent/{id}",3L)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadJson))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    void listStudents() throws Exception {
        Set<StudentDTO> studentDTOSet = new HashSet<>();
        StudentDTO mockeado1 = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matematica", 9.0),
                new SubjectDTO("Fisica", 7.0),
                new SubjectDTO("Quimica", 6.0)
        ));
        StudentDTO mockeado2 = new StudentDTO(2L, "Pedro", null, null, Arrays.asList(
                new SubjectDTO("Matematica", 10.0),
                new SubjectDTO("Fisica", 8.0),
                new SubjectDTO("Quimica", 4.0)
        ));
        studentDTOSet.add(mockeado1);
        studentDTOSet.add(mockeado2);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String responseJsonAsString = writer.writeValueAsString(studentDTOSet);

        MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJsonAsString,mvcResult.getResponse().getContentAsString());
    }
}