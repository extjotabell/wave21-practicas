package com.practicaJPA.miniSeries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "miniserie")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 200)
    private String name;

    @Column(name = "clasificacion")
    private Double rating;

    @Column(name = "cantidad_de_premios")
    private Integer amount_of_awards;

}
