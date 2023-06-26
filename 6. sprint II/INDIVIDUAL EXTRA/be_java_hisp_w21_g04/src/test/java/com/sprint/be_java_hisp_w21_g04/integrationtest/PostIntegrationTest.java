package com.sprint.be_java_hisp_w21_g04.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.sprint.be_java_hisp_w21_g04.dto.response.ErrorDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import java.nio.charset.StandardCharsets;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PostIntegrationTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    @DisplayName("Desarrollo Individual - sellerFollowedListPost - Camino Triste")
    public void followerUserPost() throws Exception {
        ErrorDto errorDto = new ErrorDto("Los vendedores que sigues no tienen publicaciones", 400);
        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer();

        String ErrorExpected = writer.writeValueAsString(errorDto);
        MvcResult result = mockMvc.perform(get("/products/followed/{userId}/list", 6))
                .andExpect(status().isBadRequest())
                .andDo((mvcResult) ->{
                    System.out.println(mvcResult.getResponse().getContentAsString());
                })
                .andReturn();
        assertEquals(ErrorExpected, result.getResponse().getContentAsString(StandardCharsets.UTF_8));
        System.out.println(result.getResponse().getContentAsString());
    }
}
