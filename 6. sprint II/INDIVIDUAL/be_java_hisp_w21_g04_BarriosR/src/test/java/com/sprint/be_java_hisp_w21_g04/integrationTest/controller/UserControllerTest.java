package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.repository.user.UserRepositoryImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc _mockMvc;

    @Mock
    UserRepositoryImpl _userRepository;

    // Requerimientos incrementales (Desarrollo INDIVIDUAL) - Pruebas de integracion obteniendo listado de seguidores y Seguidos por ID

    @Test
    @DisplayName("T-0001: Prueba de integracion obteniendo listado de seguidores por ID con el parametro de ordenamiento camino OK")
    void getFollowersByIdWithParamOrderTest() throws Exception {

        //Arrange
        int userId = 3;

        //Act & Assert
        _mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", "name_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0001: Prueba de integracion obteniendo listado de seguidores por ID sin el parametro de ordenamiento camino OK")
    void getFollowersByIdWithoutParamOrderTest() throws Exception {

        //Arrange
        int userId = 3;

        //Act & Assert
        _mockMvc.perform(get("/users/{userId}/followers/list", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0001: Prueba de integracion generando la excepcion 404 Not Found al no encontrar resultados de seguidores")
    void getFollowersByIdTestNotFound() throws Exception {

        //Arrange
        int userId = 10;

        //Act & Assert
        _mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", "name_asc"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("No se encontraron seguidores para el vendedor"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0001: Prueba de integracion generando la excepcion 400 Bad Request al no encontrar resultados de seguidores")
    void getFollowersByIdTestBadRequest() throws Exception {

        //Arrange
        int userId = 10;

        //Act & Assert
        _mockMvc.perform(get("/users/{userId}/followers/list", userId)
                        .param("order", "name_"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Ordenamiento invalido"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0002: Prueba de integracion obteniendo listado de seguidos por ID con el parametro de ordenamiento camino Ok")
    void getFollowedByIdWithParamOrderTest() throws Exception {

        //Arrange
        int userId = 4;

        //Act & Assert
        _mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", "name_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0002: Prueba de integracion obteniendo listado de seguidos por ID sin el parametro de ordenamiento camino Ok")
    void getFollowedByIdWithoutParamOrderTest() throws Exception {

        //Arrange
        int userId = 4;

        //Act & Assert
        _mockMvc.perform(get("/users/{userId}/followed/list", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0002: Prueba de integracion generando la excepcion 404 Not Found al no encontrar resultados de seguidos")
    void getFollowedByIdTestNotFount() throws Exception {

        //Arrange
        int userId = 1;

        //Act & Assert
        _mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", "name_asc"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("El usuario no sigue a ningún vendedor"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0002: Prueba de integracion generando la excepcion 404 Bad Request al no encontrar resultados de seguidos")
    void getFollowedByIdTestBadRequest() throws Exception {

        //Arrange
        int userId = 1;

        //Act & Assert
        _mockMvc.perform(get("/users/{userId}/followed/list", userId)
                        .param("order", "name_"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Ordenamiento invalido"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    // Bonus (Desarrollo Individual EXTRA) - Pruebas de integracion con el fin de lograr un coverage mayor o igual al 75%
    @Test
    @DisplayName("T-0003: Prueba de integracion siguiendo a un vendedor, solo si el usuario y el vendedor existen")
    void userFollowTest() throws Exception {

        //Arrange
        int userId = 4;
        int userIdToFollow = 1;

        //Act & Assert
        _mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Has seguido a JohnDoe"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }


    @Test
    @DisplayName("T-0004: Prueba de integracion de la cantidad de usuarios que siguen a un vendedor")
    void userFollowersCountDto() throws Exception {

        //Arrange
        int userId = 3;

        //Act & Assert
        var response = _mockMvc.perform(get("/users/{userId}/followers/count", userId))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        //Assert
        assertEquals("{\"user_id\":3,\"user_name\":\"MikeJohnson\",\"followers_count\":1}",response.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("T-0005: Prueba de integracion que permite a un usuario dejar de seguir a un vendedor")
    void userUnfollow () throws Exception{

        //Arrange
        int userId = 4;
        int userIdToFollow = 1;
        int userIdToUnfollow = 1;

        // Sigo a un vendedor
        _mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", userId, userIdToFollow));

        //Act & Assert
        _mockMvc.perform(post("/users/{userId}/unfollow/{userIdToUnfollow}", userId, userIdToUnfollow))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Has dejado de seguir a JohnDoe"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }





}
