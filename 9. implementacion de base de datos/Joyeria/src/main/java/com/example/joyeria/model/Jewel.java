package com.example.joyeria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String material;

    @Column
    private Double weight;

    @Column
    private String particularity;

    @Column
    private Boolean hasStone;

    @Column
    private Boolean status;
}
