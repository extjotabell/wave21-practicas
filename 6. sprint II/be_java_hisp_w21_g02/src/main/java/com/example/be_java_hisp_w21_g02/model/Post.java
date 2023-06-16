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
    private Integer userId;
    private Integer postId;
    private LocalDate date;
    private Integer category;
    private Double price;
    private Product product;
    // Parte Individual
    private boolean hasPromo;
    private double discount;
    // Parte Individual
}
