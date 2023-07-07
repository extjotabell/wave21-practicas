package com.seguros.seguros.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Siniestro")
public class Siniestro {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSiniestro;
    @Column(name = "fechaSiniestro")
    private LocalDate fechaSiniestro;
    @Column(name = "perdidaEconomica")
    private Double perdidaEconomica;

    private Long idVehiculoDenunciado;

    @ManyToOne
    @JoinColumn(name="idVehiculo",nullable = false)
    private Vehiculo vehiculo;


}
