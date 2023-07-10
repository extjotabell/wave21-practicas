package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "seasons")
public class Seasons {
  @Id
  private Integer id;

  @OneToMany
  @JoinColumn(name = "serie_id", nullable = false)
  private Series serie;
}
