package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;

public interface IUserService {
    public FollowersCountDTO getFollowersCount(int idUser);
}
