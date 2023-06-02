package com.bootcamp.blogenvivo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {

    private int id;
    private String title;
    private String author;
    private LocalDate publication;

}
