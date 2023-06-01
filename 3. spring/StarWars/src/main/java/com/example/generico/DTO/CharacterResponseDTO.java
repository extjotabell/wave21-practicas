package com.example.generico.DTO;

import com.example.generico.entity.Character;

public record CharacterResponseDTO (Integer id, String name, float height, float mass, String gender, String homeworld, String species) {
  public CharacterResponseDTO(Character c) {
    this(c.getId(), c.getName(), c.getHeight(), c.getMass(), c.getGender(), c.getHomeworld(), c.getSpecies());
  }
}
