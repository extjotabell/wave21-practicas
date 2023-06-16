package com.example.be_java_hisp_w21_g02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostDTO {
    private int userId;
    private int postId;
    private String date;
    private ProductDTO product;
    private int category;
    private double price;

}
