package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.RespUserDTO;
import com.example.RelacionesJpaW21.dto.UserDTO;

import java.util.List;

public interface IUserService {
    List<UserDTO> findAll();
    RespUserDTO insertUser(UserDTO userDto);
    void deleteUser(Long id);
    UserDTO findById(Long id);
}
