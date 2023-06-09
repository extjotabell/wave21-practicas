package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@AutoConfigureMockMvc
@SpringBootTest
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    @DisplayName("Obtener estudiante con promedio")
    public void integrationTest1() throws Exception{

        //Arrange
        List<SubjectDTO> listMock = new ArrayList<>();
        listMock.add(new SubjectDTO("Matemática",9.0));
        listMock.add(new SubjectDTO("Física",7.0));
        listMock.add(new SubjectDTO("Química",6.0));

        StudentDTO studenRespose = new StudentDTO(1L,"Juan", "El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.", 7.333333333333333, listMock);
        //String payloadDto = writer.writeValueAsString(studenRespose); (Funciona pero Parsea mal algunos datos)

        //Act

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L);

        //Expected o Response
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(studenRespose));

        MvcResult mvcResult = mockMvc.perform(request) //Ejecutar la request
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected) // Comprobar que coincida el body
                .andExpect(contentTypeExpected) // Comprobar que coincida el status
                .andExpect(contentExpected) //Comprobar que sea igual al contenido esperado (contentType)
                .andReturn();

        //System.out.println("Result -> " + mvcResult.getResponse().getContentAsString());

        //Assert
       // assertEquals(payloadDto,mvcResult.getResponse().getContentAsString());

    }
}
