package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integration Test US05 T-0009 01 - Ok Case")
    void createPostTestOk() throws Exception {

        PostRequestDTO postRequestDTO = new PostRequestDTO(1, LocalDate.now().minusDays(1),
                new ProductDTO(
                        4, "PS4", "Sony", "Videogames", "Black", "Note1"
                ), BigInteger.valueOf(300), 50D);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy())
                .writer();

        String payloadDTO = writer.writeValueAsString(postRequestDTO);
        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDTO))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration Test US05 T-0009 02- Null User Case")
    void createPostTestNullUser() throws Exception {
        PostRequestDTO postRequestDTO = new PostRequestDTO(null, LocalDate.now().minusDays(1),
                new ProductDTO(
                        4, "PS4", "Sony", "Videogames", "Black", "Note1"
                ), BigInteger.valueOf(300), 50D);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy())
                .writer();

        String payloadDTO = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDTO))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("User ID is required"))
                .andReturn();
    }

    @Test
    @DisplayName("Integration Test US05 T-0009 - Invalid Data")
    void createPostTestInvalidData() throws Exception {
        PostRequestDTO postRequestDTO = new PostRequestDTO(1, LocalDate.now().minusDays(1),
                new ProductDTO(
                        4, "PS4", "Sony", "", "Black", "Note1"
                ), BigInteger.valueOf(300), 50D);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy())
                .writer();

        String payloadDTO = writer.writeValueAsString(postRequestDTO);

        this.mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDTO))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("description").value("The type field is required"))
                .andReturn();
    }
}
