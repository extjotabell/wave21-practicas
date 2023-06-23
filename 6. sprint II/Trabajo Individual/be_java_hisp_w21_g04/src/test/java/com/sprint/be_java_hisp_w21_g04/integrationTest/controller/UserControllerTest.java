package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Siguiendo a un usuario con exito")
    void followUser() throws Exception {

        ResponseDto responseDto = new ResponseDto("Has seguido a JaneSmith");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(responseDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al seguir a un usuario que no existe")
    void followUserNotFound() throws Exception {

        UserNotFoundDto userNotFoundDto = new UserNotFoundDto("Usuario no encontrado.",404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(userNotFoundDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 100, 2))
                .andDo(print())
                .andExpect(status().is(404))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al seguir a un usuario que ya se sigue")
    void followUserAlreadyFollowed() throws Exception {

        ErrorDto errorDto = new ErrorDto("Ya se estÃ¡n siguiendo.",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 3, 1))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al seguirte a ti mismo")
    void followUserFollowNotAllowed() throws Exception {

        ErrorDto errorDto = new ErrorDto("No puedes seguirte a ti mismo.",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obtener numero de seguidores de un usuario con exito")
    void getFollowersCountOk() throws Exception{

        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto(3,"MikeJohnson",1);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(userFollowersCountDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener numero de seguidores de un usuario que no existe")
    void getFollowersCountUserNotFound() throws Exception{

        UserNotFoundDto userNotFoundDto = new UserNotFoundDto("Usuario no encontrado.",404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(userNotFoundDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", 30))
                .andDo(print())
                .andExpect(status().is(404))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Dejar de seguir a un usuario con exito")
    void unfollowUserOk() throws Exception {

        ResponseDto responseDto = new ResponseDto("Has dejado de seguir a MikeJohnson");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(responseDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 4, 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Exception al dejar de seguir a un usuario que no existe")
    void unfollowUserNotFound() throws Exception {

        UserNotFoundDto userNotFoundDto = new UserNotFoundDto("Usuario no encontrado.",404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(userNotFoundDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 4, 30))
                .andDo(print())
                .andExpect(status().is(404))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al dejar de seguirte a ti mismo")
    void unfollowUserUnfollowNotAllowed() throws Exception{

        ErrorDto errorDto = new ErrorDto("No puedes dejar de seguirte a ti mismo.",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 4, 4))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excecpcion cuando se intenta dejar de seguir a un usuario que no se esta siguiendo")
    void unfollowUserNotFollowed() throws Exception{

        ErrorDto errorDto = new ErrorDto("No se estÃ¡n siguiendo.",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", 4, 1))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obeteniendo lista de seguidores de un usuario con exito")
    void getFollowersOk() throws Exception {

        List<UserResponseDto> followers = Arrays.asList(new UserResponseDto(5, "DavidWilson"));

        FollowersResponseDto followersResponseDto = new FollowersResponseDto(4,"EmilyDavis",followers);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(followersResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista de seguidores de un usuario que no existe")
    void getFollowersNotFound() throws Exception {

        ErrorDto errorDto = new ErrorDto("No se encontraron seguidores para el vendedor",404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 10))
                .andDo(print())
                .andExpect(status().is(404))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista de seguidores de un usuario que no existe")
    void getFollowersUserNotFound() throws Exception {

        ErrorDto errorDto = new ErrorDto("Vendedor no registrado",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 40))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obteniendo lista de seguidores de un usuario ordenada por nombre de usuario de forma ascendente")
    void getFollowersByIdSortedAscOK() throws Exception {

        List<UserResponseDto> followers = Arrays.asList(new UserResponseDto(5, "DavidWilson"));

        FollowersResponseDto followersResponseDto = new FollowersResponseDto(4,"EmilyDavis",followers);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(followersResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 4)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obteniendo lista de seguidores de un usuario ordenada por nombre de usuario de forma descendente")
    void getFollowersByIdSortedDescOK() throws Exception {

        List<UserResponseDto> followers = Arrays.asList(new UserResponseDto(5, "DavidWilson"));

        FollowersResponseDto followersResponseDto = new FollowersResponseDto(4,"EmilyDavis",followers);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(followersResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 4)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista de seguidores de un usuario con un ordenamiento inxorrecto")
    void getFollowersByIdSortedNoOK() throws Exception {

        ErrorDto errorDto = new ErrorDto("Ordenamiento invalido",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 4)
                        .param("order", "name_des"))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista de seguidores de un usuario ordenanda que no existe")
    void getFollowersByIdSortedUserNotFound() throws Exception {

        ErrorDto errorDto = new ErrorDto("Vendedor no registrado",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 40)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista de seguidos de un usuario con exito")
    void getFollowedOk() throws Exception {

        List<UserResponseDto> followers = Arrays.asList(new UserResponseDto(1, "JohnDoe"));

        FollowedResponseDto followedResponseDto = new FollowedResponseDto(3,"MikeJohnson",followers);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(followedResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 3))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista de seguidos de un usuario que no sigue a ningun vendedor")
    void getFollowedNotFound() throws Exception {

        ErrorDto errorDto = new ErrorDto("El usuario no sigue a ningÃºn vendedor",404);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 10))
                .andDo(print())
                .andExpect(status().is(404))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista de seguidos de un usuario que no existe")
    void getFollowedUserNotFound() throws Exception {

        ErrorDto errorDto = new ErrorDto("Usuario no registrado",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 40))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }


    @Test
    @DisplayName("Obteniendo lista de seguidos de un usuario ordenada por nombre de usuario de forma ascendente")
    void getFollowedByIdSortedAscOK() throws Exception {

        List<UserResponseDto> followed = Arrays.asList(new UserResponseDto(1, "JohnDoe"));

        FollowedResponseDto followedResponseDto = new FollowedResponseDto(3,"MikeJohnson",followed);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(followedResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 3)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obteniedno lista de seguidos de un usuario ordenada por nombre de usuario de forma descendente")
    void getFollowedByIdSortedDescOK() throws Exception {

        List<UserResponseDto> followed = Arrays.asList(new UserResponseDto(1, "JohnDoe"));

        FollowedResponseDto followedResponseDto = new FollowedResponseDto(3,"MikeJohnson",followed);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(followedResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 3)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista de seguidos de un usuario con ordenamiento invalido")
    void getFollowedByIdSortedNoOK() throws Exception {

        ErrorDto errorDto = new ErrorDto("Ordenamiento invalido",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 4)
                        .param("order", "name_des"))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Excepcion al obtener lista ordenada de seguidos de un usuario que no existe")
    void getFollowedByIdSortedUserNotFound() throws Exception {

        ErrorDto errorDto = new ErrorDto("Usuario no registrado",400);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 40)
                        .param("order", "name_desc"))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }


}
