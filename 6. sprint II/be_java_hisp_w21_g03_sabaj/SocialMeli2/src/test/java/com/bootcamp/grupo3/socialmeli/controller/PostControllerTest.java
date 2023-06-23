package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("IT01. Create new post with valid data - OK")
    void createValidPost() throws Exception {
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JavaTimeModule())
                .writer();

        ProductDTO newProduct = new ProductDTO(
                123,
                "Silla Gamer",
                "Silla",
                "Asus",
                "Negro y Verde",
                "Silla en impecables condiciones poco uso");

        PostDTO payloadPostDTO = new PostDTO(3, LocalDate.now(), newProduct, 100, 250.50);
        MessageDTO responseMessageDTO = new MessageDTO("Post agregado exitosamente con id: 1");

        String payloadJSON = writer.writeValueAsString(payloadPostDTO);

        var request = MockMvcRequestBuilders.post("/products/post")
                .contentType("application/json")
                .content(payloadJSON);

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.message").value(responseMessageDTO.getMessage()));
    }
}
