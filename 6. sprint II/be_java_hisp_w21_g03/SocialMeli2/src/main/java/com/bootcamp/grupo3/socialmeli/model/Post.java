package com.bootcamp.grupo3.socialmeli.model;

import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Post {
    private int id;
    private int userId;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
}
