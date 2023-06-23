package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @DisplayName("Integration Test 01 - Post Correct Validation")
    void createPostValidDataReturns200() throws Exception {
        // Arrange
        ProductDTO productDTO = new ProductDTO(2,"Example","pepe","pepe","Rojo","El mejor de todos");
        PostRequestDTO postRequestDTO = new PostRequestDTO(1,LocalDate.parse("2023-01-01"),productDTO,new BigInteger("1234567890"),100.0);

        // Act
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postRequestDTO)));

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isOk());
        // Perform other assertions as needed
    }

    @Test
    @DisplayName("Integration Test 02 - Post Null and Empty Validation")
    void createPostNullReturns400() throws Exception {
        // Arrange
        ProductDTO productDTO = new ProductDTO(2,"","","","","");
        PostRequestDTO postRequestDTO = new PostRequestDTO(1,null,productDTO,new BigInteger("1"),null);

        // Act
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postRequestDTO)));

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
        // Perform other assertions as needed
    }
    @Test
    @DisplayName("Integration Test 03 - Post InValidation")
    void createPostInvalid400() throws Exception {
        // Arrange
        ProductDTO productDTO = new ProductDTO(-1,"$$$$$$aaaa","%%%%%aaaa","·$·$·$·A","%&%&%A","SDFSD%$%$%");
        PostRequestDTO postRequestDTO = new PostRequestDTO(-1,LocalDate.parse("2023-12-12"),productDTO,new BigInteger("10000000000"),1000000000000.0);

        // Act
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(postRequestDTO)));

        // Assert
        result.andExpect(MockMvcResultMatchers.status().isBadRequest());
        // Perform other assertions as needed
    }
}
