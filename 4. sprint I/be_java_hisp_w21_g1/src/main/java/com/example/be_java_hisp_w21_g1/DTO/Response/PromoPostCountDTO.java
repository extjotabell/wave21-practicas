package com.example.be_java_hisp_w21_g1.DTO.Response;

import com.example.be_java_hisp_w21_g1.Model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoPostCountDTO {
    private int user_id;
    private String user_name;
    private int promo_products_count;
}
