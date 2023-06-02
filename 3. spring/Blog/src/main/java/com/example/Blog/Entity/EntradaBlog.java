package com.example.Blog.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;
}
