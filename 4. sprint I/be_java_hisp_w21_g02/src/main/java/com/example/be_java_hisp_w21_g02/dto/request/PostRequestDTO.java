package com.example.be_java_hisp_w21_g02.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PostRequestDTO {
    private int userId;
    private String date;        //Originalmente LocalDate
    private ProductDTO product;
    private int category;
    private double price;
}
