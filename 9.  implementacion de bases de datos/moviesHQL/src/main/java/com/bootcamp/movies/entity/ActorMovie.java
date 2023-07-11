package com.bootcamp.movies.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name= "actor_movie")
public class ActorMovie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate createdAt;
    private LocalDate updatedAt;

    @ManyToOne
    @JoinColumn(name = "actor_id")
    private Actor actor;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;
}