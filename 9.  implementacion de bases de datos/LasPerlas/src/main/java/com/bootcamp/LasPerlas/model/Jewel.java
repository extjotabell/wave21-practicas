package com.bootcamp.LasPerlas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nro_identificatorio")
    private long nroIdentificatorio;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    private boolean saleOrNot;

}
