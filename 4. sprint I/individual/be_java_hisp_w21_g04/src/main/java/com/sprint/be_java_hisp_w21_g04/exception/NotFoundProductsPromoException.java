package com.sprint.be_java_hisp_w21_g04.exception;

public class NotFoundProductsPromoException extends RuntimeException{
    public NotFoundProductsPromoException(String message){
        super(message);
    }
}
