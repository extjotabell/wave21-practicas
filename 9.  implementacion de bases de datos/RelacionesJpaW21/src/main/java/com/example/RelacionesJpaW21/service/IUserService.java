package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.ListUserDTO;
import com.example.RelacionesJpaW21.dto.RespUserDTO;
import com.example.RelacionesJpaW21.dto.UserDTO;

public interface IUserService {
    ListUserDTO findAll();
    RespUserDTO insertUser(UserDTO userDto);
    void deleteUser(Long id);
    UserDTO findById(Long id);
}
