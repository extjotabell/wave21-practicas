package com.mercadolibre.blog.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class ResponseBlogDTO {

    private int id;
    private String title;
    private String author;
    private LocalDate publication;
}