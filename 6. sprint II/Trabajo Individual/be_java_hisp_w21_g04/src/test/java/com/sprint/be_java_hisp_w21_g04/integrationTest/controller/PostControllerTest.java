package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.ErrorDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.ResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.validate.ErrorDTO;
import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Agregando post correctamente")
    void postOk() throws Exception {

        ResponseDto responseDto = new ResponseDto("Post agregado exitosamente");

        PostRequestDto post = new PostRequestDto(1, LocalDate.parse("02-06-2023",DateTimeFormatter.ofPattern("dd-MM-yyyy")),new Product(1,"Silla Gamer","Gamer","Razer","Red","Special Edition"),100,2000.0);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(responseDto);
        String payloadDto = writer.writeValueAsString(post);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andDo(print())
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Validando id del usuario positivo")
    void postValidate() throws Exception {

        ErrorDTO errorDTO = new ErrorDTO("Se encontraron los siguientes errores en las validaciones: ", Arrays.asList("El id del usuario debe ser mayor a cero."));

        PostRequestDto post = new PostRequestDto(-1, LocalDate.parse("15-06-2023",DateTimeFormatter.ofPattern("dd-MM-yyyy")),new Product(1,"Silla Gamer","Gamer","Razer","Red","Special Edition"),100,2000.0);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDTO);
        String payloadDto = writer.writeValueAsString(post);

        MvcResult mvcResult = mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(payloadDto))
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andDo(print())
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obteniendo lista de post de un vendedor correctamente")
    void sellerFollowedListPostsOk() throws Exception{

        PostResponseDto post1 = new PostResponseDto(1, LocalDate.parse("21-06-2023",DateTimeFormatter.ofPattern("dd-MM-yyyy")),new Product(2,"Pantalon vaquero","Ropa","Levi s","Azul","Pantalon vaquero ajustado para hombre"),2,20.0);
        PostResponseDto post2 = new PostResponseDto(1, LocalDate.parse("22-06-2023",DateTimeFormatter.ofPattern("dd-MM-yyyy")),new Product(1,"Camiseta","Ropa","Adidas","Rojo con blanco","Camiseta de algodon con estampado"),1,10.0);
        SellerFollowedListPostResponseDto sellerFollowedListPostResponseDto = new SellerFollowedListPostResponseDto(2, Arrays.asList(post1,post2));

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(sellerFollowedListPostResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/products/followed/{userId}/list", 2))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }


    @Test
    @DisplayName("Exception Lista de post de un vendedor vacia")
    void sellerFollowedListPostsEmpty() throws Exception{

        ErrorDto responseDto = new ErrorDto("Los vendedores que sigues no tienen publicaciones",400);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(responseDto);

        MvcResult mvcResult = mockMvc.perform(get("/products/followed/{userId}/list", 10))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obteniendo lista de post de un vendedor ordenando por fecha ascendente correctamente")
    void sellerFollowedListPostsSortedAsc() throws Exception{

        PostResponseDto post1 = new PostResponseDto(1, LocalDate.parse("21-06-2023",DateTimeFormatter.ofPattern("dd-MM-yyyy")),new Product(2,"Pantalon vaquero","Ropa","Levi s","Azul","Pantalon vaquero ajustado para hombre"),2,20.0);
        PostResponseDto post2 = new PostResponseDto(1, LocalDate.parse("22-06-2023",DateTimeFormatter.ofPattern("dd-MM-yyyy")),new Product(1,"Camiseta","Ropa","Adidas","Rojo con blanco","Camiseta de algodon con estampado"),1,10.0);
        SellerFollowedListPostResponseDto sellerFollowedListPostResponseDto = new SellerFollowedListPostResponseDto(2, Arrays.asList(post1,post2));

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(sellerFollowedListPostResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/products/followed/{userId}/list", 2)
                        .param("order","date_asc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obteniendo lista de post de un vendedor ordenando por fecha descendente correctamente")
    void sellerFollowedListPostsSortedDesc() throws Exception{

        PostResponseDto post1 = new PostResponseDto(1, LocalDate.parse("22-06-2023",DateTimeFormatter.ofPattern("dd-MM-yyyy")),new Product(1,"Camiseta","Ropa","Adidas","Rojo con blanco","Camiseta de algodon con estampado"),1,10.0);
        PostResponseDto post2 = new PostResponseDto(1, LocalDate.parse("21-06-2023",DateTimeFormatter.ofPattern("dd-MM-yyyy")),new Product(2,"Pantalon vaquero","Ropa","Levi s","Azul","Pantalon vaquero ajustado para hombre"),2,20.0);
        SellerFollowedListPostResponseDto sellerFollowedListPostResponseDto = new SellerFollowedListPostResponseDto(2, Arrays.asList(post1,post2));

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(sellerFollowedListPostResponseDto);

        MvcResult mvcResult = mockMvc.perform(get("/products/followed/{userId}/list", 2)
                        .param("order","date_desc"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Exception Lista de post de un vendedor ordenando por fecha incorrectamente")
    void sellerFollowedListPostsSortedNoOK() throws Exception{

        ErrorDto errorDto = new ErrorDto("Ordenamiento invalido",400);

        ObjectWriter writer = new ObjectMapper()
                .registerModule(new JavaTimeModule())
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String exceptResult = writer.writeValueAsString(errorDto);

        MvcResult mvcResult = mockMvc.perform(get("/products/followed/{userId}/list", 1)
                        .param("order","date_"))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(exceptResult, mvcResult.getResponse().getContentAsString());

    }

    @Test
    @DisplayName("Obteniendo lista de todos los post")
    void getAll() throws Exception{

        MvcResult mvcResult = mockMvc.perform(get("/products/getAll"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

    }

}
