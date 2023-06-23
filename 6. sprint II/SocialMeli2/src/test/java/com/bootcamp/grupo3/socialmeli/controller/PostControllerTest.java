package com.bootcamp.grupo3.socialmeli.controller;


import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.ErrorDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    MockMvc mockMvc;

    static ObjectWriter writer ;
    /***
     Se inicializan los id de usuario para usar en los casos.
     Estos ID son los mismos que se encuentran en el repo
     ***/
    private final int nauhelID = 2;

    @BeforeAll
    static void init(){
        /*Se inicializa el objeto writer para todos los casos*/
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .registerModule(new JavaTimeModule())
                .writer();
    }

//T00015    /products/post    Crear un nuevo post, funcionamiento normal

    @Test
    @DisplayName("T-00015 Crear un post Nuevo de Nauhel, funcionamiento normal")
    void createPostTest() throws Exception{
        //Arrange
        MessageDTO mensaje = new MessageDTO("Post agregado exitosamente con id: 1");
        //En este caso el post contiene todos los datos validos.
        PostDTO post = new PostDTO(nauhelID, LocalDate.now(),new ProductDTO(123,"Silla Gamer","Silla","Asus","Negro y verde","Silla impecable"),100,15230.12);
        String jsonPayload = writer.writeValueAsString(post);
        String esperado = writer.writeValueAsString(mensaje);
        //Act
        MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .content(jsonPayload))
                                     .andDo(MockMvcResultHandlers.print())
                                     .andExpect(MockMvcResultMatchers.status().isOk())
                                     .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                     .andReturn();
        //Assert
        Assertions.assertEquals(esperado,resultado.getResponse().getContentAsString());
    }


    @Test
    @DisplayName("T-00015 Crear un post nuevo, excepcion por usuario invalido")
    void createPostWithInvalidUserTest() throws Exception{
        //Arrange
        MessageDTO mensaje = new MessageDTO("No se ha encontrado el usuario");
        int randomID = 70;
        //En este caso el post contiene el id de un usuario no existente en el repositorio.
        PostDTO post = new PostDTO(randomID, LocalDate.now(),new ProductDTO(123,"Silla Gamer","Silla","Asus","Negro y verde","Silla impecable"),100,15230.12);
        String jsonPayload = writer.writeValueAsString(post);
        String esperado = writer.writeValueAsString(mensaje);
        //Act
        MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .content(jsonPayload))
                                     .andDo(MockMvcResultHandlers.print())
                                     .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                     .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                     .andReturn();
        //Assert
        Assertions.assertEquals(esperado,resultado.getResponse().getContentAsString());

    }

//T00015    /products/post    Crear un nuevo post, funcionamiento anormal por fecha vacia

    @Test
    @DisplayName("T-00015 Crear un post Nuevo de Nauhel con fecha vacia")
    void createPostTestWithValidationDateFails() throws Exception{
        //Arrange
        ErrorDTO error = new ErrorDTO();
        List<String> descripciones = new ArrayList<>();
        descripciones.add("La fecha no puede estar vacía.");
        error.setName("Se encontraron los siguientes errores en las validaciones: ");
        error.setDescription(descripciones);
        //En este caso el post contiene todos los datos validos, menos la fecha que se encuentra nula.
        PostDTO post = new PostDTO(nauhelID, null,new ProductDTO(123,"Silla Gamer","Silla","Asus","Negro y verde","Silla impecable"),123,15230.12);
        String jsonPayload = writer.writeValueAsString(post);
        String esperado = writer.writeValueAsString(error);
        //Act
        MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .content(jsonPayload))
                                     .andDo(MockMvcResultHandlers.print())
                                     .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                     .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                     .andReturn();
        //Assert
        Assertions.assertEquals(esperado,resultado.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }
//T00015    /products/post    Crear un nuevo post, funcionamiento anormal por categoria vacia
    @Test
    @DisplayName("T-00015 Crear un post Nuevo de Nauhel con categoria vacia")
    void createPostTestWithValidationCategoryFails() throws Exception{
        //Arrange
        ErrorDTO error = new ErrorDTO();
        List<String> descripciones = new ArrayList<>();
        descripciones.add("La categoría no puede estar vacía.");
        error.setName("Se encontraron los siguientes errores en las validaciones: ");
        error.setDescription(descripciones);
        //En este caso el post contiene todos los datos validos, menos la categoria que se encuentra null.
        PostDTO post = new PostDTO(nauhelID, LocalDate.now(),new ProductDTO(123,"Silla Gamer","Silla","Asus","Negro y verde","Silla impecable"),null,15230.12);
        String jsonPayload = writer.writeValueAsString(post);
        String esperado = writer.writeValueAsString(error);
        //Act
        MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders
                                     .post("/products/post")
                                     .contentType(MediaType.APPLICATION_JSON)
                                     .content(jsonPayload))
                                     .andDo(MockMvcResultHandlers.print())
                                     .andExpect(MockMvcResultMatchers.status().isBadRequest())
                                     .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                                     .andReturn();
        //Assert
        Assertions.assertEquals(esperado,resultado.getResponse().getContentAsString(StandardCharsets.UTF_8));
    }

}
