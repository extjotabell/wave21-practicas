package com.example.arquitectura_multicapa_P1_VIVO.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponseDTO {
    String name;
    String height;
    String mass;
    String gender;
    String homeworld;
    String species;
}
