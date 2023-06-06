package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import org.springframework.http.ResponseEntity;

public interface IUsersService {
    void followUser(int userId, int userIdToFollow);

    void unFollowUser(int userId, int userIdToUnFollow);

    FollowersCountDTO getFollowersCount(int userId);
}
