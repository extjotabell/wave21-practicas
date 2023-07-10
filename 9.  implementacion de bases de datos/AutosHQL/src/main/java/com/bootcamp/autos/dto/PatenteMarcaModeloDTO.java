package com.bootcamp.autos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PatenteMarcaModeloDTO {

    private String patente;
    private String marca;
    private String modelo;
}
