package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.repository.UserRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest

public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Integration Test Follow user - ok")
    void followUserOk() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,2))
                .andDo(print())
                .andExpect(status().isOk());
                //.andExpect(content().contentType("application/json"))
                //.andExpect(MockMvcResultMatchers.jsonPath( Stat).value(200))
    }

    @Test
    @DisplayName("Integration Test Follow - follower user not exists")
    void followUserUserNotExists() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",400,2))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                //.andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath( "error_message").value("This ID doesn't correspond to any user"));
    }

    @Test
    @DisplayName("Integration Test Follow user - user to follow not exists")
    void followUserUserToFollowNotExists() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,300))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                //.andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath( "error_message").value("This ID doesn't correspond to any user"));
    }

    @Test
    @DisplayName("Integration Test Follow user - user to follow is not a seller")
    void followUserUserToFollowIsNotASeller() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,3))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                //.andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath( "error_message").value("This user is not a seller"));
    }
}
