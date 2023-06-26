package com.sprint.be_java_hisp_w21_g04.integrationtest;

import com.sprint.be_java_hisp_w21_g04.repository.user.UserRepositoryImpl;
import com.sprint.be_java_hisp_w21_g04.service.user.UserServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Test
    @DisplayName("Desarrollo Individual - Follow user Camino Feliz")
    void followUserPerfectCase() throws Exception {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Has seguido a JaneSmith"));
    }

    @Test
    @DisplayName("Desarrollo Individual - Follow user Camino Semi Triste")
    void followUserBadCase() throws Exception {
        // Arrange
        int userId = 3;
        int userIdToFollow = 1;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Ya se están siguiendo."));
    }

    @Test
    @DisplayName("Desarrollo Individual - Unfollow user Camino Feliz")
    void unfollowUserPerfectCase() throws Exception {
        // Arrange
        int userId = 4;
        int userIdToUnfollow = 3;

        // Act & Assert
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("Has dejado de seguir a MikeJohnson"));
    }




}




