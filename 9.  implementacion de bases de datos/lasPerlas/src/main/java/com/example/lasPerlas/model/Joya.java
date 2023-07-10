package com.example.lasPerlas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table (name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(unique=true)
    private int identificationNumber;
    private String name;
    private String material;
    private int weight;
    private String particularity;
    private boolean hasWeight;
    private boolean saleOrNo;
}
