package com.example.ejercicioBlog.dto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}