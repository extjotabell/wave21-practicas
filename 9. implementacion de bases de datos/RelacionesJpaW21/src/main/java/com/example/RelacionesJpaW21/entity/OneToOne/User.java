package com.example.RelacionesJpaW21.entity.OneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "usuarios")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "apellido")
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_address", referencedColumnName = "id")
    private Address address;
}
