package com.example.RelacionesJpaW21.entity.OneToOne;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "usuario")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String apellido;

    private String correo;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address direccion;
}
