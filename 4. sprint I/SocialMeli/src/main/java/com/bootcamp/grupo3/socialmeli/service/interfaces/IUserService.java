package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowersListDTO;

public interface IUserService {
    UserFollowedListDTO getFollowed(int userId, String order);
    UserFollowersListDTO getFollowers(int userId, String order);
}
