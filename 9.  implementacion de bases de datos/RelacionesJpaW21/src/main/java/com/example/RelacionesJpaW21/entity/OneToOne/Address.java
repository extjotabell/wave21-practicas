package com.example.RelacionesJpaW21.entity.OneToOne;

import jakarta.persistence.*;

@Entity
@Table(name = "address" )
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "address")
    private User user;
}
