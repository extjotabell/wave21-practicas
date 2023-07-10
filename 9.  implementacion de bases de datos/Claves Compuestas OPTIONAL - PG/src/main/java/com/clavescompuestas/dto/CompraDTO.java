package com.clavescompuestas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class CompraDTO {
    private Long clienteId;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    private String descripcion;
}
