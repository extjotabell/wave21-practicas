package com.example.segurosApi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate fabricacion;
    private Integer cantRuedas;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private Set<Siniestro> siniestros;
}
