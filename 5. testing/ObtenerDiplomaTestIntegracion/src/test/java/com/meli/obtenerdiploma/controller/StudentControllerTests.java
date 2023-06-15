package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IStudentService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentControllerTests {

    @Autowired
    MockMvc mockMvc;
    @Mock
    IStudentService service;

    @InjectMocks
    StudentController controller;

    static StudentDAO studentDAO = new StudentDAO();
    StudentDTO student;


    @Test
    public void registerStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.registerStudent(stu);

        // assert
        verify(service, atLeastOnce()).create(stu);
    }

    @Test
    public void getStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        when(service.read(stu.getId())).thenReturn(stu);

        // act
        StudentDTO readStu = controller.getStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).read(stu.getId());
        assertEquals(stu, readStu);
    }

    @Test
    public void modifyStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.modifyStudent(stu);

        // assert
        verify(service, atLeastOnce()).update(stu);
    }

    @Test
    public void removeStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.removeStudent(stu.getId());

        // assert
        verify(service, atLeastOnce()).delete(stu.getId());
    }

    @Test
    public void listStudents() {
        // arrange
        Set<StudentDTO> students = TestUtilsGenerator.getStudentSet();
        when(service.getAll()).thenReturn(students);

        // act
        Set<StudentDTO> readStudents = controller.listStudents();

        // assert
        verify(service, atLeastOnce()).getAll();
        assertTrue(CollectionUtils.isEqualCollection(students, readStudents));
    }

    @Test
    public void registerStudentTestIntegrationOk() throws Exception {

        SubjectDTO matematicas = new SubjectDTO("Matematicas", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO ingles =   new SubjectDTO("Ingles",    2.0);

        StudentDTO student =new StudentDTO(1L, "Maru","El alumno " +
                "Maru ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(matematicas, musica, ingles) );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayLoad = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/registerStudent")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(jsonPayLoad))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void registerStudentTestIntegrationBadName() throws Exception {

        SubjectDTO matematicas = new SubjectDTO("Matematicas", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO ingles =   new SubjectDTO("Ingles",    2.0);

        StudentDTO studentBad =new StudentDTO(29L, "maru","El alumno " +
                "Maru ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(matematicas, musica, ingles) );


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayLoad = writer.writeValueAsString(studentBad);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayLoad))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void registerStudentTestIntegrationBadSubject() throws Exception {

        SubjectDTO matematicas = new SubjectDTO("matematicas", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO ingles =   new SubjectDTO("Ingles",    2.0);

        StudentDTO studentBad =new StudentDTO(1L, "Juan","El alumno " +
                "Maru ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(matematicas, musica, ingles) );


        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayLoad = writer.writeValueAsString(studentBad);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayLoad))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void getStudentIntegrationOK() throws Exception {

        mockMvc.perform(get("/student/getStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath( "$.studentName").value("Juan"))
                .andReturn();
    }

    @Test
    public void getStudentIntegrationStudentNotExists() throws Exception {

        mockMvc.perform(get("/student/getStudent/{id}",200))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath( "$.name").value("StudentNotFoundException"))
                .andReturn();
    }

    @Test
    public void modifyStudentOK() throws Exception {

        SubjectDTO matematicas = new SubjectDTO("Matematicas", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO ingles =   new SubjectDTO("Ingles",    2.0);

        student =new StudentDTO(1L, "Fran","El alumno " +
                "Fran ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(matematicas, musica, ingles) );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayLoad = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayLoad))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void modifyStudentBadName() throws Exception {

        SubjectDTO matematicas = new SubjectDTO("Matematicas", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO ingles =   new SubjectDTO("Ingles",    2.0);

        StudentDTO studentBad =new StudentDTO(25L, "fran","El alumno " +
                "Fran ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(matematicas, musica, ingles) );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayLoad = writer.writeValueAsString(studentBad);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayLoad))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void modifyStudentBadSubject() throws Exception {

        SubjectDTO matematicas = new SubjectDTO("matematicas", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO ingles =   new SubjectDTO("Ingles",    2.0);

        StudentDTO studentBad =new StudentDTO(25L, "Fran","El alumno " +
                "Fran ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(matematicas, musica, ingles) );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String jsonPayLoad = writer.writeValueAsString(studentBad);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayLoad))
                .andDo(print())
                .andExpect(status().is4xxClientError());
    }

    @Test
    public void removeIntegrationOK() throws Exception {

        mockMvc.perform(get("/student/removeStudent/{id}",1))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void removeIntegrationStudentNotExists() throws Exception {

        mockMvc.perform(get("/student/removeStudent/{id}",39))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void listStudentsIntegrationOK() throws Exception {
        Set<StudentDTO> listExpected =new HashSet<>();
        SubjectDTO matematicas = new SubjectDTO("matematicas", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO ingles =   new SubjectDTO("Ingles",    2.0);

        StudentDTO studentOK =new StudentDTO(1L, "Juan","El alumno " +
                "Juan ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(matematicas, musica, ingles) );

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        listExpected.add(studentOK);

        String jsonExpected = writer.writeValueAsString(listExpected);

       MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(jsonExpected,mvcResult.getResponse().getContentAsString());
    }
}
