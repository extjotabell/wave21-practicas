package com.example.be_java_hisp_w21_g02.utils;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.UserFollowingException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotSellerException;
import com.example.be_java_hisp_w21_g02.model.User;

import java.time.LocalDate;

public class ExceptionChecker {
    public static void checkUserAndSellerException(User persistedUser) {
        checkUserException(persistedUser);
        if (!persistedUser.isSeller()) {
            throw new UserNotSellerException("This user is not a seller");
        }
    }

    public static void checkUserException(User persistedUser) {
        if(persistedUser == null){
            throw new UserNotFoundException("This ID doesn't correspond to any user");
        }
    }

    public static void checkBadRequestException(PostRequestDTO postRequestDTO){
        if(!isValidRequest(postRequestDTO))
            throw new PostBadRequestException("We can't create a post with this data");

    }

    private static boolean isValidRequest(PostRequestDTO postRequestDTO){
        LocalDate date = DateConverter.stringToLocalDate(postRequestDTO.getDate());
        return postRequestDTO.getDate() != null && (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now()))
                && postRequestDTO.getPrice() >= 0;
    }

    public static void checkUserFollowingException(User persistedUser, User persistedUnFollowUser, String message) {
        checkUserException(persistedUser);
        checkUserException(persistedUnFollowUser);
        if(!persistedUser.verifyFollower(persistedUnFollowUser.getId())){
            throw new UserFollowingException(message);
        }
    }
}
