package com.example.be_java_hisp_w21_g02.integration;

import com.example.be_java_hisp_w21_g02.dto.response.ErrorDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserControllerTest {
    @Autowired
    MockMvc mockMvc;
    private static ObjectWriter writer;
    private static ErrorDTO errorMessage;

    @BeforeAll
    public static void setUp() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .setPropertyNamingStrategy(new PropertyNamingStrategies.SnakeCaseStrategy())
                .writer().withDefaultPrettyPrinter();

    }
    @Test
    @DisplayName("Integration Test US01 01 - follow user which userId does not exist")
    public void testRegisterFollowUserDoesntExistIntegration() throws Exception{
        errorMessage = new ErrorDTO("This ID doesn't correspond to any user", HttpStatus.BAD_REQUEST);
        ResultMatcher expectedErrorJson = content().json(writer.writeValueAsString(errorMessage));


        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,3000))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(expectedErrorJson);

    }

    @Test
    @DisplayName("Integration Test US07 01 - unfollow user who is not a seller")
    public void testRegisterUnFollowNotSellerUserIntegration() throws Exception{
        errorMessage = new ErrorDTO("This user is not a seller", HttpStatus.BAD_REQUEST);
        ResultMatcher expectedErrorJson = content().json(writer.writeValueAsString(errorMessage));


        mockMvc.perform(post("/users/{userId}/follow/{userIdToFollow}", 1,2))
                .andDo(print())
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(expectedErrorJson);

    }
}
