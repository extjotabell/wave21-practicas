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


import static org.junit.jupiter.api.Assertions.*;
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
        espected.add(new CharacterDTO("Darth Vader",202,136,"none","white","yellow","41.9BBY","male", "Tatooine", "Human"));
        espected.add(new CharacterDTO("Darth Maul",175,80,"none","red","yellow","54BBY","male", "Dathomir", "Zabrak"));

        List<CharacterDTO> characterDTOS = service.findAllByNameContains("Darth ");

        assertArrayEquals(espected.toArray(),characterDTOS.toArray());
    }



}
