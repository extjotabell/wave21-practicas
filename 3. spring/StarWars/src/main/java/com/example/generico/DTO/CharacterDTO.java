package com.example.generico.DTO;

import com.example.generico.Color;

public record CharacterDTO(String name, float height, float mass, Color hairColor, Color skinColor, Color eyeColor, int birthYear,  String gender, String homeworld, String species) {
}
