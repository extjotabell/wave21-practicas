package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter writer;


    @BeforeEach
    void setUp(){
         writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .writer();
    }

    @Test
    @DisplayName("Integration Test Create Post - create post OK")
    void createPostTestOK() throws Exception {

        PostRequestDTO postRequestDTO = new PostRequestDTO(1, LocalDate.now(),new ProductDTO(1,"Bicycle","GT","Avalanche","Black","Bycicle to the city"), BigInteger.valueOf(3),200.0);

        String jsonPayLoad = writer.writeValueAsString(postRequestDTO);

        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonPayLoad))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration Test Create Post - post user not exists")
    void createPostTestUserNotExists() throws Exception {

        PostRequestDTO postRequestDTO = new PostRequestDTO(200, LocalDate.now(),new ProductDTO(1,"Bicycle","GT","Avalanche","Black","Bycicle to the city"), BigInteger.valueOf(3),200.0);

        String jsonPayLoad = writer.writeValueAsString(postRequestDTO);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayLoad))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(MockMvcResultMatchers.jsonPath( "error_message").value("This ID doesn't correspond to any user"));
    }
}
