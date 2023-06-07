package com.example.be_java_hisp_w21_g02.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PromoPostRequestDTO extends PostRequestDTO{
    private boolean hasPromo;
    private double discount;
}
