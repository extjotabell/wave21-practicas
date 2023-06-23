package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.ResponseDTO;
import com.example.be_java_hisp_w21_g1.Model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class Controller {

    @Autowired
    MockMvc mockMvc;

    @DisplayName("Seguir a un usuario - Caso Feliz")
    @Test
    public void followTest() throws Exception {

        Integer userId = 1;
        Integer userIdToFollow = 2;

        ResponseDTO responseDto = new ResponseDTO("Accion realizada con exito.",200);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(userId) +","+ writer.writeValueAsString(userIdToFollow);
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult mvcResult = mockMvc
                        .perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @DisplayName("Seguir a un usuario que no es vendedor- Caso Triste")
    @Test
    public void followTestNoOk() throws Exception {

        Integer userId = 2;
        Integer userIdToFollow = 1;

        ErrorDTO responseDto = new ErrorDTO("El usuario no es un vendedor...");

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(userId) +","+ writer.writeValueAsString(userIdToFollow);
        String responseJson = writer.writeValueAsString(responseDto);

        MvcResult mvcResult = mockMvc
                .perform(post("/users/{userId}/follow/{userIdToFollow}",userId,userIdToFollow)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
    @DisplayName("Dejar de seguir a un usuario - Caso Feliz")
    @Test
    public void unfollowTest() throws Exception {

        Integer userId = 1;
        Integer userIdToUnfollow = 2;

        Integer responseStatus = 200;

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(userId) +","+ writer.writeValueAsString(userIdToUnfollow);

        MvcResult mvcResult = mockMvc
                .perform(post("/users/{userId}/unfollow/{userIdToUnfollow}",userId,userIdToUnfollow)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andReturn();

        assertEquals(responseStatus,mvcResult.getResponse().getStatus());
    }
    @DisplayName("Crear post a un usuario - Caso Feliz")
    @Test
    public void createPostTest() throws Exception {

        Integer userId = 1;
        LocalDate fecha = LocalDate.now();
        PostProductDTO postProductDTO = new PostProductDTO(
                userId,
                fecha,
                new ProductDTO(
                        2,
                        "Pan",
                        "Perecedero",
                        "-",
                        "-",
                        "25% off los martes"
                ),
                1,
                10.3
        );
        ResponseDTO responseDto = new ResponseDTO("Se ha creado el post!",200);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(postProductDTO);
        String responseJson = writer.writeValueAsString(responseDto);
        MvcResult mvcResult = mockMvc
                .perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(content().contentType("application/json"))
                .andDo(print())
                .andReturn();

        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }
}
