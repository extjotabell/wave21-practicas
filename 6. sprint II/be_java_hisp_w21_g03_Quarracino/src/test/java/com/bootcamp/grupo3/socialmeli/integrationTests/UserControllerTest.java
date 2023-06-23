package com.bootcamp.grupo3.socialmeli.integrationTests;

import com.bootcamp.grupo3.socialmeli.dto.response.UserDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowersListDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("T-0001 / Verificar que el usuario pueda seguir a otro (US-0001)")
    void followTest() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("mtato siguió a nauhel correctamente!"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0001 / Verificar que el usuario pueda seguir a otro (US-0001) / No permite auto follow")
    void autoFollowThrowExTest() throws Exception {

        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1, 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No te puedes seguir a tí mismo!"))
                .andReturn();
    }

    //Se agregaron en el UserRepository los User Ramiro, Mer y Lucho para los siguientes test:

    @Test
    @DisplayName("T-0001 / Verificar que el usuario pueda seguir a otro (US-0001) / No permite re seguir")
    void followAlreadyFollowingThrowExTest() throws Exception {
        //Mer (id 5) ya sigue a Lucho (id 6)
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 5, 6))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El usuario lucho ya es encuentra en tu lista de seguidos!"))
                .andReturn();
    }

    @Test
    @DisplayName("T-0001 / Verificar que el usuario pueda seguir a otro (US-0001) / Usuario no existe")
    void FollowUserDoesntExistThrowExTest() throws Exception {
        // No hay usuario con id 8
        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 8, 1))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("No se ha encontrado el usuario"))
                .andReturn();
    }

    @Test
    @DisplayName("T-0002 / Verificar que el usuario a deje de seguir a otro. (US-0007)")
    void unfollowTest() throws Exception {
        //lucho (id 6) quiere dejar de seguir a mer (id 5)
        mockMvc.perform(post("/users/{userId}/unfollow/{userIdToFollow}", 6, 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("lucho dejo de seguir a mer correctamente!"))
                .andReturn();
    }

    @Test
    @DisplayName("T-0003 / Obtener lista de seguidos (US-0008)")
    void getFollowedTest() throws Exception {
        //Mer (id 5) sigue a Lucho (id 6) y a ramiro (id 4)
        UserFollowedListDTO expectedResult = new UserFollowedListDTO(5, "mer", List.of(
                new UserDTO(4, "ramiro"),
                new UserDTO(6, "lucho")));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String responseJsonAsString = writer.writeValueAsString(expectedResult);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followed/list", 5))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJsonAsString,mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-0004 / Obtener lista de seguidores (US-0008)")
    void getFollowersTest() throws Exception {
        //A ramiro (id 4) lo siguen mer (id 5) y lucho (id 6)
        UserFollowersListDTO expectedResult = new UserFollowersListDTO(4, "ramiro", List.of(
                new UserDTO(5, "mer"),
                new UserDTO(6, "lucho")));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String responseJsonAsString = writer.writeValueAsString(expectedResult);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJsonAsString,mvcResult.getResponse().getContentAsString());
    }
    @Test
    @DisplayName("T-0004 / Obtener lista de seguidores (US-0008)")
    void getFollowersAscOrderTest() throws Exception {
        //A ramiro (id 4) lo siguen mer (id 5) y lucho (id 6). Se desea ordenar por nombre ascendente
        UserFollowersListDTO expectedResult = new UserFollowersListDTO(4, "ramiro", List.of(
                new UserDTO(6, "lucho"),
                new UserDTO(5, "mer")));

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String responseJsonAsString = writer.writeValueAsString(expectedResult);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/list", 4)
                        .param("order", "name_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJsonAsString,mvcResult.getResponse().getContentAsString());
    }


    @Test
    @DisplayName("T-0007 / Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)")
    void getUserFollowersTest() throws Exception {
        //A ramiro (id 4) lo siguen 2 usuarios: mer (id 5) y lucho (id 6).
        UserFollowerCountDTO expectedResult = new UserFollowerCountDTO(4, "ramiro", 2);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String responseJsonAsString = writer.writeValueAsString(expectedResult);

        MvcResult mvcResult = mockMvc.perform(get("/users/{userId}/followers/count", 4))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJsonAsString,mvcResult.getResponse().getContentAsString());
    }
}