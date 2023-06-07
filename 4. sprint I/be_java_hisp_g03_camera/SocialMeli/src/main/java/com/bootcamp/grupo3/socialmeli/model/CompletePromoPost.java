package com.bootcamp.grupo3.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompletePromoPost {
    private int postId;
    private int userId;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    private double discount;
}
