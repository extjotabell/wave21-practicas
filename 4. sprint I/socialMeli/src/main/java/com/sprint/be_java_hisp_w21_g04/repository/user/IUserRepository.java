package com.sprint.be_java_hisp_w21_g04.repository.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.ResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.User;

import java.util.List;

import com.sprint.be_java_hisp_w21_g04.entity.User;

public interface IUserRepository {
    User findUserById(int userId);

    List<Integer> getFollowersById(int userId);
    List<Integer> getFollowedById(int userId);
    User getById(int userId);
    List<User> getAll();

    String getUsernameById(int userId);

    String removeUser(int userId);

}
