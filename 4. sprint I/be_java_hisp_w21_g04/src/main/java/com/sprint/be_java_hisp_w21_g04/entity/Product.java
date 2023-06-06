package com.sprint.be_java_hisp_w21_g04.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    private int product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

}
