package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService findService;

    @Test
    public void findTest() {
        when(characterRepository.findAllByNameContains(anyString())).thenReturn(Collections.emptyList());
        assertTrue(findService.find(anyString()).isEmpty());
    }
}