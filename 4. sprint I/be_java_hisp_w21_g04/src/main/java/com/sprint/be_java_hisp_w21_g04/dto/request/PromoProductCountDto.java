package com.sprint.be_java_hisp_w21_g04.dto.request;

public class PromoProductCountDto {

    private int userId;
    private String userName;
    private long promoProductsCount;

    // Constructor
    public PromoProductCountDto(int userId, String userName, long promoProductsCount) {
        this.userId = userId;
        this.userName = userName;
        this.promoProductsCount = promoProductsCount;
    }

    // Getters and Setters
    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getPromoProductsCount() {
        return this.promoProductsCount;
    }

    public void setPromoProductsCount(long promoProductsCount) {
        this.promoProductsCount = promoProductsCount;
    }
}
