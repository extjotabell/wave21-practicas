package com.example.demo.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "series")
public class Series {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  @Column(length = 500)
  private String title;
  @Column(name = "genre_id")
  private Integer genreId;

  @ManyToOne()
  private Set<Seasons> seasons;
}
