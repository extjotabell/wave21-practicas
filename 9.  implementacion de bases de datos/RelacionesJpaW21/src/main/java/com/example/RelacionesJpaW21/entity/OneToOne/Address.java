package com.example.RelacionesJpaW21.entity.OneToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="id")
    private Long id;

    @Column(name = "street")
    private String street;
    @Column(name ="number")
    private int number;

    @OneToOne(mappedBy = "address")
    private User user;
}
