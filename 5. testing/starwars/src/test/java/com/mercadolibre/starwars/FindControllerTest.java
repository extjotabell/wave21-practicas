package com.mercadolibre.starwars;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerTest {

@Autowired
MockMvc mockMvc;


@Test
@DisplayName("Encontrar el personaje Luke Skywalker")
public void findTest() throws Exception {
    List<CharacterDTO> espected = new ArrayList<>();
    espected.add(new CharacterDTO("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "male", "Tatooine", "Human"));

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    String result = writer.writeValueAsString(espected);
    MvcResult mvcResult = mockMvc.perform(get("/char/{query}", "Biggs Darklighter"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(mvcResult1 -> mvcResult1.getResponse().getContentAsString().equals(result))
            .andReturn();

    assertEquals("application/json", mvcResult.getResponse().getContentType());
}

}