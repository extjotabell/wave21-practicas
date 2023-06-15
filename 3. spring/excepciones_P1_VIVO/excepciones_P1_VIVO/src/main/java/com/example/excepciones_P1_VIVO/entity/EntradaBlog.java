package com.example.excepciones_P1_VIVO.entity;


import lombok.*;

@Data
@AllArgsConstructor
@EqualsAndHashCode
public class EntradaBlog {
    Integer id;
    String titulo;
    String nombreAutor;
    String fechaPublicacion;
}
