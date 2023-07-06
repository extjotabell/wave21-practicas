package com.example.miniserie.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mini_serie")
public class MiniSerie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private Double rating;

    @Column
    private int amount_of_awards;
}
