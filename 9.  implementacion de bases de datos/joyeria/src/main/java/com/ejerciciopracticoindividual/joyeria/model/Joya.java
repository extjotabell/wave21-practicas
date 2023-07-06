package com.ejerciciopracticoindividual.joyeria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String material;
    private Integer peso;
    private String particularidad;
    private Boolean posee_piedra;
    private Boolean ventaONo;
}
