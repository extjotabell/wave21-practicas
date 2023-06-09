package com.bootcamp.grupo3.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    private int id;
    private int userId;
    private LocalDate date;
    private int productId;
    private int category;
    private double price;
}
