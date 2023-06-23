package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.ErrorDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.validate.ErrorDTO;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import com.sprint.be_java_hisp_w21_g04.exception.EmptySellerFollowedList;
import com.sprint.be_java_hisp_w21_g04.exception.IllegalDataException;
import com.sprint.be_java_hisp_w21_g04.exception.UserNotFoundException;
import com.sprint.be_java_hisp_w21_g04.service.post.IPostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.*;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    IPostService postService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testPost() throws Exception {
        Product product = new Product(1, "Silla gamer", "Gamer", "Racer", "Red and Black", "Notas");
        PostRequestDto requestDto = new PostRequestDto(1, LocalDate.now(), product, 10, 100D);
        doNothing().when(postService).post(any(PostRequestDto.class));
        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message", is("Post agregado exitosamente")));
        verify(postService, times(1)).post(any(PostRequestDto.class));
    }

    @Test
    public void testPostValidations() throws Exception {
        Product product = new Product(-1, "Silla gamer", "Gamer", "Racer", "Red and Black", "Notas");
        PostRequestDto requestDto = new PostRequestDto(1, LocalDate.now(), product, 10, 100D);
        ErrorDTO expectedResponse = new ErrorDTO();
        expectedResponse.setExplanation("Se encontraron los siguientes errores en las validaciones: ");
        List<String> errors = new ArrayList<>();
        errors.add("El id del producto debe ser mayor a cero.");
        expectedResponse.setMessages(errors);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponseString = writer.writeValueAsString(expectedResponse);


        doNothing().when(postService).post(any(PostRequestDto.class));
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.explanation", is("Se encontraron los siguientes errores en las validaciones: "))).andReturn();

        assertEquals(expectedResponseString, result.getResponse().getContentAsString());
    }

    @Test
    public void testPostUserNotFoundException() throws Exception {
        Product product = new Product(1, "Silla gamer", "Gamer", "Racer", "Red and Black", "Notas");
        PostRequestDto requestDto = new PostRequestDto(10000, LocalDate.now(), product, 10, 100D);

        doThrow(new UserNotFoundException("El usuario no existe")).when(postService).post(any(PostRequestDto.class));

        mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(requestDto)))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("El usuario no existe")));
        verify(postService, times(1)).post(any(PostRequestDto.class));
    }

    @Test
    public void testSellerFollowedListPosts() throws Exception {
        Integer userId = 1;
        String order = "date_asc";
        List<PostResponseDto> mockPosts = new ArrayList<>();
        Product product4 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        mockPosts.add(new PostResponseDto(userId, LocalDate.now().minusDays(10), product4, 10, 100.0));
        Product product5 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        mockPosts.add(new PostResponseDto(userId, LocalDate.now().minusDays(5), product5, 6, 160.0));
        Product product6 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        mockPosts.add(new PostResponseDto(1, LocalDate.now(), product6, 4, 120.0));
        SellerFollowedListPostResponseDto mockResponse = new SellerFollowedListPostResponseDto();
        mockResponse.setUserId(userId);
        mockResponse.setPosts(mockPosts);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false).registerModule(new JavaTimeModule())
                .writer();

        String expectedResponseString = writer.writeValueAsString(mockResponse);

        when(postService.sellerFollowedListPosts(userId, order)).thenReturn(mockResponse);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                .param("order", order))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user_id").value(mockResponse.getUserId()))
                .andExpect(jsonPath("$.posts", hasSize(mockPosts.size())))
                .andExpect(jsonPath("$.posts[0].user_id").value(mockResponse.getPosts().get(0).getUserId()))
                .andReturn();

        verify(postService, times(1)).sellerFollowedListPosts(userId, order);
        assertEquals(expectedResponseString, result.getResponse().getContentAsString());
    }

    @Test
    public void testSellerFollowedListPostsUserNotFoundException() throws Exception {
        int userId = 1;
        String order = "date_asc";

        when(postService.sellerFollowedListPosts(userId, order)).thenThrow(new UserNotFoundException("El usuario no existe"));

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                .param("order", order)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message", is("El usuario no existe")));
        verify(postService, times(1)).sellerFollowedListPosts(userId, order);
    }

    @Test
    public void testSellerFollowedListPostsIllegalDataException() throws Exception {
        int userId = 1;
        String order = "XXXXXXX";
        ErrorDto expectedResponse = new ErrorDto();
        expectedResponse.setMessage("Ordenamiento invalido");
        expectedResponse.setStatus(400);

        ObjectWriter writer = new ObjectMapper().configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String expectedResponseString = writer.writeValueAsString(expectedResponse);

        when(postService.sellerFollowedListPosts(userId, order)).thenThrow(new IllegalDataException("Ordenamiento invalido"));

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                .param("order", order)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Ordenamiento invalido"))).andReturn();
        verify(postService, times(1)).sellerFollowedListPosts(userId, order);

        assertEquals(expectedResponseString, result.getResponse().getContentAsString());
    }

    @Test
    public void testSellerFollowedListPostsEmptySellerFollowedListException() throws Exception {
        int userId = 1;
        String order = "date_desc";

        when(postService.sellerFollowedListPosts(userId, order)).thenThrow(new EmptySellerFollowedList("Los vendedores que sigues no tienen publicaciones"));

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                .param("order", order)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Los vendedores que sigues no tienen publicaciones")));
        verify(postService, times(1)).sellerFollowedListPosts(userId, order);
    }

    @Test
    public void testSellerFollowedNoPostedInLastTwoWeeksException() throws Exception {
        int userId = 1;
        String order = "date_desc";

        when(postService.sellerFollowedListPosts(userId, order)).thenThrow(new EmptySellerFollowedList("Los vendedores que sigues no han hecho publiciones en las últimas dos semanas"));

        mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/{userId}/list", userId)
                .param("order", order)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message", is("Los vendedores que sigues no han hecho publiciones en las últimas dos semanas")));
        verify(postService, times(1)).sellerFollowedListPosts(userId, order);
    }

    @Test
    public void testGetAll() throws Exception {
        List<PostResponseDto> mockPosts = new ArrayList<>();
        Product product4 = new Product(1, "Camiseta", "T Shirt", "Nike", "Red", "");
        mockPosts.add(new PostResponseDto(1, LocalDate.now().minusDays(10), product4, 10, 100.0));
        Product product5 = new Product(1, "Short", "Short", "Adidas", "Brown", "");
        mockPosts.add(new PostResponseDto(1, LocalDate.now().minusDays(5), product5, 6, 160.0));
        Product product6 = new Product(1, "Camiseta", "T Shirt", "Adidas", "White", "");
        mockPosts.add(new PostResponseDto(1, LocalDate.now(), product6, 4, 120.0));

        when(postService.getAll()).thenReturn(mockPosts);

        mockMvc.perform(MockMvcRequestBuilders.get("/products/getAll"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(mockPosts.size())));

        verify(postService, times(1)).getAll();
    }

}
