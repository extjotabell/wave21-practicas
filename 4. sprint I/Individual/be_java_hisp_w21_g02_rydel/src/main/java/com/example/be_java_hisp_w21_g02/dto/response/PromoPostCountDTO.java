package com.example.be_java_hisp_w21_g02.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PromoPostCountDTO {
    private int userId;
    private String userName;
    private int promoPostCount;
}
