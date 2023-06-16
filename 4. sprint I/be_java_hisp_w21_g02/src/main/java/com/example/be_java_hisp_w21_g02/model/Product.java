package com.example.be_java_hisp_w21_g02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    private int productId;
    private String productName;
    private String type;
    private String brand;
    private String color;
    private String notes;
}
