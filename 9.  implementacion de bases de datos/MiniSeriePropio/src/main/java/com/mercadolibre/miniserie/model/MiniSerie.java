package com.mercadolibre.miniserie.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter

@Entity
@Table(name = "miniserie")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private Double rating;
    @Column(name = "amount_of_awards")
    private Integer amountOfAwards;

}
