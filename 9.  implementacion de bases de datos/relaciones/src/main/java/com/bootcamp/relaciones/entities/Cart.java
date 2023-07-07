package com.bootcamp.relaciones.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart")
    private Set<ItemCart> items;
}
