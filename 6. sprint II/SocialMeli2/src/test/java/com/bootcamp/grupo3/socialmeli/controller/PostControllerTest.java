package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.ErrorDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class PostControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static ObjectWriter writer;
    private static ProductDTO product;

    @BeforeAll
    public static void init() throws JsonProcessingException {
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .writer();

        product = new ProductDTO(1, "PocoPhone", "Celular", "Xiaomi", "Negro", "alto Celu");

        LocalDate time = LocalDate.now();

    }

    @Test
    @DisplayName("T-0009 / Verifica que se pueda crear un post correctamente / Permite continuar con normalidad.")
    public void createPost_Ok() throws Exception {
        MessageDTO message = new MessageDTO("Post agregado exitosamente con id: 2");
        String post = writer.writeValueAsString(new PostDTO(1, LocalDate.now(), product, 100, 2500D));

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(post))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(message)));
    }

    @Test
    @DisplayName("T-0009 / Verifica que se pueda crear un post correctamente / Usuario no existe.")
    public void createPost_UserDoesntExist() throws Exception {
        MessageDTO message = new MessageDTO("No se ha encontrado el usuario");
        String postUserDoesntExist = writer.writeValueAsString(new PostDTO(30, LocalDate.now(), product, 100, 2500D));

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postUserDoesntExist))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(message)));
    }

    @Test
    @DisplayName("T-0009 / Verifica que se pueda crear un post correctamente / Post invalido.")
    public void createPost_InvalidPost() throws Exception {
        String invalidPost = writer.writeValueAsString(new PostDTO(-1, LocalDate.now(), product, 100, 10_000_001D));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPost))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();

        ErrorDTO resultError = new ObjectMapper().readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorDTO.class);

        Assertions.assertTrue(resultError.getDescription().contains("El id del usuario debe ser mayor a cero"));
        Assertions.assertTrue(resultError.getDescription().contains("El precio máximo por producto es de 10.000.000"));
    }

    @Test
    @DisplayName("T-0009 / Verifica que se pueda crear un post correctamente / Post invalido (nulls).")
    public void createPost_InvalidPost_Nulls() throws Exception {
        String invalidPostNulls = writer.writeValueAsString(new PostDTO(null, null, null, null, null));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidPostNulls))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andReturn();

        ErrorDTO resultError = new ObjectMapper().readValue(result.getResponse().getContentAsString(StandardCharsets.UTF_8), ErrorDTO.class);

        Assertions.assertTrue(resultError.getDescription().contains("El id del usuario no puede estar vacío."));
        Assertions.assertTrue(resultError.getDescription().contains("La fecha no puede estar vacía."));
        Assertions.assertTrue(resultError.getDescription().contains("El producto no puede estar vacío."));
        Assertions.assertTrue(resultError.getDescription().contains("La categoría no puede estar vacía."));
        Assertions.assertTrue(resultError.getDescription().contains("El precio no puede estar vacío."));
    }

    @Test
    @DisplayName("T-0010 / Verifica la lista de post de usuarios seguidos / Permite continuar con normalidad.")
    public void listPostOfFollowers_Ok() throws Exception {
        UserPostListDTO expectedResponse = new UserPostListDTO(2, List.of(new PostDTO(1, LocalDate.now(), product, 100, 2500D)));

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", 2))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expectedResponse)));
    }
}
