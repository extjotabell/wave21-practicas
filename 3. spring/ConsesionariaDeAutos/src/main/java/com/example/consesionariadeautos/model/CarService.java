package com.example.consesionariadeautos.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CarService {
    private LocalDate date;
    private String kilometers;
    private String description;
}
