package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.math.BigInteger;

@SpringBootTest
@WebAppConfiguration
public class UserControllerTest {
    private final static String BASE_URL = "http://localhost:8080";
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("Integration Test to follow a user")
    void followUserTest() throws Exception {
        int userId = 1;
        int userIdToFollow = 2;
        // create me a PostRequestDTO object with data {
        //    "user_id": 2,
        //    "date": "01-02-2023",
        //    "product": {
        //        "product_id": 21,
        //        "product_name": "AAAAAAA",
        //        "type": "Gamer",
        //        "brand": "Racer",
        //        "color": "Red & Black",
        //        "notes": "Special Edition"
        //    },
        //    "category": 100,
        //    "price": 1500.50
        //}
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(21);
        productDTO.setProductName("AAAAAAA");
        productDTO.setType("Gamer");
        productDTO.setBrand("Racer");
        productDTO.setColor("Red & Black");
        productDTO.setNotes("Special Edition");

        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUserId(userIdToFollow);
        postRequestDTO.setProduct(productDTO);
        postRequestDTO.setCategory(BigInteger.valueOf(100));
        postRequestDTO.setPrice(1500.50);
        postRequestDTO.setProduct(productDTO);

        ObjectMapper objectMapper = new ObjectMapper(); // Agrega esto
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String postRequestJson = objectMapper.writeValueAsString(postRequestDTO); // Agrega esto

        //System.out.println(postRequestJson);

        String endpoint = BASE_URL + "/products/post";
        MvcResult mockMvcResult = mockMvc.perform(MockMvcRequestBuilders.post(endpoint)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(postRequestJson) // Cambia esto
        ).andReturn();

        // print the response
        //System.out.println(mockMvcResult.getResponse().getContentAsString());

        Assertions.assertEquals(200, mockMvcResult.getResponse().getStatus());

        String endpoint2 = BASE_URL + "/users/" + userId + "/follow/" + userIdToFollow; // Corrige esto
        MvcResult mockMvcResult2 = mockMvc.perform(MockMvcRequestBuilders.post(endpoint2)
                .accept(MediaType.APPLICATION_JSON_VALUE)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andReturn();

        System.out.println(mockMvcResult2.getResponse().getContentAsString());

        Assertions.assertEquals(200, mockMvcResult2.getResponse().getStatus());
    }
}
