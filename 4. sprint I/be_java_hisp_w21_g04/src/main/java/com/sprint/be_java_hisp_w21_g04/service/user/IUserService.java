package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.UserFollowResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserFollowersCountDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserUnfollowResponseDto;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;

import java.util.List;

public interface IUserService {
    UserFollowResponseDto followUser(int userId, int userIdToFollow);
    UserFollowersCountDto getFollowersCount(int userId);
    UserUnfollowResponseDto unfollowUser(int userId, int userIdToFollow);


    public FollowersResponseDto getFollowersById(int user_id);

}
