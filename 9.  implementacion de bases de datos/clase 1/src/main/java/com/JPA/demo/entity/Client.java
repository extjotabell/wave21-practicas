package com.JPA.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//hace q se mapee en la base de datos

@Entity

//sirve para modificar el nombre de tabla
@Table(name = "cliente")

public class Client {

    @Id //especifica q es una clave primaria
    @GeneratedValue(strategy = GenerationType.AUTO) //como genera el valor
    private Integer id;

    @Column(name = "correo", nullable = true)
    private String email;

    @Column(name = "numero_tarjeta", nullable = false, length = 16)
    private String cardNumber;
}
