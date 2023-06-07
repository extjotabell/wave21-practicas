package com.bootcamp.grupo3.socialmeli.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private Boolean has_promo = false;
    private double discount;
}
