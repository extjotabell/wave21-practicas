package com.clavescompuestas.model;

import com.clavescompuestas.model.key.CompraKey;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
@Table(name = "compra")
@IdClass(value = CompraKey.class)
public class Compra {

    @Id
    private Long clienteId;
    @Id
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate fecha;

    @Column(length = 50)
    private String descripcion;
}
