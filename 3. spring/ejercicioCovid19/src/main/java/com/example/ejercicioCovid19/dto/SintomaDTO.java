package com.example.ejercicioCovid19.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class SintomaDTO {
    private int codigo;
    private String nombre;
    private String nivel_de_gravedad;


}
