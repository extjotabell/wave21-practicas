package com.example.starwars.integration.controller;

import com.example.starwars.controller.FindController;
import com.example.starwars.dto.CharacterDTO;
import com.example.starwars.service.IFindService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class FindControllerTest {
    @Mock
    private IFindService findService;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        FindController findController = new FindController(findService);
        mockMvc = MockMvcBuilders.standaloneSetup(findController).build();
    }
    @DisplayName("Probando Find del controllador")
    @Test
    public void testFind() throws Exception {

        // Arrange
        String name = "Luke Skywalker";
        int height = 172;
        int mass = 77;
        String gender = "male";
        String homeworld = "Tatooine";
        String species = "Human";

        // Mock the service
        List<CharacterDTO> expectedCharacters = Arrays.asList(
                new CharacterDTO(name, height, mass, gender, homeworld, species),
                new CharacterDTO("Darth Vader", height, mass, gender, homeworld, species)
        );
        when(findService.find("Skywalker")).thenReturn(expectedCharacters);

        // Act
        MvcResult mvcResult = mockMvc.perform(get("/Skywalker"))
                .andExpect(status().isOk())
                .andReturn();

        // Assert
        String response = mvcResult.getResponse().getContentAsString();
        List<CharacterDTO> result = Arrays.asList(new ObjectMapper().readValue(response, CharacterDTO[].class));
        assertEquals(expectedCharacters.size(), result.size());
        assertTrue(result.containsAll(expectedCharacters));

        // Verificando que el parametro fue llamado correctamente
        verify(findService, times(1)).find("Skywalker");
    }
}
