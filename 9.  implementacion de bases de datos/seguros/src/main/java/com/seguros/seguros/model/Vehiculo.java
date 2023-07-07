package com.seguros.seguros.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "Vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idVehiculo")
    private Long idVehiculo;
    private String patente;
    private String marca;
    private String modelo;


    private Integer anioFabricacion;

    @Column(name = "cantidadRuedas")
    private Integer cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;



}
