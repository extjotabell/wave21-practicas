package com.bootcamp.grupo3.socialmeli.service.interfaces;

public interface IUserService {
    String follow(int userId, int userIdToFollow);
    String unfollow(int userId, int userIdToFollow);
}
