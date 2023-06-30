package com.sprint.be_java_hisp_w21_g04.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sprint.be_java_hisp_w21_g04.controller.PostController;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.PostResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.ResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.SellerFollowedListPostResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import com.sprint.be_java_hisp_w21_g04.service.post.IPostService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;
import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PostController.class)
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IPostService postService;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void testPost() throws Exception {
        Product product = new Product(1, "bolso", "moda", "hermes", "white", "producto en promocion");
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
    public void testSellerFollowedListPosts() throws Exception {
        // Simular el comportamiento del servicio
        when(postService.sellerFollowedListPosts(anyInt(), anyString())).thenReturn(new SellerFollowedListPostResponseDto());

        // Realizar la solicitud GET al controlador
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/followed/1/list")
                        .param("order", "date_asc"))
                .andExpect(status().isOk())
                .andReturn();

        // Verificar la respuesta
        String responseContent = mvcResult.getResponse().getContentAsString();
        // Realizar las aserciones necesarias sobre la respuesta
    }

    @Test
    public void testGetAll() throws Exception {
        // Simular el comportamiento del servicio
        List<PostResponseDto> responseDtoList = new ArrayList<>();
        when(postService.getAll()).thenReturn(responseDtoList);

        // Realizar la solicitud GET al controlador
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/products/getAll"))
                .andExpect(status().isOk())
                .andReturn();

        // Verificar la respuesta
        String responseContent = mvcResult.getResponse().getContentAsString();
        // Realizar las aserciones necesarias sobre la respuesta
    }
}
