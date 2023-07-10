package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer nro_identificatorio;

    String nombre;
    String material;
    double peso;
    String particularidad;
    boolean posee_piedra;
    boolean ventaONo;
}
