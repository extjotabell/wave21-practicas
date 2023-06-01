package com.example.consesionariadeautos.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class CarServiceDTO {
    private LocalDate date;
    private String kilometers;
    private String description;
}
