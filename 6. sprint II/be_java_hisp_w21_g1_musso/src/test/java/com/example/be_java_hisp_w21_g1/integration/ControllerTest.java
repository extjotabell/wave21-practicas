package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("US002 - Test happy path")
    public void followersCountOutputOk() throws Exception
    {
        this.mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.user_id").value(1))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers_count").value(2));
    }

    @Test
    @DisplayName("US002 - Test unhappy path")
    public void followersCountOutputNotOk() throws Exception
    {
       /* this.mockMvc.perform(get("/users/{userId}/followers/count", 8))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No se encontro el usuario con el ID8"));*/

        ErrorDTO error = new ErrorDTO("No se encontro el usuario con el ID8");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String result = writer.writeValueAsString(error);

        MvcResult response = mockMvc.perform(get("/users/{userId}/followers/count", 8))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(result,response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US003 -  /users/{userId}/followers/list")
    public void getFollowersOk() throws Exception
    {
        this.mockMvc.perform(get("/users/{userId}/followers/list", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_id").value(3))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[1].user_name").value("Pedro"));
    }

    @Test
    @DisplayName("US003 -  /users/{userId}/followers/list")
    public void getFollowersNotOK() throws Exception
    {
        ErrorDTO error = new ErrorDTO("No se encontro el usuario con el ID8");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String result = writer.writeValueAsString(error);

        MvcResult response = mockMvc.perform(get("/users/{userId}/followers/list", 8))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(result,response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("US - 005 Happy path")
    public void createPostOk() throws Exception
    {
        ProductDTO prod = new ProductDTO(1, "Silla gamer", "Gamer", "Racer", "Red and black", "Special edition");
        PostProductDTO post = new PostProductDTO(1, LocalDate.now(), prod, 100, 1500.5);

        SimpleModule module = new JavaTimeModule();
        JsonMapper writer = JsonMapper.builder()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .addModule(module)
                .build();


        String postJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postJson))
                .andDo(print())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Se ha creado el post!"))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("US - 005 unhappy path")
    public void createPostNotOk() throws Exception
    {
        ProductDTO prod = new ProductDTO(1, "Silla gamer", "Gamer", "Racer", "Red and black", "Special edition");
        PostProductDTO post = new PostProductDTO(8, LocalDate.now(), prod, 100, 1500.5);

        SimpleModule module = new JavaTimeModule();
        JsonMapper writer = JsonMapper.builder()
                .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                .addModule(module)
                .build();

        String postJson = writer.writeValueAsString(post);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                                                .contentType(MediaType.APPLICATION_JSON)
                                                .content(postJson))
                    .andDo(print())
                    .andExpect(content().contentType("application/json"))
                    .andExpect(status().is4xxClientError())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No se encontro el usuario con el ID8"))
                    .andReturn();
    }
}

