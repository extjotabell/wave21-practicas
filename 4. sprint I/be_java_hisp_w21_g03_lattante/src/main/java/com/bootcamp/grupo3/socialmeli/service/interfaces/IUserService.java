package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowersListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;

import java.util.List;

public interface IUserService {
    MessageDTO follow(int userId, int userIdToFollow);
    MessageDTO unfollow(int userId, int userIdToFollow);
    UserFollowedListDTO getFollowed(int userId, String order);
    UserFollowersListDTO getFollowers(int userId, String order);
    UserFollowerCountDTO getUserFollowersCount(int id);
    boolean userExists(int id);
    List<Integer> getFollowedByUser(int id);

    String getUserName(int userId);
}
