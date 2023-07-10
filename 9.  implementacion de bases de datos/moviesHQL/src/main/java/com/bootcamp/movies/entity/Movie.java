package com.bootcamp.movies.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Long rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
    // CLAVE FORANEA CON GENERO private Integer genreId;
}
