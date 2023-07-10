package com.example.MiniSeries.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter

@Entity
@Table(name = "miniserie")
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double rating;

    private String name;
    @Column(name="amount_of_awards")
    private Integer amountOfAwards;
}
