package com.example.joyeria.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    private Boolean poseePiedra;
    private Boolean ventaONo;
}
