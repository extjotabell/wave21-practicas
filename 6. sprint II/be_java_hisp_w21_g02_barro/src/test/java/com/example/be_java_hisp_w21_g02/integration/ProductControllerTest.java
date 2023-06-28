package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;


@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest{

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .registerModule(new JavaTimeModule())
            .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .writer();

    @Test
    @DisplayName("Integration Test US05 T-0009 01 - Post New Product")
    void postProductOK () throws Exception {

        // Arrange
        ProductDTO productDTO = new ProductDTO(100,"Silla Gamer","Gamer","Razer","Red","The Best");
        PostRequestDTO postRequestDTO = new PostRequestDTO(1, LocalDate.now(),productDTO, BigInteger.valueOf(400),3458.50);

        String payLoadDTO = writer.writeValueAsString(postRequestDTO);


        // Act & Assert
        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(payLoadDTO))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("Integration Test US05 T-0009 02 - Post New Product fails")
    void postProductFail () throws Exception {

        // Arrange
        ProductDTO productDTO = new ProductDTO(100,"Silla Gamer","Gamer","Razer","Red","The Best");
        PostRequestDTO postRequestDTO = new PostRequestDTO(1, LocalDate.now().plusDays(3),productDTO, BigInteger.valueOf(400),3458.50);

        String payLoadDTO = writer.writeValueAsString(postRequestDTO);


        // Act & Assert
        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payLoadDTO))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("Invalid date, It should be as Past or present date"))
                .andReturn();
    }


}
