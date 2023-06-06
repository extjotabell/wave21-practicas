package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;

import java.util.List;

public interface IUserService {


    public FollowersResponseDto getFollowersById(int user_id);

}
