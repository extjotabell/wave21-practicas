package com.bootcamp.grupo3.socialmeli.integration;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    @DisplayName("Test integración - Agregar una nueva publicacion - OK")
    void PostNewPostOK() throws Exception {
        ProductDTO newProductDTO = new ProductDTO(1,
                "Silla Gamer LX12",
                "Silla Gamer",
                "Trust",
                "azul",
                "En perfectas condiciones");
        PostDTO newPost = new PostDTO(
                1,
                LocalDate.now(),
                newProductDTO,
                15,
                1500.50
        );
        String postPayload = this.writer.writeValueAsString(newPost);
        int expectedPostId = 1;
        var request = post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(postPayload);

        mockMvc.perform(request)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Post agregado exitosamente con id: " + expectedPostId));
    }
}
