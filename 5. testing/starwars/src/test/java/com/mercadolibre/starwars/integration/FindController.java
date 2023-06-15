package com.mercadolibre.starwars.integration;

import ch.qos.logback.core.net.ObjectWriter;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class FindController {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void find() throws Exception {
        String query = "Darth";

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andReturn();

        List<CharacterDTO> response = new ObjectMapper().readValue(result.getResponse().getContentAsString(), new TypeReference<List<CharacterDTO>>(){});

        response.forEach(character -> Assertions.assertTrue(character.getName().contains(query)));
    }
}
