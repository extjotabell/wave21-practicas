package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.response.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.text.SimpleDateFormat;
import java.util.List;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    private static ObjectWriter writer;

    @BeforeAll
    public static void init() throws JsonProcessingException {
        writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .writer();
    }

    @Test
    @DisplayName("T-0011 / Verifica que se pueda seguir a un usuario correctamente correctamente / Permite continuar con normalidad.")
    public void follow_Ok() throws Exception {
        MessageDTO message = new MessageDTO("nauhel siguió a juancito correctamente!");

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 3)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(message)));
    }

    @Test
    @DisplayName("T-0011 / Verifica que se pueda seguir a un usuario correctamente correctamente / El usuario ya esta en la lista de seguidos.")
    public void follow_ThrowsUserAlreadyFollow() throws Exception {
        MessageDTO message = new MessageDTO("El usuario mtato ya es encuentra en tu lista de seguidos!");

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 2, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(message)));
    }

    @Test
    @DisplayName("T-0011 / Verifica que se pueda seguir a un usuario correctamente correctamente / No se puede dar auto follow")
    public void follow_ThrowsUserEquals() throws Exception {
        MessageDTO message = new MessageDTO("No te puedes seguir a tí mismo!");

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", 1, 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(message)));
    }

    @Test
    @DisplayName("T-0012 / Verifica que se pueda dejar de seguir a un usuario correctamente correctamente / Permite continuar con normalidad.")
    public void unfollow_Ok() throws Exception {
        MessageDTO message = new MessageDTO("juancito dejo de seguir a nauhel correctamente!");

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToFollow}", 3, 2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(message)));
    }

    @Test
    @DisplayName("T-0013 / Verifica que la lista de seguidores sea correcta / Permite continuar con normalidad.")
    public void getFollowers_Ok() throws Exception {
        UserFollowersListDTO expected = new UserFollowersListDTO(1, "mtato", List.of(new UserDTO(2, "nauhel")));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", 1))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expected)));
    }

    @Test
    @DisplayName("T-0014 / Verifica que la lista de seguidos sea correcta / Permite continuar con normalidad.")
    public void getFollowed_Ok() throws Exception {
        UserFollowedListDTO expected = new UserFollowedListDTO(1, "mtato", List.of(new UserDTO(2, "nauhel")));

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", 1))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expected)));
    }

    @Test
    @DisplayName("T-0015 / Verifica que la cantidad de seguidores sea correcta / Permite continuar con normalidad.")
    public void followersCount_Ok() throws Exception {
        UserFollowerCountDTO expected = new UserFollowerCountDTO(1, "mtato", 1);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", 1))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().json(writer.writeValueAsString(expected)));
    }
}
