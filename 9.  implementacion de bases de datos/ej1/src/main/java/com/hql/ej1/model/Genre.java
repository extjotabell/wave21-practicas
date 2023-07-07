package com.hql.ej1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String name;
    private Integer ranking;
    private Byte active;
    @OneToMany(mappedBy = "genre_id")
    @JsonIgnore
    private List<Movie> movie;
    @OneToOne(mappedBy = "genre_id")
    @JsonIgnore
    private Serie serie;
}
