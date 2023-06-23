package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc _mockMvc;

    ObjectWriter _writer;
    PostRequestDto _postRequestDto;


    // Bonus (Desarrollo Individual EXTRA) - Pruebas de integracion con el fin de lograr un coverage mayor o igual al 75%
    @BeforeEach
    void setUp() {

        _writer = (ObjectWriter) new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .setDateFormat(new StdDateFormat().withColonInTimeZone(true))
                .registerModule(new JSR310Module())
                .writer();

        _postRequestDto = new PostRequestDto(1,
                LocalDate.of(2023, 06, 22),
                new Product(2,
                        "Silla Gamer",
                        "Gamer",
                        "Racer",
                        "Red and Black",
                        "Special Edition"),
                100,
                1500.50
        );
    }

    @Test
    @DisplayName("T-0001: Prueba de integracion agregando post para un usuario camino OK")
    void postTest() throws Exception {

        //Act & Assert
        _mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(_writer.writeValueAsString(_postRequestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Post agregado exitosamente"))
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0002: Prueba de integracion lista de publicaciones de un vendedor seguido camino OK")
    void sellerFollowedListPostsTest() throws Exception {

        //Arrange
        int userId = 3;

        //Act & Assert
        _mockMvc.perform(get("/products/followed/{userId}/list", userId)
                        .param("order", "date_asc"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("T-0003: Prueba de integracion listado de todos los post camino OK")
    void getAllTest() throws Exception {

        //Act & Assert
        _mockMvc.perform(get("/products/getAll"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }

    @Test
    @DisplayName("T-0004: Prueba de integracion agregando post para un usuario camino OK")
    void postDateNotEmptyTest() throws Exception {

        //Arrange
        PostRequestDto dateShouldNotEmpty = new PostRequestDto(1,
                                                              null,
                                                  new Product(2,
                                                              "Silla Gamer",
                                                              "Gamer",
                                                              "Racer",
                                                              "Red and Black",
                                                              "Special Edition"),
                                                              100,
                                                              1500.50
        );

        //Act & Assert
        _mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(_writer.writeValueAsString(dateShouldNotEmpty)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.messages").value("La fecha no puede estar vacía."))
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

    @Test
    @DisplayName("T-0004: Prueba de integracion lista de publicaciones de un vendedor seguido ")
    void sellerFollowedListPostsByDateTest() throws Exception {

        //Arrange
        int userId = 10;

        //Act & Assert
        _mockMvc.perform(get("/products/followed/{userId}/list", userId))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Los vendedores que sigues no tienen publicaciones"))
                .andExpect(content().contentType("application/json"))
                .andReturn();
    }
}

