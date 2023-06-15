package com.starwars.starwars.Unit.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.starwars.dto.CharacterDTO;
import com.starwars.starwars.repositories.CharacterRepository;
import com.starwars.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {
    @Mock
    private CharacterRepository repository;

    @InjectMocks
    private FindService service;

    @Test
    public void testFind(){
        List<CharacterDTO> mockCharacters = this.loadDataBase();

        when(repository.findAllByNameContains(anyString())).thenReturn(mockCharacters);

        List<CharacterDTO> result = service.find("Skywalker");

        verify(repository).findAllByNameContains("Skywalker");

        assertEquals(mockCharacters, result);
    }

    private List<CharacterDTO> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<CharacterDTO>> typeRef = new TypeReference<>() {};
        List<CharacterDTO> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
}
