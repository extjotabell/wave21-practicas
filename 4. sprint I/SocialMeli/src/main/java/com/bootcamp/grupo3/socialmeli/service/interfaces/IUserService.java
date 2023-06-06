package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;

public interface IUserService {
    boolean userExists(int id);
    UserFollowerCountDTO getUserFollowersCount(int id);
}
