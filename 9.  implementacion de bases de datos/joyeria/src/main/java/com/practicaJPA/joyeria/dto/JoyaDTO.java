package com.practicaJPA.joyeria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JoyaDTO {

    private Integer id;

    private String name;

    private String material;

    private Integer weight;

    private String particularity;

    private Boolean hasStone;

    private Boolean saleOrNoSale;
}
