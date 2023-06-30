package com.sprint.be_java_hisp_w21_g04.dto.request;

import lombok.*;

@Getter
@Setter
public class PromoProductCountDto {

    private int userId;
    private String userName;
    private long promoProductsCount;

    public PromoProductCountDto(int userId, String userName, long promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }
}
