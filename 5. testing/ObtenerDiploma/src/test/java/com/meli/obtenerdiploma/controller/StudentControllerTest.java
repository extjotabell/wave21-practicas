package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.dto.response.ResponseDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

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
        ResultMatcher contentType = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
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
}
