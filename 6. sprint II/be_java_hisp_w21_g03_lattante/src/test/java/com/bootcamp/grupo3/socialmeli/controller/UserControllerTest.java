package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.exception.UserEqualsException;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.MethodArgumentNotValidException;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    @BeforeEach
    void setUp() {
        writer=new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .setDateFormat(new StdDateFormat().withColonInTimeZone(true))
                .registerModule(new JSR310Module())
                .writer();


    }

    @Test
    void follow_withValidParams_isOk() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("mtato siguió a nauhel correctamente!"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    void follow_withValidParams_isBadRequest() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(result -> assertTrue(result.getResolvedException() instanceof UserEqualsException))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    void unfollow() {
    }

    @Test
    void getFollowed() {
    }

    @Test
    void getFollowers() {
    }

    @Test
    void getUserFollowers() {
    }
}