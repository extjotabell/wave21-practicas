package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.UserDto;

import java.util.List;

public interface IUserService {
    List<UserDto> findAll();
    UserDto insertUser(UserDto UserDto);
    UserDto deleteUser(Long id);
    UserDto findById(Long id);
}
