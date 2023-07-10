package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.UserDto;

import java.util.List;

public interface IUserService {
    // basic crud

    List<UserDto> findAll();
    UserDto insertUser(UserDto userDto);
    UserDto updateUser(UserDto userDto);
    UserDto deleteUser(Long id);
}
