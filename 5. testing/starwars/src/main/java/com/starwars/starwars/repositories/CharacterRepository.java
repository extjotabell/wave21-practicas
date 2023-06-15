package com.starwars.starwars.repositories;

import com.starwars.starwars.dto.CharacterDTO;

import java.util.List;

public interface CharacterRepository {
  List<CharacterDTO> findAllByNameContains(String query);
}
