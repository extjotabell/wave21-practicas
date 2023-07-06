package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.time.LocalDate;

@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {
    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();
    @Test
    void countFollowersTestHappyPath() throws Exception {

        FollowersCountDTO expected = new FollowersCountDTO(1,"Pepe",2);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/1/followers/count");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void countFollowersTestSadPath() throws Exception {


        ErrorDTO expected = new ErrorDTO("No se encontro el usuario con el ID" + 34);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/users/34/followers/count");
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isNotFound();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request)
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentExpected)
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    void createPostTestHappyPath() throws Exception {
        ProductDTO mockedProduct = new ProductDTO(34,"producto bacan","producto","marca","rojo comunista", "");
        PostProductDTO mockedPost = new PostProductDTO(1, LocalDate.now(),mockedProduct,1,32.00);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        String postJson = writer.writeValueAsString(mockedPost);
        mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON).content(postJson))
                .andExpect(statusExpected);
    }

    @Test
    void createPostTestSadPath() throws Exception {
        ErrorDTO expected = new ErrorDTO("No se encontro el usuario con el ID" + 34);
        ProductDTO mockedProduct = new ProductDTO(34,"producto bacan","producto","marca","rojo comunista", "");
        PostProductDTO mockedPost = new PostProductDTO(34, LocalDate.now(),mockedProduct,1,32.00);
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post");
        String postJson = writer.writeValueAsString(mockedPost);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isBadRequest();
        ResultMatcher contentExpected = MockMvcResultMatchers.content().json(writer.writeValueAsString(expected));
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        mockMvc.perform(request.contentType(MediaType.APPLICATION_JSON).content(postJson))
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(contentExpected);
    }
}
