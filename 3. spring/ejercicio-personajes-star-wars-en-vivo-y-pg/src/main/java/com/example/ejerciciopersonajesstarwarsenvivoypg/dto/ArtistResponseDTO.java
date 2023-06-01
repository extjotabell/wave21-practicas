package com.example.ejerciciopersonajesstarwarsenvivoypg.dto;

import lombok.Data;

@Data
public class ArtistResponseDTO {
    private String name;
    private Integer height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}