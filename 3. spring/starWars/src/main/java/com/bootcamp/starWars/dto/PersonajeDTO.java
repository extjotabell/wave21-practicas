package com.bootcamp.starWars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDTO {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeWord;
    private String species;
}
