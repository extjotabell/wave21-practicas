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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "episodes")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String title;
    private Integer number;
    private LocalDateTime release_date;
    private BigDecimal rating;
    @ManyToOne
    @JoinColumn(name = "season_id",unique = true)
    @JsonIgnore
    private Season season;
    @ManyToMany(mappedBy = "actorEpisode")
    @JsonIgnore
    private List<Actor> episodeActor;
}
