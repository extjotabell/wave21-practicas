package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.LoginDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.*;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.model.User;

import java.util.List;

public interface IUserService {
    MessageDTO follow(String token, int userIdToFollow) throws UserPermissionException;
    MessageDTO unfollow(String token, int userIdToFollow) throws UserPermissionException;
    UserFollowedListDTO getFollowed(String token, String order) throws UserPermissionException;
    UserFollowersListDTO getFollowers(String token, String order) throws UserPermissionException;
    UserFollowerCountDTO getUserFollowersCount(String token) throws UserPermissionException;
    boolean userExists(int id);
    boolean userExists(String token) throws UserPermissionException;
    List<Integer> getFollowedByUser(String token) throws UserPermissionException;
    UserIdDTO createUser(UserPasswordDTO u);
    TokenDTO validateUser(LoginDTO login);
    User getUserByToken(String token) throws UserPermissionException;
}
