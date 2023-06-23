package com.bootcamp.grupo3.socialmeli.controller;

import com.bootcamp.grupo3.socialmeli.dto.response.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;


@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer ;
    //Se inicializan los id de los usuarios previamente cargados en el repositorio de usuarios.
    private final int mtatoID  = 1;
    private final int nauhelID = 2;
    private final int juanID   = 3;
    private final int luchoID  = 4;
    private final int orneID   = 5;
    private final int randomID = 70;

    @BeforeAll
    static void init(){

        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
    }

    /***
     *          Escenario inicial para las pruebas
     *
     *    Usuario           Seguidores              Seguidos
     *    nauhel        mtato juansito orne         lucho orne
     *    orne              nauhel mtato            nauhel
     *    mtato                                     nauhel orne
     *    juansito                                  nauhel
     *    lucho             nauhel
     *  *******************************************************
     *  Este escenario fue cargado previamente en el repositorio de usuarios.
     *    ****/

    @Test
    @DisplayName("T-00010 Usuario mtato  va a seguir al usuario juansito, funcionamiento normal")
    void userFollowTest() throws Exception{
        //Arrange
        MessageDTO mensaje = new MessageDTO("mtato siguió a juancito correctamente!");
        String esperado = writer.writeValueAsString(mensaje);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .post("/users/{userId}/follow/{userIdToFollow}",mtatoID,juanID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    @DisplayName("T-00010 Usuario mtato va a seguir a un usuario inexistente, excepciòn por usuario invalido")
    void userFollowUnexistingUserTest() throws Exception{
        //Arrange
        MessageDTO mensaje = new MessageDTO("No se ha encontrado el usuario");
        String esperado = writer.writeValueAsString(mensaje);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .post("/users/{userId}/follow/{userIdToFollow}",mtatoID,randomID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-00010 Usuario mtato va a seguir a mtato , excepciòn por seguirse asimismo")
    void userFollowBySelfUserTest() throws Exception{
        //Arrange
        MessageDTO mensaje = new MessageDTO("No te puedes seguir a tí mismo!");
        String esperado = writer.writeValueAsString(mensaje);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .post("/users/{userId}/follow/{userIdToFollow}",mtatoID,mtatoID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andReturn();

        Assertions.assertEquals(esperado,result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    @DisplayName("T-00011 Usuario mtato (1) va a dejar de seguir al usuario a orne (5), funcionamiento correcto")
    void userUnfollowTest() throws Exception{
        //Arrange
        MessageDTO mensaje = new MessageDTO("mtato dejo de seguir a orne correctamente!");
        String esperado = writer.writeValueAsString(mensaje);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .post("/users/{userId}/unfollow/{userIdToUnfollow}",mtatoID,orneID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }


    @Test
    @DisplayName("T-00011Usuario mtato va a dejar de seguir al usuario lucho, pero no se encuentra en su lista de seguidos")
    void userUnfollowTestBad() throws Exception{
        //Arrange
        MessageDTO mensaje = new MessageDTO("El usuario luchoDelCampo no se encuentra en tu lista de seguidos.");
        String esperado = writer.writeValueAsString(mensaje);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .post("/users/{userId}/unfollow/{userIdToUnfollow}",mtatoID,luchoID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-00011 Usuario mtato (1) va a dejar de seguir al usuario a mtato (1), excepcion por similitud de usuario")
    void userUnfollowBySelfTest() throws Exception{
        //Arrange
        MessageDTO mensaje = new MessageDTO("No te puedes dejar de seguir a tí mismo!");
        String esperado = writer.writeValueAsString(mensaje);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .post("/users/{userId}/unfollow/{userIdToUnfollow}",mtatoID,mtatoID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }


    @Test
    @DisplayName("T-00012 Obtener la cantidad de seguidores de Nauhel,funcionamiento normal")
    void getUserCountFollowers() throws  Exception{
        //Arrange
        UserFollowerCountDTO nauhel = new UserFollowerCountDTO(2,"nauhel",3);
        String esperado = writer.writeValueAsString(nauhel);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .get("/users/{userId}/followers/count",nauhelID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-00013 Obtener Seguidores de Nahue, funcionamiento normal")
    void getFollowersListTest() throws Exception{
        //Arrange
        UserFollowersListDTO siguenANauhe = new UserFollowersListDTO(2,"nauhel", List.of(new UserDTO(1,"mtato"),new UserDTO(3,"juancito"), new UserDTO(5,"orne")));
        String esperado = writer.writeValueAsString(siguenANauhe);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .get("/users/{userId}/followers/list",nauhelID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-00014 Obtener Seguidos de Nahue, funcionamiento normal")
    void getFollowedListTest() throws Exception{
        //Arrange
        UserFollowedListDTO seguidoresNauhe = new UserFollowedListDTO(2,"nauhel", List.of(new UserDTO(4,"luchoDelCampo"),new UserDTO(5,"orne")));
        String esperado = writer.writeValueAsString(seguidoresNauhe);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .get("/users/{userId}/followed/list",nauhelID))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-00013 Obtener Seguidores de Nahue ordenados ASC, funcionamiento normal")
    void getFollowersListTestASC() throws Exception{

        //Arrange
        UserFollowersListDTO siguenANauhe = new UserFollowersListDTO(2,"nauhel", List.of(new UserDTO(3,"juancito"),new UserDTO(1,"mtato"), new UserDTO(5,"orne")));
        String esperado = writer.writeValueAsString(siguenANauhe);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .get("/users/{userId}/followers/list",2)
                                  .param("order" ,"name_asc"))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-00013 Obtener Seguidores de Nahue ordenados DESC, funcionamient normal")
    void getFollowersListTestDESC() throws Exception{

        //Arrange
        UserFollowersListDTO siguenANauhe = new UserFollowersListDTO(2,"nauhel", List.of(new UserDTO(5,"orne"),new UserDTO(1,"mtato"),new UserDTO(3,"juancito") ));
        String esperado = writer.writeValueAsString(siguenANauhe);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .get("/users/{userId}/followers/list",2)
                                  .param("order" ,"name_desc"))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-00014 Obtener Seguidos de Nahue ordenados por nombre ASC, funcionamiento normal")
    void getFollowedListASCTest() throws Exception{
        //Arrange
        UserFollowedListDTO seguidoresNauhe = new UserFollowedListDTO(2,"nauhel", List.of(new UserDTO(4,"luchoDelCampo"),new UserDTO(5,"orne")));
        String esperado = writer.writeValueAsString(seguidoresNauhe);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .get("/users/{userId}/followed/list",nauhelID)
                                  .param("order" ,"name_asc"))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-00014 Obtener seguidos de Nahue ordenados por nombre DESC, funcionamiento normal")
    void getFollowedListDESCTest() throws Exception{
        //Assert
        UserFollowedListDTO seguidoresNauhe = new UserFollowedListDTO(2,"nauhel", List.of(new UserDTO(5,"orne"),new UserDTO(4,"luchoDelCampo")));
        String esperado = writer.writeValueAsString(seguidoresNauhe);
        //Act
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                                  .get("/users/{userId}/followed/list",nauhelID)
                                  .param("order","name_desc"))
                                  .andDo(MockMvcResultHandlers.print())
                                  .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                  .andExpect(MockMvcResultMatchers.status().isOk())
                                  .andReturn();
        //Assert
        Assertions.assertEquals(esperado,result.getResponse().getContentAsString());
    }
}
