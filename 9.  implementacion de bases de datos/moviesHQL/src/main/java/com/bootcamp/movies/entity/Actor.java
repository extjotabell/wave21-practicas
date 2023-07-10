package com.bootcamp.movies.entity;

import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table("actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate created_at;
    private LocalDate updated_at;
    private String first_name;
    private String last_name;
    private Double rating;

    //favorite_movie_id

}
