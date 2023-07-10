package com.movies.demoHQL.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;


@Entity @Getter @Setter
@Table(name= "vehiculo")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String patente;

    private String marca;

    private String modelo;

    private LocalDate añoFab;

    private Integer cantRuedas;

    @OneToMany(mappedBy = "vehiculo",cascade = CascadeType.ALL)
    private Set<Siniestro> listSiniestros;

}
