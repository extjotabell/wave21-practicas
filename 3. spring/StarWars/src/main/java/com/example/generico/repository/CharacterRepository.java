package com.example.generico.repository;

import com.example.generico.entity.Character;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class CharacterRepository {
  private static final List<Character> characters = new ArrayList<>();

  public List<Character> getAll() {
    return characters;
  }

  public List<Character> findByName(final String name) {
    return characters
      .stream()
      .filter(c -> c.getName().toUpperCase().contains(name.toUpperCase()))
      .toList();
  }
  public Integer save(final Character c) {
    c.setId(characters.size());
    characters.add(c);

    return c.getId();
  }
}
