package com.sprint.be_java_hisp_w21_g04.integration;

import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.be_java_hisp_w21_g04.dto.response.ErrorDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserNotFoundDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test 001 - Endpoint de seguir a un usuario: Usuario seguido correctamente.")
    void userFollow() throws Exception {
        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 3, 7))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 001 - Endpoint de seguir a un usuario: Usuario ya seguido.")
    void userAlreadyFollowed() throws Exception {
        ErrorDto errorDTO = new ErrorDto("Ya se están siguiendo.", 400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 4, 3))
                .andExpect(status().isBadRequest())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 001 - Endpoint de seguir a un usuario: Usuario no encontrado.")
    void userNotFound() throws Exception {
        UserNotFoundDto errorDTO = new UserNotFoundDto("Usuario no encontrado.", 404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 4, 555))
                .andExpect(status().isNotFound())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 001 - Endpoint de seguir a un usuario: No puedes seguirte a tí mismo")
    void userCantSelfFollow() throws Exception {
        ErrorDto errorDTO = new ErrorDto("No puedes seguirte a ti mismo.", 400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 4, 4))
                .andExpect(status().isBadRequest())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 002 - Endpoint de dejar de seguir usuario.")
    void userUnfollow() throws Exception {
        MvcResult result = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 4, 5))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 002 - Endpoint de dejar de seguir a un usuario: Usuario no seguido.")
    void userUnfollowNotFound() throws Exception {
        UserNotFoundDto errorDTO = new UserNotFoundDto("Usuario no encontrado.", 404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 4, 6666))
                .andExpect(status().isNotFound())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 002 - Endpoint de dejar de seguir a un usuario: No puedes dejar de seguirte a ti mismo.")
    void userUnfollowNotAllowed() throws Exception {
        ErrorDto errorDTO = new ErrorDto("No puedes dejar de seguirte a ti mismo.", 400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 4, 4))
                .andExpect(status().isBadRequest())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 002 - Endpoint de dejar de seguir a un usuario: No puedes dejar de seguir a alguien que no sigues.")
    void userUnfollowNotFollowing() throws Exception {
        ErrorDto errorDTO = new ErrorDto("No se están siguiendo.", 400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 1, 4))
                .andExpect(status().isBadRequest())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - userFollowersCountDto")
    void userFollowersCount() throws Exception {
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/count", 1))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - userFollowersCountDto: Usuario no encontrado.")
    void userFollowersCountUserNotFound() throws Exception {
        UserNotFoundDto errorDTO = new UserNotFoundDto("Usuario no encontrado.", 404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/count", 500))
                .andExpect(status().isNotFound())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - getFollowersById")
    void userFollowersById() throws Exception {
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", 3))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - userFollowersCountDto: getFollowersById no se encontraron seguidores para el vendedor")
    void userFollowersByIdWithoutFollowers() throws Exception {
        ErrorDto errorDTO = new ErrorDto("No se encontraron seguidores para el vendedor", 404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", 1))
                .andExpect(status().isNotFound())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - getFollowersById with order")
    void userFollowersByIdWithOrderAsc() throws Exception {
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", 3).param("order", "name_asc"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - getFollowersById with order")
    void userFollowersByIdWithOrderDesc() throws Exception {
        MvcResult result = mockMvc.perform(get("/users/{userId}/followers/list", 3).param("order", "name_desc"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - getFollowedById")
    void userFollowedById() throws Exception {
        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", 3))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - userFollowersCountDto: getFollowersById no se encontraron seguidores para el vendedor")
    void userFollowedByIdWithoutFollowers() throws Exception {
        ErrorDto errorDTO = new ErrorDto("El usuario no sigue a ningún vendedor", 404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String errorExpected = writer.writeValueAsString(errorDTO);
        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", 8))
                .andExpect(status().isNotFound())
                .andDo(mvcResult -> {
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();

        assertEquals(errorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - getFollowersById with order")
    void userFollowedByIdWithOrderAsc() throws Exception {
        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", 3).param("order", "name_asc"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("Test 003 - getFollowersById with order")
    void userFollowedByIdWithOrderDesc() throws Exception {
        MvcResult result = mockMvc.perform(get("/users/{userId}/followed/list", 3).param("order", "name_desc"))
                .andExpect(status().isOk())
                .andReturn();

        System.out.println(result.getResponse().getContentAsString());
    }

}
