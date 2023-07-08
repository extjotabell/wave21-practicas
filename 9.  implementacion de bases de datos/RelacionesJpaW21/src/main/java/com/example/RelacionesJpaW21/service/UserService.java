package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.*;
import com.example.RelacionesJpaW21.entity.OneToMany.Cart;
import com.example.RelacionesJpaW21.entity.OneToOne.User;
import com.example.RelacionesJpaW21.exception.UserNotFoundException;
import com.example.RelacionesJpaW21.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    IUserRepository userRepository;

    ModelMapper modelMapper;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();

        List<UserDTO> usersDtos = new ArrayList<>();

        users.stream().forEach( c -> usersDtos.add(modelMapper.map(c,UserDTO.class)));

        return usersDtos;
    }

    @Override
    public RespUserDTO insertUser(final UserDTO userDto) {

        User user = modelMapper.map(userDto, User.class);

        user.getAddress().setUser(user);

        User savedUser = this.userRepository.save(user);

        RespUserDTO response = new RespUserDTO();
        response.setUser(modelMapper.map(savedUser, UserDTO.class));
        response.setMessage("Guardado con éxito...");
        return response;

    }

    @Override
    public void deleteUser(final Long id) {
        if(!this.userRepository.existsById(id))
            throw new UserNotFoundException("No se encontro el usuario");
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDTO findById(Long id) {
        User user = this.userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("No se encontro el usuario"));

        return modelMapper.map(user, UserDTO.class);
    }
}
