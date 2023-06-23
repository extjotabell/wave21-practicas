package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.ResponseDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
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

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    @Test
    @DisplayName("Devuelve DTO con la cantidad de seguidores. (Caso exitoso)")
    void countFollowersOk() throws Exception {
        //ARRANGE
        Integer userId = 1;
        FollowersCountDTO expected = new FollowersCountDTO(userId, "Pepe", 3);

        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //ACT & ASSERT
        MvcResult result = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andReturn();
    }

    @Test
    @DisplayName("Devuelve una excepcion cuando no se encuentra el usuario. (Caso no exitoso)")
    void countFollowersException() throws Exception {
        //ARRANGE
        Integer userId = 12222;
        ErrorDTO errorDTO = new ErrorDTO("No se encontro el usuario con el ID" + userId);
        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(errorDTO));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //ACT & ASSERT
        MvcResult result = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andReturn();
    }

    @Test
    @DisplayName("Devuelve un DTO cuando se sigue correctamente a un usuario. (Caso exitoso)")
    void followOk() throws Exception {
        //ARRANGE
        Integer userId = 2;
        Integer userIdToFollow = 1;
        ResponseDTO expected =  new ResponseDTO("Accion realizada con exito.", 200);
        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //ACT & ASSERT
        MvcResult result = mockMvc.perform(request
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andReturn();
    }

    @Test
    @DisplayName("Devuelve un DTO cuando el usuario no es un vendedor. (Caso no exitoso)")
    void followNoOk() throws Exception {
        //ARRANGE
        Integer userId = 1;
        Integer userIdToFollow = 2;
        ErrorDTO errorDTO = new ErrorDTO("El usuario no es un vendedor...");
        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(errorDTO));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //ACT & ASSERT
        MvcResult result = mockMvc.perform(request
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andReturn();
    }

    @Test
    @DisplayName("Devuelve un DTO cuando el usuario no existe. (Caso no exitoso)")
    void followNoOkUserNotFound() throws Exception {
        //ARRANGE
        Integer userId = 1;
        Integer userIdToFollow = 22;
        ErrorDTO errorDTO = new ErrorDTO("Usuarios no encontrados...");
        //REQUEST
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(errorDTO));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //ACT & ASSERT
        MvcResult result = mockMvc.perform(request
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentExpected)
                .andExpect(contentTypeExpected)
                .andReturn();
    }


}
