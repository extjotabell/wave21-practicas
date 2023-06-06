package com.example.be_java_hisp_w21_g1.DTO.Response;

import com.example.be_java_hisp_w21_g1.Model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostDTO {
    private int user_id;
    private int post_id;
    private String date;
    private Product product;
    private int category;
    private double price;

}
