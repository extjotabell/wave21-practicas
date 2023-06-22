package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Error.ErrorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;






@AutoConfigureMockMvc
@SpringBootTest
public class UserControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("[US - 0003] - Getting followers list - Happy Path")
    public void getFollowerList() throws Exception {
        var request = get("/users/{userId}/followers/list", 1);

        mockMvc.perform(request)
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_name").value("Pablo"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.followers[0].user_id").value(2));
    }

    @Test
    @DisplayName("[US - 0003] - Getting followers list - Unhappy Path")
    public void getFollowerListForANonExisting() throws Exception {
        int nonExistingId = 99;

        ErrorDTO error = new ErrorDTO("No se encontro el usuario con el ID"+ nonExistingId);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();
        String result = writer.writeValueAsString(error);

        MvcResult response = mockMvc.perform(get("/users/{userId}/followers/list", nonExistingId))
                .andDo(print())
                .andExpect(status().isNotFound())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        assertEquals(result,response.getResponse().getContentAsString());
    }


}
