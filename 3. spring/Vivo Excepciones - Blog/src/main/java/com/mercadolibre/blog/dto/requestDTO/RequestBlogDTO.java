package com.mercadolibre.blog.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;


import java.time.LocalDate;


@Getter
@NoArgsConstructor @AllArgsConstructor
public class RequestBlogDTO {

    private int id;
    private String title;
    private String author;
    private LocalDate publication;

}

