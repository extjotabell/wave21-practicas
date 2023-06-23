package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.math.BigInteger;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class ProductControllerTest {

    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter writer;
    private static PostRequestDTO newPost;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .registerModule(new JavaTimeModule())
                .setDateFormat(new SimpleDateFormat("dd-MM-yyyy"))
                .setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy())
                .writer().withDefaultPrettyPrinter();

    }

    @Test
    @DisplayName("Integration Test US05 01 - Creation of new post")
    public void testRegisterPostIntegration() throws Exception{

        newPost = new PostRequestDTO(1,  LocalDate.now().minusDays(1), new ProductDTO(1, "helado","Freddo","1","blanco","Es helado"), BigInteger.valueOf(2), 150.0);
        String jsonPayload = writer.writeValueAsString(newPost);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Integration Test US05 02 - Creation of new post without product name throws error")
    public void testRegisterInvalidPostIntegration() throws Exception{

        newPost = new PostRequestDTO(1,  LocalDate.now().minusDays(1), new ProductDTO(1, null,"Freddo","1","blanco","Es helado"), BigInteger.valueOf(2), 150.0);
        String jsonPayload = writer.writeValueAsString(newPost);

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().is4xxClientError())
                .andExpect(jsonPath("$.description").value("The ProductName field is required"));
    }


}
