package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("IT02. Try to follow yourself - 400 Bad Request")
    void followYourself() throws Exception {
        MessageDTO responseMessageDTO = new MessageDTO("No te puedes seguir a tí mismo!");

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1, 1))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(("application/json")))
                .andExpect(jsonPath("$.message").value(responseMessageDTO.getMessage()));
    }

    @Test
    @DisplayName("IT03. Follow a user - OK")
    void followValidUser() throws Exception {
        String user = "nauhel";
        String userToFollow = "juancito";
        MessageDTO responseMessageDTO = new MessageDTO(user + " siguió a " + userToFollow + " correctamente!");

        //User id´s in Repository.UserRepository
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",2, 3))
                .andExpect(status().isOk())
                .andExpect(content().contentType(("application/json")))
                .andExpect(jsonPath("$.message").value(responseMessageDTO.getMessage()));
    }

    @Test
    @DisplayName("IT04. Unfollow a user - OK")
    void unfollowUser() throws Exception {
        //To do this test, I need to follow the user first.
        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 3));

        String user = "nauhel";
        String userToUnfollow = "juancito";
        MessageDTO responseMessageDTO = new MessageDTO(user + " dejo de seguir a " + userToUnfollow + " correctamente!");

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}",2,3))
                .andExpect(status().isOk())
                .andExpect(content().contentType(("application/json")))
                .andExpect(jsonPath("$.message").value(responseMessageDTO.getMessage()));
    }
}
