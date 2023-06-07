package com.example.be_java_hisp_w21_g02.dto.response;

import lombok.Data;

@Data
public class PromoPostCountDto {
    private int userId;
    private String userName;
    private int promoProductsCount;

}