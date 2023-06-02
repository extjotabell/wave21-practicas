package com.bootcamp.blogenvivo.dto.requestDTO;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
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