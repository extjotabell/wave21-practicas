package com.bootcamp.relaciones.entities;

import jakarta.persistence.*;

@Entity
@Table(name="item")
public class ItemCart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Cart cart;
}
