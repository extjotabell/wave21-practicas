package com.example.be_java_hisp_w21_g1.DTO.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PromoProductsCountDTO {
    int user_id;
    String user_name;
    int promo_products_count;
}
