package com.sprint.be_java_hisp_w21_g04.integration;

import com.sprint.be_java_hisp_w21_g04.controller.UserController;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.service.user.IUserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService userService;

    @Test
    public void testUserFollow() throws Exception {
        // Simular el comportamiento del servicio
        when(userService.followUser(anyInt(), anyInt())).thenReturn(new ResponseDto("User followed successfully"));

        // Realizar la solicitud POST al controlador
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/1/follow/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verificar la respuesta
        String responseContent = mvcResult.getResponse().getContentAsString();
        // Realizar las aserciones necesarias sobre la respuesta
    }

    @Test
    public void testUserFollowersCountDto() throws Exception {
        // Simular el comportamiento del servicio
        UserFollowersCountDto followersCountDto = new UserFollowersCountDto();
        when(userService.getFollowersCount(anyInt())).thenReturn(followersCountDto);

        // Realizar la solicitud GET al controlador
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/count"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verificar la respuesta
        String responseContent = mvcResult.getResponse().getContentAsString();
        // Realizar las aserciones necesarias sobre la respuesta
    }

    @Test
    public void testUserUnfollow() throws Exception {
        // Simular el comportamiento del servicio
        when(userService.unfollowUser(anyInt(), anyInt())).thenReturn(new ResponseDto("User unfollowed successfully"));

        // Realizar la solicitud POST al controlador
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/users/1/unfollow/2"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verificar la respuesta
        String responseContent = mvcResult.getResponse().getContentAsString();
        // Realizar las aserciones necesarias sobre la respuesta
    }

    @Test
    public void testGetFollowersById() throws Exception {
        // Simular el comportamiento del servicio
        FollowersResponseDto responseDto = new FollowersResponseDto();
        when(userService.getFollowersById(anyInt())).thenReturn(responseDto);

        // Realizar la solicitud GET al controlador
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followers/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verificar la respuesta
        String responseContent = mvcResult.getResponse().getContentAsString();
        // Realizar las aserciones necesarias sobre la respuesta
    }

    @Test
    public void testGetFollowedById() throws Exception {
        // Simular el comportamiento del servicio
        FollowedResponseDto responseDto = new FollowedResponseDto();
        when(userService.getFollowedById(anyInt())).thenReturn(responseDto);

        // Realizar la solicitud GET al controlador
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/users/1/followed/list"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Verificar la respuesta
        String responseContent = mvcResult.getResponse().getContentAsString();
        // Realizar las aserciones necesarias sobre la respuesta
    }
}
