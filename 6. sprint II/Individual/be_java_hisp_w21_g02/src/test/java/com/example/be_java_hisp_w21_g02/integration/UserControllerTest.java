package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersListDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Integration Test US01 01 - User not exists")
    void userFollowSellerUserNotExists() throws Exception{
        int userIdNotExist = 99;
        int userIdExists = 2;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdNotExist, userIdExists))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This ID doesn't correspond to any user"));
    }

    @Test
    @DisplayName("Integration Test US01 02 - User to follow not seller")
    void userFollowSellerNotSeller() throws Exception{
        int userIdExists = 1;
        int userNotSeller = 2;
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userIdExists, userNotSeller))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This user is not a seller"));
    }

    @Test
    @DisplayName("Integration Test US02 01 - User not seller")
    void getFollowersCountFail() throws Exception{
        int userNotSeller = 2;
        mockMvc.perform(get("/users/{userId}/followers/count", userNotSeller))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This user is not a seller"));
    }

    @Test
    @DisplayName("Integration Test US07 01 - User not exist on unfollow")
    void unfollowUserNotExistFail() throws Exception {
        int userIdNotExists = 999;
        int userNotSeller = 2;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdNotExists, userNotSeller)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This ID doesn't correspond to any user"));
    }

    @Test
    @DisplayName("Integration Test US07 01 - User to unfollow not seller")
    void unfollowUserNotSellerFail() throws Exception {
        int userIdExists = 1;
        int userNotSeller = 2;
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userIdExists, userNotSeller)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This user is not a seller"));
    }

    @Test
    @DisplayName("Integration Test US03 01 - Get user followed list but user doesn't exists")
    void userGetFollowedListUserNotExists() throws Exception {
        int userIdNotExists = 999;
        mockMvc.perform(get("/users/{userId}/followed/list", userIdNotExists))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("We couldn't find a user with the mentioned ID"));
    }

    @Test
    @DisplayName("Integration Test US03 02 - Get user followed list")
    void userGetFollowedListUser() throws Exception {
        int userId = 1;

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
                .writer();

        FollowedListDTO expectedResult = new FollowedListDTO(1, "JavierRydel", new ArrayList<>());

        String expectedJson = writer.writeValueAsString(expectedResult);

        ResultMatcher expected = content().json(expectedJson);

        mockMvc.perform(get("/users/{userId}/followed/list", userId))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(expected);
    }

    @Test
    @DisplayName("Integration Test US03 02 - Get user followers list but is not a seller")
    void userGetFollowersListUserNotSeller() throws Exception {
        int userId = 1;

        mockMvc.perform(get("/users/{userId}/followers/list", userId))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("error_message").value("This user is not a seller"));


    }
}
