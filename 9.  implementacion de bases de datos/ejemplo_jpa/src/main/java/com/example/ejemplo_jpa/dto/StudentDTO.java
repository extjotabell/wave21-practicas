package com.example.ejemplo_jpa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor

public class StudentDTO {
    private Long id;
    private String dni;
    private String name;
    private String lastname;
}
