package com.example.generico.service;

import com.example.generico.DTO.CharacterDTO;
import com.example.generico.DTO.CharacterIdDTO;
import com.example.generico.DTO.CharacterResponseDTO;
import com.example.generico.entity.Character;
import com.example.generico.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CharacterService {

  @Autowired
  CharacterRepository characterRepository;

  public List<CharacterResponseDTO> getAllCharacters() {
    return characterRepository.getAll()
      .stream()
      .map(CharacterResponseDTO::new)
      .toList();
  }

  public List<CharacterResponseDTO> searchCharacterByName(final String name) {
    return characterRepository.findByName(name)
      .stream()
      .map(CharacterResponseDTO::new)
      .toList();
  }

  public CharacterIdDTO createCharacter(final CharacterDTO c) {
    Character character = new Character(c);

    return new CharacterIdDTO(characterRepository.save(character));
  }

  public List<CharacterIdDTO> createMultiCharacters(final List<CharacterDTO> characters) {
    return characters
      .stream()
      .map(this::createCharacter)
      .toList();
  }
}
