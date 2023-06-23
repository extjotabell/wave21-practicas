package com.bootcamp.grupo3.socialmeli.integrationtest;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.xml.transform.Result;

@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    IUserRepository userRepository;
    @Autowired
    IUserService userService;
    ObjectWriter writer = new ObjectMapper().registerModule(new JavaTimeModule()).writer();

    @DisplayName("Test Integracion - Seguir a un usuario")
    @Test
    void followTest() throws Exception {

    //ARRANGE
        //me traigo los usuarios que se van a seguir para construir la response
        User user1 = userRepository.getUserByID(1).get();
        User user2 = userRepository.getUserByID(2).get();
        //response expected
        MessageDTO messageExpected = new MessageDTO(user1.getName()+ " siguió a "+ user2.getName()+ " correctamente!");
        String messageExpectedParsed = writer.writeValueAsString(messageExpected);
        // expected BODY - TYPE - STATUS
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(messageExpectedParsed);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        //ACT
        //request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/users/{userId}/follow/{userIdToFollow}",1,2)
                .contentType(MediaType.APPLICATION_JSON);


    //ASSERT
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(bodyExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @DisplayName(" Test Integracion - Dejar de Seguir a un usuario")
    @Test
    void unFollowtest() throws Exception {
        //ARRAGE
        User user1 = userRepository.getUserByID(1).get();
        User user2 = userRepository.getUserByID(2).get();
        User user3 = userRepository.getUserByID(3).get();
        //user1 SIGUE a user2 y a user3
        userService.follow(1,2);
        userService.follow(1,3);
        MessageDTO message = new MessageDTO(user1.getName() + " dejo de seguir a " + user3.getName() + " correctamente!");
        String messageParsed = writer.writeValueAsString(message);
        //ACT

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/users//{userId}/unfollow/{userIdToUnfollow}",1,3)
                .contentType(MediaType.APPLICATION_JSON)
                ;


        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher typeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(messageParsed);

        //ASSERT
        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(typeExpected)
                .andExpect(bodyExpected)
                .andDo(MockMvcResultHandlers.print());
    }



}
