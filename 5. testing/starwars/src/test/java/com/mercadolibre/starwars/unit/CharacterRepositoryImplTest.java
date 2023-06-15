package com.mercadolibre.starwars.unit;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryImplTest {
    @InjectMocks
    private CharacterRepositoryImpl characterRepository;

    @Test
    @DisplayName("findAllByNameContains return non empty collection")
    public void findAllByNameContainsTest_001(){
        //Arrange
        String query = "Darth";

        //Act
        List<CharacterDTO> response = characterRepository.findAllByNameContains(query);

        //Assert
        response.forEach(character -> Assertions.assertTrue(character.getName().contains(query)));
    }

    @Test
    @DisplayName("findAllByNameContains return empty collection")
    public void findAllByNameContainsTest_002(){
        //Arrange
        String query = "test";

        //Act
        List<CharacterDTO> response = characterRepository.findAllByNameContains(query);

        //Assert
        Assertions.assertTrue(response.isEmpty());
    }
}
