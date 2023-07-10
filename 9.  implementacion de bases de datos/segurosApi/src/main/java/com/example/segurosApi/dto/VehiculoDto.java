package com.example.segurosApi.dto;

import com.example.segurosApi.model.Siniestro;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonFactory;
import jakarta.annotation.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VehiculoDto {
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fabricacion;
    private Integer cantRuedas;
    private Set<SiniestroDto> siniestros;
}
