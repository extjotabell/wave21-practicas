package com.sprint.be_java_hisp_w21_g04.integrationTest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.sprint.be_java_hisp_w21_g04.dto.request.PostRequestDto;
import com.sprint.be_java_hisp_w21_g04.entity.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer;

    PostRequestDto postRequestDto;

    @BeforeEach
    void setUp() {
        writer=new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .setDateFormat(new StdDateFormat().withColonInTimeZone(true))
                .registerModule(new JSR310Module())
                .writer();
        postRequestDto=getPostResponseDTO();
    }

    @Test
    public void testPostOk() throws Exception {

        mockMvc.perform(post("/products/post")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(writer.writeValueAsString(postRequestDto))
                )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").exists())
                .andExpect(jsonPath("$.message").value("Post agregado exitosamente"))
                .andExpect(result -> result.getResponse().getContentType().equals("application/json"))
                .andReturn();

    }

    private PostRequestDto getPostResponseDTO() {
        return new PostRequestDto(
                1,
                LocalDate.of(2023, 06, 16),
                new Product(2,"Silla Gamer","Gamer","Racer","Red and Black","Special Edition"),
                100,
                1400.00
        );
    }

}
