package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
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
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ProductControllerTest {

    // INDIVIDUAL & BONUS

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer =  new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .registerModule(new JavaTimeModule())
            .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
            .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE)
            .registerModule(new JavaTimeModule())
            .writer();

    private PostRequestDTO postRequestDTO;

    // INDIVIDUAL PART
    @BeforeEach
    void setup() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(100);
        productDTO.setProductName("Locker");
        productDTO.setType("Home");
        productDTO.setBrand("EcoBrand");
        productDTO.setNotes("This is an eco product");
        productDTO.setColor("Brown");

        postRequestDTO = new PostRequestDTO();
        postRequestDTO.setUserId(1);
        postRequestDTO.setCategory(BigInteger.valueOf(10));
        postRequestDTO.setDate(LocalDate.now().minusDays(2));
        postRequestDTO.setPrice(1000D);
        postRequestDTO.setProduct(productDTO);
    }

    @Test
    @DisplayName("B. Incremental requirements - Individual development - OK")
    void createPostTestOK() throws Exception {

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

        postRequestDTO.setPrice(10000001D);
        String requestJson = writer.writeValueAsString(postRequestDTO);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.post("/products/post")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson);

        ResultMatcher statusExpected = MockMvcResultMatchers.status().is4xxClientError();

        mockMvc.perform(request).andDo(print()).andExpect(statusExpected);
    }



    // BONUS
    @Test
    @DisplayName("BONUS PART - listFollowingPosts2Weeks - OK")
    void listFollowingPosts2WeeksTestOK() throws Exception {

        List<PostDTO> postDTOS = new ArrayList<>();
        UserPostResponseDTO userPostResponseDTO = new UserPostResponseDTO(1, postDTOS);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                .param("order", "date_asc");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher body = MockMvcResultMatchers.content().json(writer.writeValueAsString(userPostResponseDTO));

        mockMvc.perform(request).andDo(print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(body);
    }

    @Test
    @DisplayName("BONUS PART - listFollowingPosts2Weeks - NOK")
    void listFollowingPosts2WeeksTestNOK() throws Exception {

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/products/followed/{userId}/list", 1)
                .param("order", "NOT_VALID_ORDER");

        ResultMatcher statusExpected = MockMvcResultMatchers.status().is4xxClientError();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(request).andDo(print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected);
    }
}