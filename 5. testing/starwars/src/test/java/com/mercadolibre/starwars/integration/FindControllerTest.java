package com.mercadolibre.starwars.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Verifico que me devuelva una lista no vacia con todas las coincidencias.")
    public void findOk() throws Exception{
        //ARRANGE
        String query = "Dar";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}", query);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //Act
        MvcResult result = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andReturn();

        String json = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
        List<CharacterDTO> listRespose =   new ObjectMapper().readValue(json, List.class);

        //ASSERT
        //assertEquals("application/json", result.getResponse().getContentType());
        assertNotEquals(0, listRespose.size());
    }

    @Test
    @DisplayName("Verifico que me devuelva una lista vacia sin coincidencias.")
    public void findNoOk() throws Exception{
        //ARRANGE
        String query = "Query not found";

        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/{query}", query);
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType("application/json");

        //Act
        MvcResult result = mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andReturn();

        String json = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
        List<CharacterDTO> listRespose =   new ObjectMapper().readValue(json, List.class);

        //ASSERT
        //assertEquals("application/json", result.getResponse().getContentType());
        assertEquals(0, listRespose.size());
    }
}
