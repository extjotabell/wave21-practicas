package com.covid19.covid19.DTOS;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sintoma {
    private Long codigo;
    private String  nombre;
    private Integer nivelDeGravedad;
}
