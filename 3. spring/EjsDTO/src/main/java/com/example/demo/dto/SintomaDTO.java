package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private int nivelDeGravedad;
}