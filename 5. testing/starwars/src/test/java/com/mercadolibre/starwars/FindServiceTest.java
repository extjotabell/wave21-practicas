package com.mercadolibre.starwars;


import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

@Mock
CharacterRepository charRepository;

@InjectMocks
FindService service;

@Test
@DisplayName("Encontrar todos los personajes con el nombre Biggs Darklighter")
void findCharacterByName() {
    List<CharacterDTO> payload = new ArrayList<>();
    payload.add(new CharacterDTO("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "male", "Tatooine", "Human"));
    List<CharacterDTO> espected = new ArrayList<>();
    espected.add(new CharacterDTO("Biggs Darklighter", 183, 84, "black", "light", "brown", "24BBY", "male", "Tatooine", "Human"));

    when(charRepository.findAllByNameContains("Biggs Darklighter")).thenReturn(payload);
    List<CharacterDTO> result = service.find("Biggs Darklighter");
    assertEquals(espected,result);

}
}
