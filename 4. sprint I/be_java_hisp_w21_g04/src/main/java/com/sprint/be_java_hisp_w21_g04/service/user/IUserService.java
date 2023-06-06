package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowedResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;

import java.util.List;

public interface IUserService {
    ResponseDto followUser(int userId, int userIdToFollow);
    UserFollowersCountDto getFollowersCount(int userId);
    ResponseDto unfollowUser(int userId, int userIdToFollow);

    FollowersResponseDto getFollowersById(int user_id);
    FollowersResponseDto getFollowersByIdSorted(int user_id, String order);
    FollowedResponseDto getFollowedById(int user_id);

}
