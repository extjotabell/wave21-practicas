package com.example.StarsWars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PersonajesDTO {

    String name;
    int height;
    int mass;
    String gender;
    String homeworld;
    String species;
}
