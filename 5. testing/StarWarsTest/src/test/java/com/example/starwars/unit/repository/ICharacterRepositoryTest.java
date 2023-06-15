package com.example.starwars.unit.repository;

import com.example.starwars.model.Character;
import com.example.starwars.repository.ICharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class ICharacterRepositoryTest {
    @Mock
    private ICharacterRepository characterRepository;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("buscamos ambos objetos creados por apellido y que existan")
    @Test
    public void testFindAllByNameContains() {
        // Arrange
        Character character1 = new Character("Luke Skywalker",172,123,"blond","fair","blue","19BBY","male","Tatooine","Human");
        Character character2 = new Character("Anakin Skywalker",172,123,"blond","fair","blue","19BBY","male","Tatooine","Human");
        List<Character> characters = Arrays.asList(character1, character2);

        // Act
        when(characterRepository.findAllByNameContains("Skywalker")).thenReturn(characters);
        List<Character> result = characterRepository.findAllByNameContains("Skywalker");

        //// Assert
        assertEquals(2, result.size());
        assertTrue(result.contains(character1));
        assertTrue(result.contains(character2));
    }

}
