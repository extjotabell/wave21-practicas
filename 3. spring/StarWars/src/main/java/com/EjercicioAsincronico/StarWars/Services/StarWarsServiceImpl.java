package com.EjercicioAsincronico.StarWars.Services;

import com.EjercicioAsincronico.StarWars.DTOs.CharacterDTO;
import com.EjercicioAsincronico.StarWars.Repositories.IStarWarsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StarWarsServiceImpl implements IStarWarsService {
    private final IStarWarsRepository _starWarsRepository;

    public StarWarsServiceImpl(IStarWarsRepository starWarsRepository) {
        _starWarsRepository = starWarsRepository;
    }

    @Override
    public List<CharacterDTO> findAllByNameContainsWord(String word) {
        return _starWarsRepository.findAllByNameContainsWord(word).stream()
                .map(
                        x -> new CharacterDTO(
                                x.getName(),x.getHeight(),x.getMass(),
                                x.getGender(), x.getHomeworld(), x.getSpecies()
                        )
                )
                .toList();
    }
}
