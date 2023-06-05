package com.example.be_java_hisp_w21_g02.repository;

import com.example.be_java_hisp_w21_g02.model.User;

public interface IUserRepository {
    User getUser(int userIdToFollow);
}
