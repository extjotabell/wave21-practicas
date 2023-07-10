package com.example.lasPerlasJoyeria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name="joya")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name="posee_piedra")
    private Boolean poseePiedra;
    @Column(name = "venta_o_No")
    private Boolean ventaONo;
}
