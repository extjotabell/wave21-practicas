package com.example.starwars.unit.model;

import com.example.starwars.model.Character;
import com.example.starwars.repository.ICharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CharacterTest {
    @Mock
    private Character character;

    @Test
    public void testNameContains_WhenQueryMatches() {
        // Arrange
        Character character = new Character("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human");
        //act
        boolean result = character.nameContains("Skywalker");

        //assert
        assertTrue(result);
    }

    @Test
    public void testNameContains_WhenQueryDoesNotMatch() {
        //  Arrange
        Character character = new Character("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human");

        // act
        boolean result = character.nameContains("Vader");

        // Assert
        assertFalse(result);
    }
}
