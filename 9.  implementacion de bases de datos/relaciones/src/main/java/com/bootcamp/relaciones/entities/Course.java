package com.bootcamp.relaciones.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "course")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    @ManyToMany(mappedBy = "likedCourse")
    private Set<Student> likes;
}
