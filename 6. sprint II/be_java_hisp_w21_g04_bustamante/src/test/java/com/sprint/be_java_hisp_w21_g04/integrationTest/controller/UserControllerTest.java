package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Test integración - Donde se consigue el numero de seguidores de un usuario")
    public void testUserFollowersCountEndpointPerfectCase() throws Exception {
        Integer userId = 1;
        mockMvc.perform(get("/users/{userId}/followers/count", userId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.followers_count").exists());
    }

    @Test
    @DisplayName("Test integración - Donde se consulta el numero de seguidores de un usuario que no existe")
    public void testUserFollowersCountEndpointSadCase() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count", 2000)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Test integración - Donde se realiza la acción de seguir a un usuario")
    public void testUserFollowEndpoint() throws Exception {
        Integer userId = 1; // Replace with a valid user ID for testing
        Integer userIdToFollow = 2; // Replace with a valid user ID for testing

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").exists());
    }
}
