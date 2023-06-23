package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
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
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    ProductDTO productRequest;
    PostRequestDTO postRequest;

    @BeforeEach
    void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .writer();
        productRequest = new ProductDTO(1, "HyperX Allow FPS", "HyperX", "Teclado", "Iron Black","New keyboard for gaming");
        postRequest = new PostRequestDTO(1, LocalDate.now(), productRequest, BigInteger.valueOf(8000), 35000.25);
    }

    @Test
    @DisplayName("Integration Test US05 01 - Creation of Post is Ok")
    void createProductOk() throws Exception {
        // Arrange
        String payload = writer.writeValueAsString(postRequest);

        // Act & Assert
        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration Test US05 02 - Creation of Post fails with the Post's Date")
    void createProductFailsPostDate() throws Exception {
        // Arrange
        postRequest.setDate(LocalDate.now().plusDays(5));
        String payload = writer.writeValueAsString(postRequest);

        // Act & Assert
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("Invalid date, It should be as Past or present date"));
    }

    @Test
    @DisplayName("Integration Test US05 03 - Creation of Post fails with the Post's Price")
    void createProductFailsPostPrice() throws Exception {
        // Arrange
        postRequest.setPrice(null);
        String payload = writer.writeValueAsString(postRequest);

        // Act & Assert
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("Price is required"));
    }

    @Test
    @DisplayName("Integration Test US05 04 - Creation of Post fails with the Post's Product")
    void createProductFailsPostProduct() throws Exception {
        // Arrange
        postRequest.getProduct().setType("!nv@l!dN@m#");
        String payload = writer.writeValueAsString(postRequest);

        // Act & Assert
        mockMvc.perform(post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(payload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("The type field cannot have special characters"));
    }

    @Test
    @DisplayName("Integration Test US06 01 - Cannot get posts list")
    void getPostListUserNotExists() throws Exception {
        // Arrange
        int userId = 1;

        UserPostResponseDTO expectedResult = new UserPostResponseDTO(1, new ArrayList<>());
        String expectedJson = writer.writeValueAsString(expectedResult);
        ResultMatcher expected = content().json(expectedJson);
        // Act & Assert
        mockMvc.perform(get("/products/followed/{userId}/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(expected);
    }
}
