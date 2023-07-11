package com.bootcamp.movies.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="seasons")
public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private int number;
    private LocalDate releaseDate;
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name= "serie_id", nullable = false)
    private Serie serie;
}
