package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "mini_serie")
public class MiniSerie {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;

  @Column(name = "nombre", length = 20)
  String name;

  @Column(name = "rating", length = 20)
  Double rating;

  @Column(name = "premios", length = 3)
  int amountOfAwards;
}
