package com.example.RelacionesJpaW21.entity.OneToOne;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "direccion")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;

    @OneToOne(mappedBy = "address")
    private User user;
}
