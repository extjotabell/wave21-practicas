package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import com.example.be_java_hisp_w21_g1.DTO.Error.ExceptionDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import net.bytebuddy.asm.Advice;
import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.LocalDate;


import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("[US - 0003] - Getting followers list - Happy Path")
    public void getFollowerList() throws Exception {
        var request = get("/users/{userId}/followers/list", 1);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("Pablo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value(2));
    }

    @Test
    @DisplayName("[US - 0003] - Getting followers list - Unhappy Path")
    public void getFollowerListForANonExisting() throws Exception {
        int nonExistingId = 99;

        ErrorDTO error = new ErrorDTO("No se encontro el usuario con el ID"+ nonExistingId);

        ObjectMapper writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule());

        String result = writer.writeValueAsString(error);

        MvcResult response = mockMvc.perform(get("/users/{userId}/followers/list", nonExistingId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(result,response.getResponse().getContentAsString());
    }

    @Test
    public void postWithValidationsNotOk() throws Exception {

        ErrorDTO error = new ErrorDTO("Color can't contain special characters");
        ErrorDTO error2 = new ErrorDTO("The date cannot be null");
        ExceptionDTO excDTP = new ExceptionDTO("The following errors were found: ", Arrays.asList(error.getMessage(),error2.getMessage()));

        PostProductDTO post = new PostProductDTO(1, null, new ProductDTO(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"), 100, 100d);
        SimpleModule module = new JavaTimeModule();
        JsonMapper writer = JsonMapper.builder()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .addModule(module)
                .build();

        String jsonPayload = writer.writeValueAsString(post);

        String responseJson = writer.writeValueAsString(excDTP);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(responseJson,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));

    }

    @Test
    public void testing() throws Exception {
        ProductDTO prod = new ProductDTO(2, "holis", "hola", "A brand", "A color", "A note");
        PostProductDTO post = new PostProductDTO(1, LocalDate.now(), prod, 1, 10.5);
        SimpleModule module = new JavaTimeModule();
        JsonMapper writer = JsonMapper.builder()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .addModule(module)
                .build();
        String postJson = writer.writeValueAsString(post);
        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andDo(print())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(status().isOk())
                .andReturn();
    }






}
