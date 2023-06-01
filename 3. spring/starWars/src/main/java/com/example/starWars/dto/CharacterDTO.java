package com.example.starWars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterDTO {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

}
