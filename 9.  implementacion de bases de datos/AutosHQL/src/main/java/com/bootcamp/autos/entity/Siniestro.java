package com.bootcamp.autos.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "siniestro")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha")
    private LocalDate fechaDelSiniestro;

    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne()
    @JoinColumn(name = "vehiculo_id", nullable = false)
    private Vehiculo vehiculo;
}
