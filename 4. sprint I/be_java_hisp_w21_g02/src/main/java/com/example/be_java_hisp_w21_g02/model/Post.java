package com.example.be_java_hisp_w21_g02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Post {
    private int id;
    private LocalDate date;
    private int category;
    private double price;
    private List<Product> products;
    // Parte Individual
    private boolean hasPromo;
    private double discount;
    // Parte Individual
}
