package com.bootcamp.movies.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private Long rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;

    @ManyToOne()
    @JoinColumn(name = "genre_id", nullable = false)
    private Genres genre;

}
