package com.example.be_java_hisp_w21_g02.integration;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Integration Test 02 - Post Incorrect Input Returns Validation Follow")
    void followUserInvalidInputReturnsValidationError() throws Exception {
        mockMvc.perform(post("/users/1/follow/-2"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("The following errors were found in the validations:"))
                .andExpect(jsonPath("$.description[0]").value("User ID to follow must be greater than zero"));
    }

    @Test
    @DisplayName("Integration Test 03 - Post Incorrect Input Returns Validation Unfollow")
    void unFollowUserInvalidInputReturnsValidationError() throws Exception {
        mockMvc.perform(post("/users/1/unfollow/-2"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.name").value("The following errors were found in the validations:"))
                .andExpect(jsonPath("$.description[0]").value("User ID to follow must be greater than zero"));
    }
}
