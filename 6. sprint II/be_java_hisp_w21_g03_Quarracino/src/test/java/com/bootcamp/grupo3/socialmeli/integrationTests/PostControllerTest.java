package com.bootcamp.grupo3.socialmeli.integrationTests;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.fasterxml.jackson.databind.*;
/*import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;*/
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Validar la creación de un post")
    void createPostTest() throws Exception {

        LocalDate fecha = LocalDate.of(2023, 6, 5);

        PostDTO post = new PostDTO(1, fecha, new ProductDTO(1,"pelota","futbol", "adidas", "blanca", "pelota de futbol"), 1, 10000.00);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String payloadJson = writer.writeValueAsString(post);

        mockMvc.perform(post("/products/post")
                .content(payloadJson)
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Post agregado exitosamente con id: 1"))
                .andReturn();
    }

    @Test
    @DisplayName("Validar la fecha en la creación de un posteo - no puede estar vacía")
    void createPostWithoutDateThrowExTest() throws Exception {
        PostDTO post = new PostDTO(1, null, new ProductDTO(1,"pelota","futbol", "adidas", "blanca", "pelota de futbol"), 1,10000.00);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(post);

        mockMvc.perform(post("/products/post")
                        .content(payloadJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("La fecha no puede estar vacía."))
                .andReturn();
    }

    @Test
    @DisplayName("Validar que el productName no pueda tener caracter especial en la creación de un posteo")
    void createPostWithEspecialCharacterThrowExTest() throws Exception {

        LocalDate fecha = LocalDate.of(2023, 6, 5);
        PostDTO post = new PostDTO(1, fecha , new ProductDTO(1,"pelota!","futbol", "adidas", "blanca", "pelota de futbol"), 1,10000.00);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String payloadJson = writer.writeValueAsString(post);

        mockMvc.perform(post("/products/post")
                        .content(payloadJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El nombre no puede poseer caracteres especiales."))
                .andReturn();
    }
}