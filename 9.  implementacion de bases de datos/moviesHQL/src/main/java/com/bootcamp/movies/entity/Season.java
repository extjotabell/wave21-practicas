package com.bootcamp.movies.entity;

import java.time.LocalDate;

public class Season {


    private int id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private int number;
    private LocalDate releaseDate;
    private LocalDate endDate;
    // Relacion uno a muchos con Serie private int serieId;
}
