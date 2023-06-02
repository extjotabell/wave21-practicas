package com.mercadolibre.starwarsapi.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class CharacterDTO {

    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;

}
