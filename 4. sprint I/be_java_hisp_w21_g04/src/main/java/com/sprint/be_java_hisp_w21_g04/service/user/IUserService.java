package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowedResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;

public interface IUserService {


    FollowersResponseDto getFollowersById(int user_id);
    FollowedResponseDto getFollowedById(int user_id);

}
