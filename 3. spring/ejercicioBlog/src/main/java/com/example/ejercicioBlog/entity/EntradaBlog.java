package com.example.ejercicioBlog.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
