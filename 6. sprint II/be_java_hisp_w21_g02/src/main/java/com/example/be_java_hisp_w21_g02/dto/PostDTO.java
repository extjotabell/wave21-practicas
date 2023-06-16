package com.example.be_java_hisp_w21_g02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostDTO {
    private Integer userId;
    private Integer postId;
    private LocalDate date;
    private ProductDTO product;
    private Integer category;
    private Double price;

}