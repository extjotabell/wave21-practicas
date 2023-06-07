package com.example.be_java_hisp_w21_g1_dominguez.Repository;

import com.example.be_java_hisp_w21_g1_dominguez.Model.Post;
import com.example.be_java_hisp_w21_g1_dominguez.Model.User;

import java.util.Optional;

public interface IUserRepository {
    public Optional<User> findUserById(int id);

    void unRelateUserAndSeller(User user, User user1);

    void addPostToUser(Post post, User user);
}
