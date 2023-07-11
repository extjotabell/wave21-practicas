package com.bootcamp.movies.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="genres")
public class Genres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String name;
    private int ranking;
    private int active;

    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Movie> movies;
    @OneToMany(mappedBy = "genre", cascade = CascadeType.ALL)
    private List<Serie> series;

}
