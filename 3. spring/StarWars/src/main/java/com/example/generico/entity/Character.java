package com.example.generico.entity;

import com.example.generico.Color;
import com.example.generico.DTO.CharacterDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Character {

  private Integer id;
  private String name;
  private float height;
  private float mass;
  private Color hairColor;
  private Color skinColor;
  private Color eyeColor;
  private int birthYear;
  private String gender;
  private String homeworld;
  private String species;

  public Character(CharacterDTO c) {
    this.name = c.name();
    this.height = c.height();
    this.mass = c.mass();
    this.hairColor = c.hairColor();
    this.skinColor = c.skinColor();
    this.eyeColor = c.eyeColor();
    this.birthYear = c.birthYear();
    this.gender = c.gender();
    this.homeworld = c.homeworld();
  }
}
