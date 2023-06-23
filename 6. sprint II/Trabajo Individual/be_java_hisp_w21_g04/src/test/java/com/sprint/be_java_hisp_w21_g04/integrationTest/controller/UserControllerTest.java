package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
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
    void postOk() throws Exception {

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
