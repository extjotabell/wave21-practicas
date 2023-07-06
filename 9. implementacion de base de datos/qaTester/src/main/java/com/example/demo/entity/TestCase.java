package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "test_case")
public class TestCase {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_case")
  private Long id;

  @Column(name = "description")
  private String description;

  @Column(name = "tested")
  private Boolean tested;

  @Column(name = "passed")
  private Boolean passed;

  @Column(name = "num_of_tries")
  private int tried;

  @Column(name = "last_update")
  private LocalDate lastUpdate;
}
