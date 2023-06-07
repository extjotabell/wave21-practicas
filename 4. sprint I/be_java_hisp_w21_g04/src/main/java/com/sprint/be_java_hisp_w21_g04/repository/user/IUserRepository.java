package com.sprint.be_java_hisp_w21_g04.repository.user;

import com.sprint.be_java_hisp_w21_g04.entity.User;

import java.util.List;

import com.sprint.be_java_hisp_w21_g04.entity.User;

public interface IUserRepository {
    User findUserById(int userId);

    List<Integer> getFollowersById(int user_id);
    List<Integer> getFollowedById(int user_id);
    User getById(int user_id);
    List<User> getAll();

}
