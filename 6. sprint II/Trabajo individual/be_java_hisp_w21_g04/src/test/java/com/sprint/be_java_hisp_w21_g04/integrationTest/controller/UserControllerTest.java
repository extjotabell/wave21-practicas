package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test que espera excepción al obtener los seguidos de un usuario que no sigue a nadie")
    public void testGetFollowedByIdWithFollowedThrowsException() throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list",1)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("El usuario no sigue a ningún vendedor"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("Test de caso exitoso al obtener los seguidos de un usuario")
    public void testGetFollowedByIdWithFollowedOk() throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list",4)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("Test que espera excepción al obtener los seguidores de un usuario que no tiene seguidores")
    public void testGetFollowersByIdWithFollowersThrowsException() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list",1)
                        .param("order", "name_asc")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("No se encontraron seguidores para el vendedor"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("Test que espera excepción al obtener los seguidos de un usuario cuando el ordenamiento es inválido")
    public void testGetFollowedByIdWithInvalidSortThrowsException() throws Exception {
        mockMvc.perform(get("/users/{userId}/followed/list",1)
                        .param("order", "name_")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("Ordenamiento invalido"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("Test que espera excepción al obtener los seguidores de un usuario cuando el ordenamiento es inválido")
    public void testGetFollowersByIdWithInvalidSortThrowsException() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/list",1)
                        .param("order", "name_")
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("Ordenamiento invalido"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }


    @Test
    @DisplayName("Test que espera excepción al intentar dejar de seguir a un usuario que no se sigue")
    public void testUserUnfollowThrowsException() throws Exception {
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",1,2)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("No se están siguiendo."))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("Test de caso exitoso al obtener la cantidad de seguidores de un usuario")
    public void testUserFollowersCountWithFollowers() throws Exception {
        mockMvc.perform(get("/users/{userId}/followers/count",5)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.user_id").value(5))
                .andExpect(jsonPath("$.followers_count").value(1))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("Test que espera una excepción cuando un usuario se intenta seguir a sí mismo")
    public void testUserFollowThrowsException() throws Exception {
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}",1,1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("No puedes seguirte a ti mismo."))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();
    }

}
