package com.moviesdbhql.model.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "actors")
public class Actors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "created_at")
    private LocalDate createdAt;
    @Column(name = "updated_at")
    private LocalDate updatedAt;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private Double rating;
    @Column(name = "favorite_movie_id")
    private Long favoriteMovieId;

    @ManyToMany(mappedBy = "actors")
    Set<Movies> movies;

    @ManyToMany(mappedBy = "actors")
    Set<Episodes> episodes;
}
