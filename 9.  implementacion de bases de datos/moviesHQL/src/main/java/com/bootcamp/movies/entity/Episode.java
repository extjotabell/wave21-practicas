package com.bootcamp.movies.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "episodes")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public String createdAt;
    public String updatedAt;
    public String title;
    public int number;
    public String releaseDate;
    public double rating;

    @ManyToOne()
    @JoinColumn(name="season_id", nullable = false)
    public Season season;
}
