package com.example.Blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaDTO {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
