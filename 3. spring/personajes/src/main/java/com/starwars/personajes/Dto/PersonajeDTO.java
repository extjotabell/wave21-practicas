package com.starwars.personajes.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonajeDTO {
    private String name;
    private String height;
    private String mass;
    private String birthYear;
    private String gender;
    private String homeWorld;
    private String species;
}
