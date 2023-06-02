package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {

    private Long id;
    private String titulo;
    private String nombre;
    private String fecha;

}
