package com.example.be_java_hisp_w21_g02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDTO {
    private Integer productId;
    private String productName;
    private String brand;
    private String type;
    private String color;
    private String notes;
}
