package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class FindServiceTest {

    @Mock
    CharacterRepository characterRepository;

    @InjectMocks
    FindService underTest;

    List<CharacterDTO> characterDTOSMock;

    @BeforeEach
    void setUp() {
        characterDTOSMock=mockCharacterDTO();
    }

    @Test
    void find() {
        String searchParam = "Darth";
        Mockito.when(characterRepository.findAllByNameContains(searchParam))
                .thenReturn(characterDTOSMock);

        List<CharacterDTO> characterDTOSResponse = underTest.find(searchParam);

        assertTrue(characterDTOSResponse.stream().allMatch(characterDTO -> characterDTO.getName().contains(searchParam)));
    }

    private List<CharacterDTO> mockCharacterDTO() {
        return Arrays.asList(new CharacterDTO("Darth Vader", 202, 136, "none", "white", "yellow", "41.9BBY", "male", "Tatooine", "Human"),
                new CharacterDTO("Darth Maul", 175, 80, "none", "red", "yellow", "54BBY", "male", "Dathomir", "Zabrak"));
    }
}