package com.bootcamp.movies.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="series")
public class Serie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate createdAt;
    private LocalDate updatedAt;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;

   @ManyToOne()
   @JoinColumn(name = "genre_id", nullable = false)
    private Genres genre;

   @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
   private List<Season> seasons;
}
