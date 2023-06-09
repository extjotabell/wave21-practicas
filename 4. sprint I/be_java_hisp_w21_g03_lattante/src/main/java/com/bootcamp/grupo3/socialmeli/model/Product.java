package com.bootcamp.grupo3.socialmeli.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    protected int productId;
    protected String productName;
    protected String type;
    protected String brand;
    protected String color;
    protected String notes;
}
