package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaDTO {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
}