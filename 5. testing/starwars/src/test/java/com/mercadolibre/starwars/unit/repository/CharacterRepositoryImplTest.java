package com.mercadolibre.starwars.unit.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class CharacterRepositoryImplTest {


    CharacterRepository characterRepository = new CharacterRepositoryImpl();

    @Test
    @DisplayName("Compruebo que el metodo traiga todos los Dto´s relacionados con la query.")
    public void findAllByNameContainsOK(){
        //ARRANGE
        String query = "Dart";

        //ACT
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        //ASSERT
        Assertions.assertNotEquals(0, result.size());
    }


    @Test
    @DisplayName("Compruebo que el metodo no traiga Dto´s.")
    public void findAllByNameContainsNoOK(){
        //ARRANGE
        String query = "Query Not Found";

        //ACT
        List<CharacterDTO> result = characterRepository.findAllByNameContains(query);

        //ASSERT
        Assertions.assertEquals(0, result.size());
    }
}
