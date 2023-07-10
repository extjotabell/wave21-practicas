package com.bootcamp.MiniSeries.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class MiniSerie {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private Double rating;
    private int awards;

    public MiniSerie() {}

    public MiniSerie(Long id, String name, Double rating, int awards) {
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.awards = awards;
    }


}
