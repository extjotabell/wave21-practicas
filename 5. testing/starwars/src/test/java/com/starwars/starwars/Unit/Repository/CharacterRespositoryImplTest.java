package com.starwars.starwars.Unit.Repository;

import com.starwars.starwars.dto.CharacterDTO;
import com.starwars.starwars.repositories.CharacterRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class CharacterRespositoryImplTest {

    @InjectMocks
    private CharacterRepositoryImpl repository;

    @Test
    public void testFinAllByNameContainsReturnsMatching(){
        List<CharacterDTO> result = repository.findAllByNameContains("Skywalker");
        assertEquals(3, result.size());
        assertEquals("Luke Skywalker", result.get(0).getName());
        assertEquals(172, result.get(0).getHeight());
        assertEquals(77, result.get(0).getMass());
        assertEquals("blond", result.get(0).getHair_color());
        assertEquals("fair", result.get(0).getSkin_color());
        assertEquals("blue", result.get(0).getEye_color());
        assertEquals("19BBY", result.get(0).getBirth_year());
        assertEquals("male", result.get(0).getGender());
        assertEquals("Tatooine", result.get(0).getHomeworld());
        assertEquals("Human", result.get(0).getSpecies());
    }

    @Test
    public void testFinAllByNameContainsReturnsOne(){
        CharacterDTO result = repository.findAllByNameContains("Skywalker").get(0);
        assertEquals("Luke Skywalker", result.getName());
        assertEquals(172, result.getHeight());
        assertEquals(77, result.getMass());
        assertEquals("blond", result.getHair_color());
        assertEquals("fair", result.getSkin_color());
        assertEquals("blue", result.getEye_color());
        assertEquals("19BBY", result.getBirth_year());
        assertEquals("male", result.getGender());
        assertEquals("Tatooine", result.getHomeworld());
        assertEquals("Human", result.getSpecies());
    }

    @Test
    public void testFinAllByNameContainsReturnEmptyList(){
        List<CharacterDTO> result = repository.findAllByNameContains("SOFA");
        assertEquals(0, result.size());
    }

    @Test
    public void testFinAllByNameQueryEmpty(){
        List<CharacterDTO> result = repository.findAllByNameContains("");
        assertEquals(87, result.size());
    }

}
