package com.example.be_java_hisp_w21_g02.dto.request;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import lombok.Data;

@Data
public class CreatePromoPostDTO {
    private int userId;
    private String date;        //Originalmente LocalDate
    private ProductDTO product;
    private int category;
    private double price;
    private boolean hasPromo;
    private double discount;
}
