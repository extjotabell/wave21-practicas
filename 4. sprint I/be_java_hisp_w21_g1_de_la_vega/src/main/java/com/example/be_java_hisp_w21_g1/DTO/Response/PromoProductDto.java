package com.example.be_java_hisp_w21_g1.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class PromoProductDto {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
