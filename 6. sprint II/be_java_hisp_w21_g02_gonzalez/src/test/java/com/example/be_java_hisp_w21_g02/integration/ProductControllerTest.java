package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    // INDIVIDUAL & BONUS

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer =  new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    // INDIVIDUAL PART
    @Test
    @DisplayName("B. Incremental requirements - Individual development - OK")
    void createPostTestOK() throws Exception {
        PostRequestDTO postRequestDTO = getPostRequestDTO();
        String requestJson = writer.writeValueAsString(postRequestDTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();

        mockMvc.perform(request).andDo(print()).andExpect(statusExpected);
    }

    @Test
    @DisplayName("B. Incremental requirements - Individual development - NOK")
    void createPostTestNOK() throws Exception {
        PostRequestDTO postRequestDTO = getPostRequestDTO();
        postRequestDTO.setPrice(10000001D);
        String requestJson = writer.writeValueAsString(postRequestDTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(request).andDo(print()).andExpect(statusExpected);
    }

    private PostRequestDTO getPostRequestDTO() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(100);
        productDTO.setProductName("Locker");
        productDTO.setType("Home");
        productDTO.setBrand("EcoBrand");
        productDTO.setNotes("This is an eco product");
        productDTO.setColor("Brown");

        PostRequestDTO postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUserId(1);
        postRequestDTO.setCategory(BigInteger.valueOf(10));
        postRequestDTO.setDate(LocalDate.now().minusDays(2));
        postRequestDTO.setPrice(1000D);
        postRequestDTO.setProduct(productDTO);

        return postRequestDTO;
    }

    // BONUS

}
