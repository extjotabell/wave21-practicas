package com.example.be_java_hisp_w21_g02.dto.request;

import com.example.be_java_hisp_w21_g02.dto.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostPromoDTO extends PostRequestDTO{
    private boolean hasPromo;
    private double discount;
}
