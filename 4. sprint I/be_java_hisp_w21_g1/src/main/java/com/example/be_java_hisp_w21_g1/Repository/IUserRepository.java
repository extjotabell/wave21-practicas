package com.example.be_java_hisp_w21_g1.Repository;

import com.example.be_java_hisp_w21_g1.Model.User;

import java.util.Optional;

public interface IUserRepository {
    public Optional<User> findUserById(int id);
}
