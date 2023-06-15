package com.starwars.starwars.service;

import com.starwars.starwars.dto.CharacterDTO;
import com.starwars.starwars.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindService {
  private final CharacterRepository characterRepository;

  public FindService(CharacterRepository characterRepository) {
    this.characterRepository = characterRepository;
  }

  public List<CharacterDTO> find(String query) {
    return characterRepository.findAllByNameContains(query);
  }
}
