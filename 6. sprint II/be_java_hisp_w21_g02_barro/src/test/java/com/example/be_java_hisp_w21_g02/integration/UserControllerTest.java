package com.example.be_java_hisp_w21_g02.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    int userIdInexistent = 999;
    int userIdNotSeller = 2;
    int userIdValid = 1;


    @Test
    @DisplayName("Integration Test US02 T-0010 01 - User not seller")
    void getFollowersCountFail() throws Exception{

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count",userIdNotSeller))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This user is not a seller"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Integration Test US01 T-0011 01 - User not exist on follow")
    void followUserNotExistFail() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userIdInexistent,userIdValid)
                    .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This ID doesn't correspond to any user"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Integration Test US01 T-0011 02 - User not seller on follow")
    void followUserNotSellerFail() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",userIdValid,userIdNotSeller)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This user is not a seller"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Integration Test US07 T-0012 01 - User not exist on unfollow")
    void unfollowUserNotExistFail() throws Exception {
        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",userIdInexistent,userIdValid)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This ID doesn't correspond to any user"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
