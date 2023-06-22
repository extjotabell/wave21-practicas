package com.example.be_java_hisp_w21_g1.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;


import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


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

}
