package com.practicaJPA.joyeria.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "joya")
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", length = 200)
    private String name;

    @Column(name = "material", length = 50)
    private String material;

    @Column(name = "peso")
    private Integer weight;

    @Column(name = "particularidad", length = 250)
    private String particularity;

    @Column(name = "tiene_piedra")
    private Boolean hasStone;

    @Column(name = "venta")
    private Boolean saleOrNoSale;
}
