package com.example.jewel.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Jewel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column
    private String name;
    @Column
    private String material;
    @Column
    private Double weight;
    @Column
    private String peculiarity;
    @Column
    private boolean has_stone;
    @Column
    private boolean isSold;

}
