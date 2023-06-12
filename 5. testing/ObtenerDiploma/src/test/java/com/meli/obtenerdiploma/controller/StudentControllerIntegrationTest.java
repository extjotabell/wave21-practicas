package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.dto.response.ResponseDTO;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockReset;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    @DisplayName("Registrar estudiante")
    public void registerStudentOK() throws Exception {
        //Arrange
        List<SubjectDTO> listMock = new ArrayList<>();
        listMock.add(new SubjectDTO("Matemática",9.0));
        listMock.add(new SubjectDTO("Física",7.0));

        StudentDTO studenRespose = new StudentDTO(1L,"Juan", null, null, listMock);

        //Act & Assert
        //Preparo lo que necesito que se valide
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/student/registerStudent");


        //Expected o Response
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        //ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        String payloadDto = writer.writeValueAsString(studenRespose);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(new ResponseDTO("Creacion realizada con exito!")));

        mockMvc.perform(request
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(payloadDto))
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andReturn();

    }

    @Test
    @DisplayName("Obtener estudiante a partir de un ID")
    public void getStudentOK() throws Exception {
        //Arrange
        Long idStudent = 1L;
        
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}", idStudent);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //Act
        MvcResult result = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                //.andExpect(contentTypeExpected)
                .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(idStudent))
                .andReturn();

        System.out.println("Student" + result.getResponse());
        //Assert
        assertEquals("application/json", result.getResponse().getContentType());
    }

    @Test
    @DisplayName("Lanzar excepsion cuando no encuentra al estudiante")
    public void getStudentNoOK() throws Exception{
        //Arrange
        Long idStudent = 21L;
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException","El alumno con Id " + idStudent +" no se encuetra registrado.");

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/getStudent/{id}", idStudent);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //Act
        MvcResult result = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value(errorDTO.getName()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value(errorDTO.getDescription()))
                .andReturn();

        //Assert
        assertEquals("application/json", result.getResponse().getContentType());
    }
    
    @Test
    @DisplayName("Modificacion de estudiante exitosa")
    public void modifyStudentOK() throws Exception {
        //Arrange
        List<SubjectDTO> listPayload = new ArrayList<>();
        listPayload.add(new SubjectDTO("Matemática",10.0));
        listPayload.add(new SubjectDTO("Programacion",1.0));

        StudentDTO studenPayload = new StudentDTO(1L,"Raul", null, null, listPayload);

        //Act
        //Preparo lo que necesito que se valide
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/student/modifyStudent");


        //Expected o Response
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        String payloadDto = writer.writeValueAsString(studenPayload);
        //ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(payloadDto));


        MvcResult mvcResult = mockMvc.perform(request
                .contentType(MediaType.APPLICATION_JSON)
                .content(String.valueOf(payloadDto))
        )
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                //.andExpect(contentExpected)
                .andExpect(contentType)
                .andReturn();

        // StandardCharsets.UTF_8 --> Realiza el correcto parseo a UTF_8

        //Assert
        assertEquals(payloadDto, mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Eliminacion de estudiante exitosa.")
    public void deleteStudentOK() throws Exception{
        //Arrange
        Long idStudent = 1L;

        //Act & Assert
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/removeStudent/{id}", idStudent);

        //Expected o Response
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentType)
                .andReturn();

    }

    @Test
    @DisplayName("Eliminacion de estudiante no exitosa.")
    public void deleteStudentNoOK() throws Exception{
        //Arrange
        Long idStudent = 1L;
        ErrorDTO errorDTO = new ErrorDTO("StudentNotFoundException", "El alumno con Id " + idStudent + " no se encuetra registrado.");

        //Act
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/removeStudent/{id}", idStudent);

        //Expected o Response
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        MvcResult mvcResult = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentType)
                .andReturn();

        //Assert
        assertEquals(writer.writeValueAsString(errorDTO), mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Obtener una lista de estudiantes completa.")
    public void getListStudentOk() throws Exception{

        //Arrange

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/listStudents");

        //Expected o Response
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Act
        MvcResult mvcResult = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentType)
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Set<StudentDTO> listStudent = new ObjectMapper().readValue(json, Set.class);

        //Assert
        assertNotEquals(0, listStudent.size());

    }

    @Test
    @DisplayName("Obtener lista vacia de estudiantes.")
    public void getListStudentsEmpty() throws Exception{
        //Arrange

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/listStudents");

        //Expected o Response
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        //Act
        MvcResult mvcResult = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentType)
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        Set<StudentDTO> listStudent = new ObjectMapper().readValue(json, Set.class);

        //Assert
        assertEquals(0, listStudent.size());
    }
}
