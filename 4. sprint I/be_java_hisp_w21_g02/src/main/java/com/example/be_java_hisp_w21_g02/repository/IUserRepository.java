package com.example.be_java_hisp_w21_g02.repository;

import com.example.be_java_hisp_w21_g02.model.User;

import com.example.be_java_hisp_w21_g02.model.Post;

public interface IUserRepository {
    User getUser(int userIdToFollow);

    void persistFollows(User persistedUser, User persistedFollowUser);

    void createPost(Post post);

}