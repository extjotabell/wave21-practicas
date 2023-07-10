package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.entity.OneToOne.User;
import java.util.List;

public interface IUserService {
    List<User> findAll();
    User insertUser(User user);
    void deleteUser(Long id);
    User findById(Long id);
}
