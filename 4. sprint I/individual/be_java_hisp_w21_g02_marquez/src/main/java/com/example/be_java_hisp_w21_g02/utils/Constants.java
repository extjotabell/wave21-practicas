package com.example.be_java_hisp_w21_g02.utils;

import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public  class Constants {
    //region Constantes de Mensajes
    public static final String USER_NOT_FOUND_BY_ID_MESSAGE = "No se pudo encontrar un usuario con el ID mencionado.";
    public static final String POST_REQUEST_NOT_VALID_MESSAGE = "Peticion de publicacion invalida.";
    public static final String PROMO_POST_REQUEST_NOT_VALID_MESSAGE = "La Publicacion es invalida ya que no posee los campos necesarios de promocion";
    //endregion

    //region Constantes de Ordenamiento
    public static final String ORDER_NAME_ASC = "name_asc";
    public static final String ORDER_NAME_DESC = "name_desc";
    public static final String ORDER_DATE_ASC = "date_asc";
    public static final String ORDER_DATE_DESC = "date_desc";
    public static final String FILTER_BETWEEN_PRICE = "price";

    //endregion

    public static boolean isOrderConstant(String order){
        return (
                Objects.equals(order, ORDER_NAME_ASC) ||
                Objects.equals(order, ORDER_NAME_DESC) ||
                Objects.equals(order, ORDER_DATE_ASC) ||
                Objects.equals(order, ORDER_DATE_DESC) ||
                Objects.equals(order, FILTER_BETWEEN_PRICE)
        );
    }

}
