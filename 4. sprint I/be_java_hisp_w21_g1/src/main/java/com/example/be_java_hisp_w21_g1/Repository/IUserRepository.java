package com.example.be_java_hisp_w21_g1.Repository;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowedListDTO;
import com.example.be_java_hisp_w21_g1.Model.User;

public interface IUserRepository {
    public User findUserById(int id);
}
