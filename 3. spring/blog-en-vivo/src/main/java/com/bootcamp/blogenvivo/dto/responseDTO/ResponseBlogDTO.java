package com.bootcamp.blogenvivo.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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