package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.*;
import com.sprint.be_java_hisp_w21_g04.repository.user.UserRepositoryImpl;
import com.sprint.be_java_hisp_w21_g04.service.user.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Collections;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserServiceImpl userService;

    @MockBean
    UserRepositoryImpl userRepository;

    @Test
    public void testUserFollow() throws Exception {
        int userId = 1;
        int userIdToFollow = 2;

        User user = new User();
        user.setUserId(userId);
        User userToFollow = new User();
        userToFollow.setUserId(userIdToFollow);
        ResponseDto responseDto = new ResponseDto("Has seguido a " + userIdToFollow);

        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userRepository.findUserById(userIdToFollow)).thenReturn(userToFollow);
        when(userService.followUser(userId, userIdToFollow)).thenReturn(responseDto);

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Has seguido a " + userIdToFollow)));
        verify(userService, times(1)).followUser(userId, userIdToFollow);
    }

    @Test
    public void testUserFollowUserNotFoundException() throws Exception {
        int userId = 1;
        int userIdToFollow = 9999999;

        when(userService.followUser(userId, userIdToFollow)).thenThrow(new UserNotFoundException("Usuario no encontrado"));

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userToFollow}", userId, userIdToFollow))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("Usuario no encontrado")));
    }

    @Test
    public void testUserFollowUserAlreadyFollowedException() throws Exception {
        int userId = 1;
        int userIdToFollow = 4;
        when(userService.followUser(userId, userIdToFollow)).thenThrow(new UserAlreadyFollowedException("Ya se estan siguiendo."));

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userToFollow}", userId, userIdToFollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Ya se estan siguiendo.")));
    }

    @Test
    public void testUserFollowUserFollowNotAllowedException() throws Exception {
        int userId = 1;
        int userIdToFollow = 1;
        when(userService.followUser(userId, userIdToFollow)).thenThrow(new UserFollowNotAllowedException("No puedes seguirte a ti mismo."));

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/follow/{userToFollow}", userId, userIdToFollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("No puedes seguirte a ti mismo.")));
    }

    @Test
    public void testUserFollowersCountDto() throws Exception {
        int userId = 1;
        User user = new User();
        user.setUserId(userId);
        user.setUserName("Pedro");

        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUserId(userId);
        userFollowersCountDto.setUserName(user.getUserName());
        userFollowersCountDto.setFollowersCount(5);

        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userService.getFollowersCount(userId)).thenReturn(userFollowersCountDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(userFollowersCountDto.getUserId())))
                .andExpect(jsonPath("$.user_name", is(userFollowersCountDto.getUserName())))
                .andExpect(jsonPath("$.followers_count", is(userFollowersCountDto.getFollowersCount())));
        verify(userService, times(1)).getFollowersCount(userId);
    }

    @Test
    public void testUserFollowersCountUserNotFoundException() throws Exception {
        int userId = 9999999;

        UserNotFoundDto expectedResponse = new UserNotFoundDto();
        expectedResponse.setMessage("Usuario no encontrado.");
        expectedResponse.setStatusCode(404);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponseString = writer.writeValueAsString(expectedResponse);

        when(userService.getFollowersCount(userId)).thenThrow(new UserNotFoundException("Usuario no encontrado."));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/count", userId))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("Usuario no encontrado."))).andReturn();

        assertEquals(expectedResponseString, result.getResponse().getContentAsString());
    }

    @Test
    public void testUserUnfollow() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 2;

        User user = new User();
        user.setUserId(userId);
        User userToUnFollow = new User();
        userToUnFollow.setUserId(userIdToUnfollow);
        userToUnFollow.setUserName("Pedro");

        ResponseDto responseDto = new ResponseDto("Has dejado de seguir a " + userToUnFollow.getUserName());

        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userRepository.findUserById(userIdToUnfollow)).thenReturn(userToUnFollow);
        when(userService.unfollowUser(userId, userIdToUnfollow)).thenReturn(responseDto);


        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is(responseDto.getMessage()))).andReturn();
        verify(userService, times(1)).unfollowUser(userId, userIdToUnfollow);
    }

    @Test
    public void testUserUnfollowUserNotFoundException() throws Exception {
        int userId = 888888;
        int userIdToUnfollow = 999999;

        when(userService.unfollowUser(userId, userIdToUnfollow)).thenThrow(new UserNotFoundException("Usuario no encontrado."));

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("Usuario no encontrado.")));
    }

    @Test
    public void testUserUnfollowUserUnfollowNotAllowedException() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 1;

        when(userService.unfollowUser(userId, userIdToUnfollow)).thenThrow(new UserUnfollowNotAllowedException("No puedes dejar de seguirte a ti mismo."));

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("No puedes dejar de seguirte a ti mismo.")));
    }

    @Test
    public void testUserUnfollowUserNoFollowedException() throws Exception {
        int userId = 1;
        int userIdToUnfollow = 1;

        when(userService.unfollowUser(userId, userIdToUnfollow)).thenThrow(new UserNotFollowedException("No se están siguiendo."));

        mockMvc.perform(MockMvcRequestBuilders.post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("No se están siguiendo.")));
    }

    @Test
    public void testGetFollowersById() throws Exception {
        int userId = 1;
        User user = new User();
        user.setUserId(userId);
        user.setUserName("Pedro");
        user.setFollowed(Collections.emptyList());
        user.setFollowers(Collections.emptyList());

        FollowersResponseDto followersResponseDto = new FollowersResponseDto();
        followersResponseDto.setUserId(userId);
        followersResponseDto.setUserName(user.getUserName());
        followersResponseDto.setFollowers(Collections.emptyList());

        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userService.getFollowersById(userId)).thenReturn(followersResponseDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(user.getUserId())))
                .andExpect(jsonPath("$.user_name", is(user.getUserName())))
                .andExpect(jsonPath("$.followers", is(user.getFollowers())));
        verify(userService, times(1)).getFollowersById(userId);
    }

    @Test
    public void testGetFollowedById() throws Exception {
        int userId = 1;
        User user = new User();
        user.setUserId(userId);
        user.setUserName("Pedro");
        user.setFollowed(Collections.emptyList());
        user.setFollowers(Collections.emptyList());

        FollowedResponseDto followedResponseDto = new FollowedResponseDto();
        followedResponseDto.setUserId(userId);
        followedResponseDto.setUserName(user.getUserName());
        followedResponseDto.setFollowed(Collections.emptyList());

        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userService.getFollowedById(userId)).thenReturn(followedResponseDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(user.getUserId())))
                .andExpect(jsonPath("$.user_name", is(user.getUserName())))
                .andExpect(jsonPath("$.followed", is(user.getFollowers())));
        verify(userService, times(1)).getFollowedById(userId);
    }

    @Test
    void testGetFollowersByIdSortedAsc() throws Exception {
        int userId = 1;
        String order = "name_asc";
        User user = new User();
        user.setUserId(userId);
        user.setUserName("John Doe");


        UserResponseDto user2 = new UserResponseDto(2,"Alice" );

        UserResponseDto user3 = new UserResponseDto(3, "Bob");

        FollowersResponseDto followersResponseDto = new FollowersResponseDto();
        followersResponseDto.setUserId(userId);
        followersResponseDto.setUserName(user.getUserName());
        followersResponseDto.setFollowers(Arrays.asList(user2, user3));


        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userService.getFollowersByIdSorted(userId, order)).thenReturn(followersResponseDto);


        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(userId)))
                .andExpect(jsonPath("$.user_name", is(user.getUserName())))
                .andExpect(jsonPath("$.followers[0].user_id", is(user2.getUserId())))
                .andExpect(jsonPath("$.followers[0].user_name", is(user2.getUserName())))
                .andExpect(jsonPath("$.followers[1].user_id", is(user3.getUserId())))
                .andExpect(jsonPath("$.followers[1].user_name", is(user3.getUserName())));

        verify(userService, times(1)).getFollowersByIdSorted(userId, order);
    }

    @Test
    void testGetFollowersByIdSortedDesc() throws Exception {
        int userId = 1;
        String order = "name_desc";
        User user = new User();
        user.setUserId(userId);
        user.setUserName("John Doe");


        UserResponseDto user2 = new UserResponseDto(2,"Alice" );

        UserResponseDto user3 = new UserResponseDto(3, "Bob");

        FollowersResponseDto followersResponseDto = new FollowersResponseDto();
        followersResponseDto.setUserId(userId);
        followersResponseDto.setUserName(user.getUserName());
        followersResponseDto.setFollowers(Arrays.asList(user3, user2));


        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userService.getFollowersByIdSorted(userId, order)).thenReturn(followersResponseDto);


        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followers/list", userId).param("order", order))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(userId)))
                .andExpect(jsonPath("$.user_name", is(user.getUserName())))
                .andExpect(jsonPath("$.followers[0].user_id", is(user3.getUserId())))
                .andExpect(jsonPath("$.followers[0].user_name", is(user3.getUserName())))
                .andExpect(jsonPath("$.followers[1].user_id", is(user2.getUserId())))
                .andExpect(jsonPath("$.followers[1].user_name", is(user2.getUserName())));

        verify(userService, times(1)).getFollowersByIdSorted(userId, order);
    }

    @Test
    void testGetFollowedByIdSortedAsc() throws Exception {
        int userId = 1;
        String order = "name_asc";
        User user = new User();
        user.setUserId(userId);
        user.setUserName("John Doe");


        UserResponseDto user1 = new UserResponseDto(2, "Carlos");

        UserResponseDto user2 = new UserResponseDto(3, "Sandra");

        FollowedResponseDto followedResponseDto = new FollowedResponseDto();
        followedResponseDto.setUserId(userId);
        followedResponseDto.setUserName(user.getUserName());
        followedResponseDto.setFollowed(Arrays.asList(user1, user2));


        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userService.getFollowedByIdSorted(userId, order)).thenReturn(followedResponseDto);


        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(userId)))
                .andExpect(jsonPath("$.user_name", is(user.getUserName())))
                .andExpect(jsonPath("$.followed[0].user_id", is(user1.getUserId())))
                .andExpect(jsonPath("$.followed[0].user_name", is(user1.getUserName())))
                .andExpect(jsonPath("$.followed[1].user_id", is(user2.getUserId())))
                .andExpect(jsonPath("$.followed[1].user_name", is(user2.getUserName())));

        verify(userService, times(1)).getFollowedByIdSorted(userId, order);
    }

    @Test
    void testGetFollowedByIdSortedDesc() throws Exception {
        int userId = 1;
        String order = "name_desc";
        User user = new User();
        user.setUserId(userId);
        user.setUserName("John Doe");


        UserResponseDto user1 = new UserResponseDto(2, "Carlos");

        UserResponseDto user2 = new UserResponseDto(3, "Sandra");

        FollowedResponseDto followedResponseDto = new FollowedResponseDto();
        followedResponseDto.setUserId(userId);
        followedResponseDto.setUserName(user.getUserName());
        followedResponseDto.setFollowed(Arrays.asList(user2, user1));


        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userService.getFollowedByIdSorted(userId, order)).thenReturn(followedResponseDto);


        mockMvc.perform(MockMvcRequestBuilders.get("/users/{userId}/followed/list", userId).param("order", order))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id", is(userId)))
                .andExpect(jsonPath("$.user_name", is(user.getUserName())))
                .andExpect(jsonPath("$.followed[0].user_id", is(user2.getUserId())))
                .andExpect(jsonPath("$.followed[0].user_name", is(user2.getUserName())))
                .andExpect(jsonPath("$.followed[1].user_id", is(user1.getUserId())))
                .andExpect(jsonPath("$.followed[1].user_name", is(user1.getUserName())));

        verify(userService, times(1)).getFollowedByIdSorted(userId, order);
    }

}
