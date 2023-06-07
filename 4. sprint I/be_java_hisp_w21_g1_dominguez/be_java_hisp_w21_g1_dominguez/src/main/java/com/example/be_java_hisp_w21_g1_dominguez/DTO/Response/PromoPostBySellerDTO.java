package com.example.be_java_hisp_w21_g1_dominguez.DTO.Response;

import com.example.be_java_hisp_w21_g1_dominguez.DTO.Request.PromoPostDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostBySellerDTO {
    private int user_id;
    private String user_name;
    private Long promo_products_count;
}
