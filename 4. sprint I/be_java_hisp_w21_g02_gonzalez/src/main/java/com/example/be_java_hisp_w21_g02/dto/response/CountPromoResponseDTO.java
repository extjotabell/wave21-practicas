package com.example.be_java_hisp_w21_g02.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor
@Getter
public class CountPromoResponseDTO {
    //INDIVIDUAL US0011
    private int userId;
    private String userName;
    private int promoProductsCount;
}
