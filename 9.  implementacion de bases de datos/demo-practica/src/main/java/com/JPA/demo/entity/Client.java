package com.JPA.demo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cliente") // modifica algunas configuraciones
public class Client {

    @Id // Explicita que este atributo es una clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Explica como va a generar cada valor para el id.
    private Integer id;

    @Column(name = "correo", nullable = true, length = 50)
    private String email;

    @Column(name = "numero_tarjeta", nullable = false, length = 16)
    private String cardNumber;
}
