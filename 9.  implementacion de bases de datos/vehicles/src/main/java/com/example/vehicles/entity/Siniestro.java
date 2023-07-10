package com.example.vehicles.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "siniestros")
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fecha;
    private Integer perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;


}
