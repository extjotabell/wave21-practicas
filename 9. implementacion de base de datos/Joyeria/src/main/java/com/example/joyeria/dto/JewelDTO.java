package com.example.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JewelDTO {
    private Long id;
    private String name;
    private String material;
    private Double weight;
    private String particularity;
    private Boolean hasStone;
}
