package com.example.be_java_hisp_w21_g02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private boolean hasPromo = false;
    private double discount = 0;
    // Parte Individual
}
