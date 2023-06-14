package com.mercadolibre.starwars.repositories;

import com.mercadolibre.starwars.dto.CharacterDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CharacterRepositoryImplTest {

    @InjectMocks
    CharacterRepositoryImpl underTest;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAllByNameContains() {
        String nameToSearch = "Darth";
        List<CharacterDTO> characterDTOSResponse = underTest.findAllByNameContains(nameToSearch);

        assertTrue(characterDTOSResponse.stream().map(characterDTO -> characterDTO.getName())
                .allMatch(c -> c.contains(nameToSearch)));
    }


}