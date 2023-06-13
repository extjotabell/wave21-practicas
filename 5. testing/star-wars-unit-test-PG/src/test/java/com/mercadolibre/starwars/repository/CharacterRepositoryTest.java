package com.mercadolibre.starwars.repository;

import com.mercadolibre.starwars.dto.CharacterDTO;
import com.mercadolibre.starwars.repositories.CharacterRepository;
import com.mercadolibre.starwars.repositories.CharacterRepositoryImpl;
import com.mercadolibre.starwars.service.FindService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CharacterRepositoryTest {
    @Mock
    FindService findService;

    @InjectMocks
    CharacterRepositoryImpl characterRepository;

    @Test
    public void findAllByNameContainsTest() {
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setName("Luke Skywalker");
        characterDTO.setHeight(172);
        characterDTO.setMass(77);
        characterDTO.setHair_color("blond");
        characterDTO.setSkin_color("fair");
        characterDTO.setEye_color("blue");
        characterDTO.setBirth_year("19BBY");
        characterDTO.setGender("male");
        characterDTO.setHomeworld("Tatooine");
        characterDTO.setSpecies("Human");

        List<CharacterDTO> response = characterRepository.findAllByNameContains("luke");
        assertFalse(response.isEmpty());
        assertNotNull(response.get(0));
        assertEquals(response.get(0).getName(),characterDTO.getName());
        assertEquals(response.get(0).getHeight(),characterDTO.getHeight());
        assertEquals(response.get(0).getMass(), characterDTO.getMass());
        assertEquals(response.get(0).getHair_color(), characterDTO.getHair_color());
        assertEquals(response.get(0).getSkin_color(), characterDTO.getSkin_color());
        assertEquals(response.get(0).getEye_color(), characterDTO.getEye_color());
        assertEquals(response.get(0).getBirth_year(), characterDTO.getBirth_year());
        assertEquals(response.get(0).getGender(), characterDTO.getGender());
        assertEquals(response.get(0).getHomeworld(), characterDTO.getHomeworld());
        assertEquals(response.get(0).getSpecies(), characterDTO.getSpecies());

    }
}
