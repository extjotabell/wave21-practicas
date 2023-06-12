package com.mercadolibre.starwars.UnitTest.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {

    CharacterRepositoryImpl repository;

    @BeforeEach
    void setup(){
        repository = new CharacterRepositoryImpl();
    }

    @Test
    @DisplayName("Find All By Name Contains Test HappyPath")
    void findAllByNameContainsOk() {
        //Arrange
        String query = "Luke";
        List<CharacterDTO> characterDTOSActual = repository.findAllByNameContains(query);
        //Act
        //Assert
        assertEquals("Luke Skywalker", characterDTOSActual.get(0).getName());

    }

    @Test
    @DisplayName("Find All By Name Contains Test BadPath")
    void findAllByNameContainsNotOk() {
        //Arrange
        String query = "";

        List<CharacterDTO> characterDTOSActual = repository.findAllByNameContains(query);

        //Act
        //Assert
        assertThrows(FileNotFoundException.class, () -> {
            repository.findAllByNameContains(query);
        });

    }
}
