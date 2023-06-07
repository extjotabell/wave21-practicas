package com.example.be_java_hisp_w21_g02.utils;

import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotSellerException;
import com.example.be_java_hisp_w21_g02.model.User;

public class Validations {
    public static void checkUserAndSellerException(User persistedUser) {
        if(persistedUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }
        if (!persistedUser.isSeller()) {
            throw new UserNotSellerException("El usuario no es un vendedor");
        }
    }

}
