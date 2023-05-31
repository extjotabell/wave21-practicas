package com.ejcovid.ejcovid.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Sintoma {
   private int codigo;
   private String nombre;
   private String nivel_de_gravedad;
}
