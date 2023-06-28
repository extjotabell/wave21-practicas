package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    PostDTO postDTOMock;

    @BeforeEach
    void setUp() {
        writer=new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .setDateFormat(new StdDateFormat().withColonInTimeZone(true))
                .registerModule(new JSR310Module())
                .writer();
        postDTOMock=mockPostDTO();
    }

    @Test
    void createPost_withValidParams_isOk() throws Exception {
        String jsonPayload=writer.writeValueAsString(postDTOMock);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Post agregado exitosamente con id: 1"))
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andReturn();
    }

    @Test
    void createPost_withInvalidParams_throwsException() throws Exception {
        postDTOMock.setCategory(null);
        postDTOMock.setPrice(null);
        String jsonPayload=writer.writeValueAsString(postDTOMock);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof MethodArgumentNotValidException))
                .andReturn();
    }

    @Test
    void listPostOfFollowers_withValidParams_isOk() throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list",1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    void listPostOfFollowers_withInvalidParams_throwsException() throws Exception {
        mockMvc.perform(get("/products/followed/{userId}/list",3445)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserNotFoundException))
                .andReturn();
    }

    private PostDTO mockPostDTO() {
        ProductDTO productForThePost = new ProductDTO(1, "Silla Gamer", "Muebles", "Razer", "Verde", "Nada");

        LocalDate mockLocalDate = LocalDate.parse("23/10/2022", DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        return new PostDTO(1, mockLocalDate, productForThePost,2,100.5);
    }
}