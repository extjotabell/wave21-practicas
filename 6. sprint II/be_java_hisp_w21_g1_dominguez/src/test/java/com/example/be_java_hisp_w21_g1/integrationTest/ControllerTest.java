package com.example.be_java_hisp_w21_g1.integrationTest;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.*;
import com.example.be_java_hisp_w21_g1.Model.Product;
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
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("US001 - POST - /users/{userId}/follow/{userIdToFollow} - BadPath")
    void userToFollowTestNonOk() throws Exception {

        ErrorDTO expected = new ErrorDTO("El usuario no es un vendedor...");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String errorExpected = writer.writeValueAsString(expected);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(errorExpected, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("US002 - GET - /users/{userId}/followers/count - HappyPath")
    void userFollowersCountOk() throws Exception {

        FollowersCountDTO response = new FollowersCountDTO(1, "Pepe", 2);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseExpected = writer.writeValueAsString(response);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseExpected, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US003 - GET - /users/{userId}/followers/list - HappyPath")
    void userFollowersListOk() throws Exception {

        FollowerListDTO response = new FollowerListDTO(1, "Pepe", List.of(
                new FollowUserDTO(2, "Pablo"),
                new FollowUserDTO(3, "Pedro")
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseExpected = writer.writeValueAsString(response);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseExpected, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US004 - GET - /users/{userId}/followed/list - HappyPath")
    void userFollowedListOk() throws Exception {

        FollowedListDTO response = new FollowedListDTO(1, "Pepe", List.of(
                new FollowUserDTO(2, "Pablo"),
                new FollowUserDTO(4, "USUARIO NUEVO")
        ));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String responseExpected = writer.writeValueAsString(response);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseExpected, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US005 - GET - /products/post - HappyPath")
    void postProductOk() throws Exception {

        ProductDTO product1 = new ProductDTO(1, "Producto1", "Type1", "Brand1", "Color1", "Notes1");

        PostProductDTO postProductDTO = new PostProductDTO(1, LocalDate.of(2023, 06, 04), product1, 1, 25.50);

        String response = "Se ha creado el post!";

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();

        String jsonPayload = writer.writeValueAsString(postProductDTO);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andReturn();

        assertEquals(response, mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US006 - GET - /products/followed/{user_id}/list - HappyPath")
    void postListByFollowedOk() throws Exception {

        Product product1 = new Product(1, "Producto1", "Type1", "Brand1", "Color1", "Notes1");
        Product product2 = new Product(2, "Producto2", "Type2", "Brand2", "Color2", "Notes2");

        PostBySellerDTO response = new PostBySellerDTO(1, new ArrayList<>());

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .writer();

        String jsonPayload = writer.writeValueAsString(response);

        MvcResult mvcResult = mockMvc.perform(get("/products/followed/{user_id}/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(jsonPayload, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("US007 - POST - /users/{userId}/unfollow/{userIdToUnfollow} - HappyPath")
    void unFollowOk() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""))
                .andExpect(jsonPath("$").doesNotExist());
    }

}
