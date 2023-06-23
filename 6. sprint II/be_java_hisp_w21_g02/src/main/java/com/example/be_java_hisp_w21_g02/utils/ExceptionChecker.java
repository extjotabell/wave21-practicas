package com.example.be_java_hisp_w21_g02.utils;

import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.exceptions.PostBadRequestException;
import com.example.be_java_hisp_w21_g02.exceptions.UserFollowingException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotSellerException;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.exceptions.OrderNotFoundException;

import java.time.LocalDate;
import java.util.Objects;

public class ExceptionChecker {

    public static void checkUserAndSellerException(User persistedUser) {
        checkUserException(persistedUser);
        if (persistedUser.getPosts().isEmpty()) {
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
        LocalDate date = postRequestDTO.getDate();
        return postRequestDTO.getDate() != null && (date.isBefore(LocalDate.now()) || date.isEqual(LocalDate.now()))
                && postRequestDTO.getPrice() >= 0;
    }

    public static void checkUserFollowException(User persistedUser, User persistedUnFollowUser) {
        checkUserException(persistedUser);
        checkUserAndSellerException(persistedUnFollowUser);
        if (!persistedUser.follow(persistedUnFollowUser.getId())){
            throw new UserFollowingException("This user is already following the user you want to follow");
        } else if(Objects.equals(persistedUser.getId(), persistedUnFollowUser.getId())){
            throw new UserFollowingException( "The user can't follow itself");
        }
    }

    public static void checkUserUnfollowException(User persistedUser, User persistedUnFollowUser) {
        checkUserException(persistedUser);
        checkUserAndSellerException(persistedUnFollowUser);

        if(!persistedUser.getFollowing().contains(persistedUnFollowUser.getId())){
            throw new UserFollowingException( "This user is not following the user you want to unfollow");
        }
    }

    public static void checkOrderExistsException(String order){
        if (!Constants.isOrderConstant(order)){
            throw new OrderNotFoundException("The order type does not exist");
        }
    }
}
