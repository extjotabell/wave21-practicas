package com.mercadolibre.starwars;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CharacterRepositoryTest {

    @Autowired
    CharacterRepository service;

    @BeforeEach
    void setup(){

    }
    @Test
    void findAllByNameContainsTest(){
        List<CharacterDTO> espected = new ArrayList<>();
        espected.add(new CharacterDTO("Biggs Darklighter",183,84,"black","light","brown","24BBY","male", "Tatooine", "Human"));

        List<CharacterDTO> characterDTOS = service.findAllByNameContains("Biggs Darklighter");

        assertEquals(espected,characterDTOS);
    }


}
