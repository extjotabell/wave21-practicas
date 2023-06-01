package com.bootcamp.starwars.model;

import lombok.Data;

@Data
public class Character {
    private String name;
    private int height;
    private int mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public boolean nameContains(String query){
        return this.name.toUpperCase().contains(query.toUpperCase());
    }
}
