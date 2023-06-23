package com.example.be_java_hisp_w21_g02.integration;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest

public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;


    @Test
    @DisplayName("Integration Test Follow user - ok")
    void followUserOk() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,10))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    @DisplayName("Integration Test Follow - follower user not exists")
    void followUserUserNotExists() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",400,10))
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
