package com.joyeria.lasperlas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long nroIdentificatorio;


    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    @Column(name = "venta_o_no")
    private Boolean ventaONo;
}
