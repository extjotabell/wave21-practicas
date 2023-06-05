package com.sprint.be_java_hisp_w21_g04.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private int user_id;
    private LocalDate date;
    private Product product;
    private int category;
    private double price;
    private boolean has_promo;
    private double discount;

}
