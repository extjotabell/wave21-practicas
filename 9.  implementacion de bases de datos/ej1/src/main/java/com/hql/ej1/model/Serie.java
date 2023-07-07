package com.hql.ej1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp created_at;
    private Timestamp updated_at;
    private String title;
    private LocalDateTime release_date;
    private LocalDateTime end_date;
    @OneToOne
    @JsonIgnore
    @JoinColumn(name = "genre_id",referencedColumnName = "id")
    private Genre genre_id  ;
    @OneToMany(mappedBy = "serie")
    private List<Season> seasons;
}
