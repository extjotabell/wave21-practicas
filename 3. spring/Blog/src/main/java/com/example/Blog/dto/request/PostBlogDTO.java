package com.example.Blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PostBlogDTO {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
