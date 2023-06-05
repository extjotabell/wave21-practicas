package com.bootcamp.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogIdDTO {
    private String titulo;
    private String nombre;
    private String fecha;
}
