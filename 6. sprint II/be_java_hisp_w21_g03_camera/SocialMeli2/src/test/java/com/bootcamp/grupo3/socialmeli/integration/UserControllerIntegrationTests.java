package com.bootcamp.grupo3.socialmeli.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test integración - Seguir a un usuario no seguido - OK")
    void followUserOk() throws Exception {
        String followerName = "mtato";
        String userToFollowName = "nauhel";
        String expectedResponseMessage = followerName + " siguió a " + userToFollowName + " correctamente!";
        var request = post("/users/{userId}/follow/{userIdToFollow}",1,2);

        mockMvc.perform(request)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value(expectedResponseMessage));
    }

    @Test
    @DisplayName("Test integración - Intentar seguirse a si mismo - Bad Request")
    void followSameUserBadRequest() throws Exception {
        String expectedResponseMessage = "No te puedes seguir a tí mismo!";
        var request = post("/users/{userId}/follow/{userIdToFollow}",1,1);

        mockMvc.perform(request)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(expectedResponseMessage));
    }

    @Test
    @DisplayName("Test integración - Dejar de seguir a un usuario no seguido - Bad Request")
    void unfollowUserNotBeingFollowedBadRequest() throws Exception {
        String userToUnfollowName = "nauhel";
        String expectedResponseMessage = "El usuario " + userToUnfollowName + " no se encuentra en tu lista de seguidos.";
        var request = post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2);

        mockMvc.perform(request)
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value(expectedResponseMessage));
    }
}
