package com.bootcamp.autos.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SiniestroDTO {
    private Long id;
    private LocalDate fechaDelSiniestro;
    private Double perdidaEconomica;
    private String message;

}
