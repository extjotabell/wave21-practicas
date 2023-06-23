package com.sprint.be_java_hisp_w21_g04.integration;

import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import org.apache.coyote.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test 001 PostController: getAll Posts")
    void postControllerGetAllPosts() throws Exception {
        MvcResult result = mockMvc.perform(get("/products/getAll"))
                .andExpect(status().isOk())
                .andReturn();
    }
/*
    @Test
    @DisplayName("Test createPost")
    void postControllerCreatePost() throws Exception {
        List<Post> mockResult = new ArrayList<>();
        int userId = 1;
        LocalDate date = LocalDate.of(2021, 1, 1);
        Product product1 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        PostResponseDto postResponseDto = new PostResponseDto(userId, date, product1, 10, 100.0);
        ResponseDto expectedResponse = new ResponseDto("Post agregado exitosamente");
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(expectedResponse);
        String responseJson = writer.writeValueAsString(postResponseDto);

        MvcResult result = mockMvc.perform(post("/products/post")
                .contentType("application/json")
                .content(jsonPayload))
            .andDo(mvcResult -> {
                System.out.println(mvcResult.getResponse().getContentAsString());
            })
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Post agregado exitosamente"))
            .andExpect(status().isOk())
            .andReturn();
        assertEquals(responseJson, result.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Test sellerFollowedListPosts")
    void postControllerSellerFollowedListPosts() throws Exception {
        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", 2))
                .andExpect(status().isOk())
                .andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }*/

    @Test
    @DisplayName("Test 002 - sellerFollowedListPosts: No hay publicaciones de los vendedores que sigues")
    void followerdUserPosts() throws Exception {
        ErrorDto errorDTO = new ErrorDto("Los vendedores que sigues no tienen publicaciones", 400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", 2))
                .andExpect(status().isBadRequest())
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
}
