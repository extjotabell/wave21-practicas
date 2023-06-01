package com.covid19.covid;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Sintoma {
    private int codigo;
    private String nombre;
    private int nivel_de_gravedad;


}
