package com.example.be_java_hisp_w21_g02.model;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Post {
    private int userId;
    private int postId;
    private LocalDate date;
    private int category;
    private double price;
    private Product product;
    // Parte Individual
    private boolean hasPromo;
    private double discount;
    // Parte Individual
}
