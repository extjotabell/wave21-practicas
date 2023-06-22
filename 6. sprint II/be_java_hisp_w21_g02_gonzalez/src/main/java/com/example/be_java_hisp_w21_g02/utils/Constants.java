package com.example.be_java_hisp_w21_g02.utils;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public  class Constants {
    public static final String ORDER_NAME_ASC = "name_asc";
    public static final String ORDER_NAME_DESC = "name_desc";
    public static final String ORDER_DATE_ASC = "date_asc";
    public static final String ORDER_DATE_DESC = "date_desc";

    public static boolean isOrderConstant(String order){
        return (
                Objects.equals(order, ORDER_NAME_ASC) ||
                Objects.equals(order, ORDER_NAME_DESC) ||
                Objects.equals(order, ORDER_DATE_ASC) ||
                Objects.equals(order, ORDER_DATE_DESC)
        );
    }

}
