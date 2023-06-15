package com.starwars.starwars.Integration.Controller;

import com.starwars.starwars.dto.CharacterDTO;
import com.starwars.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class FindControllerIntegrationTest {
    @Autowired
    MockMvc mockMvc;
    @MockBean
    private FindService findService;

    @Test
    public void testFindSuccess() throws Exception {
        String query = "Skywalker";

        CharacterDTO character1 = new CharacterDTO("Luke Skywalker", "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human", 172, 77);
        CharacterDTO character2 = new CharacterDTO("Anakin Skywalker", "blond", "fair", "blue", "41.9BBY", "male", "Tatooine", "Human", 188, 84);
        CharacterDTO character3 = new CharacterDTO("Shmi Skywalker", "black", "fair", "brown", "72BBY", "female", "Tatooine", "Human", 163, 90);

        List<CharacterDTO> listMock = Arrays.asList(character1, character2, character3);

        when(findService.find(query)).thenReturn(listMock);

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].name", is("Luke Skywalker")))
                .andExpect(jsonPath("$[1].name", is("Anakin Skywalker")))
                .andExpect(jsonPath("$[2].name", is("Shmi Skywalker")))
                .andReturn();
    }

    @Test
    public void testFindNotFoundResults() throws Exception {
        String query = "SOFA";
        List<CharacterDTO> expectedList = Collections.emptyList();
        when(findService.find(query)).thenReturn(expectedList);

        mockMvc.perform(MockMvcRequestBuilders.get("/{query}", query))
                .andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(0)))
                .andReturn();
    }
}
