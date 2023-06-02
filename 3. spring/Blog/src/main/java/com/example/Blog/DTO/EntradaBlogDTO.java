package com.example.Blog.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDTO {
    private int id;
    private String nombre;
    private String fecha;
    private String autor;
}
