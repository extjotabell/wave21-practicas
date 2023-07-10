package com.bootcamp.autos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name ="vehiculo")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "patente")
    private String patente;

    @Column(name = "marca")
    private String marca;

    @Column(name = "model")
    private String modelo;

    @Column(name = "anio_fabricacion")
    private int anioFabricacion;

    @Column(name = "cantidad_ruedas")
    private int cantRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.REMOVE)
    private Set<Siniestro> siniestros;
}
