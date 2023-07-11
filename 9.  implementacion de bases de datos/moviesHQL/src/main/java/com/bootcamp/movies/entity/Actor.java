package com.bootcamp.movies.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "actors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="created_at")
    private LocalDate createdAt;
    @Column(name= "updated_at")
    private LocalDate updatedAt;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="rating")
    private Double rating;



}
