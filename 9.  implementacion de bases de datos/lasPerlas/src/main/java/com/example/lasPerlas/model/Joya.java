package com.example.lasPerlas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table (name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nro_identificatorio;
    private String nombre;
    private String material;
    private int peso;
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
