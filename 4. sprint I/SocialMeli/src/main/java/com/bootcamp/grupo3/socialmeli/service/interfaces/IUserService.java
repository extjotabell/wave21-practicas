package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;

public interface IUserService {
    MessageDTO follow(int userId, int userIdToFollow);
    MessageDTO unfollow(int userId, int userIdToFollow);
}
