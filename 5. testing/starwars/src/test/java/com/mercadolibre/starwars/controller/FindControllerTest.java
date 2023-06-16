package com.mercadolibre.starwars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeAll;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindControllerTest {


    private static ObjectWriter writer;

    @BeforeAll
    public static void beforeAll() {
        writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
                .writer().withDefaultPrettyPrinter();

    }
    @Autowired
    MockMvc mockMvc;
    @Test
    public void findOK() throws Exception {

                mockMvc.perform(get("/{query}","Luke"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Luke Skywalker"))
                .andReturn();
    }

    @Test
    public void findOkAll() throws Exception{

        CharacterDTO luke1 = new CharacterDTO("Luke Skywalker",  "blond", "fair", "blue", "19BBY",
                "male", "Tatooine", "Human",172, 77);

        List<CharacterDTO> expected = new ArrayList<>();
        expected.add(luke1);

        String jsonPayLoad = writer.writeValueAsString(expected);

        mockMvc.perform((get("/{query}", "Luke")))
                .andDo(print())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(jsonPayLoad));
    }
    @Test
    public void findNotFind() throws Exception {

        mockMvc.perform(get("/{query}","Juan"))
                .andDo(print())
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"))
                .andReturn();
    }

}
