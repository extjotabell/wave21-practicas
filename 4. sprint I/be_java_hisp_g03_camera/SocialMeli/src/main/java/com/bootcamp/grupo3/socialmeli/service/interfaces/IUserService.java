package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.response.*;

import java.util.List;

public interface IUserService {
    MessageDTO follow(int userId, int userIdToFollow);
    MessageDTO unfollow(int userId, int userIdToFollow);
    UserFollowedListDTO getFollowed(int userId, String order);
    UserFollowersListDTO getFollowers(int userId, String order);
    UserFollowerCountDTO getUserFollowersCount(int id);
    boolean userExists(int id);
    UserDTO getUser(int id);
    List<Integer> getFollowedByUser(int id);
}
