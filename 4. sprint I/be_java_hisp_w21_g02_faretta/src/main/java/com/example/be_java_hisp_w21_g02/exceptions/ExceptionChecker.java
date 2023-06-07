package com.example.be_java_hisp_w21_g02.exceptions;

import com.example.be_java_hisp_w21_g02.model.User;

public class ExceptionChecker {
    public static void checkUserAndSellerException(User persistedUser) {
        if(persistedUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }
        if (!persistedUser.isSeller()) {
            throw new UserNotSellerException("El usuario no es un vendedor");
        }
    }

    public static void checkFollowAndSellerException(User persistedUser, User persistedOtherUser) {

        if(persistedUser == null || persistedOtherUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }

        if (!persistedOtherUser.isSeller()){
            throw new UserNotSellerException("El usuario no es un vendedor");
        }
    }
}
