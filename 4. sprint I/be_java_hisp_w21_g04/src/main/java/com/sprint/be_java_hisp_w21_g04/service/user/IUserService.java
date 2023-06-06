package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowedResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;

public interface IUserService {


    FollowersResponseDto getFollowersById(int user_id);
    FollowersResponseDto getFollowersByIdSorted(int user_id, String order);
    FollowedResponseDto getFollowedById(int user_id);

}
