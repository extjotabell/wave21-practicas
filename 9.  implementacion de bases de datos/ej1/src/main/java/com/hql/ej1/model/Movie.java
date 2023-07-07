package com.hql.ej1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String title;
    private Integer rating;
    private Integer awards;
    private LocalDateTime release_date;
    private Integer length;
    @OneToMany(mappedBy = "favoriteMovie")
    private List<Actor> actorFavMovie;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id",referencedColumnName = "id")
    @JsonIgnore
    private Genre genre_id;
    @ManyToMany(mappedBy = "actorMovie",fetch = FetchType.LAZY)
    private List<Actor> actors;
}
