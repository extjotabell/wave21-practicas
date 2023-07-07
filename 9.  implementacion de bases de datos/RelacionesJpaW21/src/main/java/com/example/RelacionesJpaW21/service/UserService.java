package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.AddressDTO;
import com.example.RelacionesJpaW21.dto.ListUserDTO;
import com.example.RelacionesJpaW21.dto.RespUserDTO;
import com.example.RelacionesJpaW21.dto.UserDTO;
import com.example.RelacionesJpaW21.entity.OneToOne.Address;
import com.example.RelacionesJpaW21.entity.OneToOne.User;
import com.example.RelacionesJpaW21.exception.UserNotFoundException;
import com.example.RelacionesJpaW21.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    IUserRepository userRepository;

    ModelMapper modelMapper;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
        this.modelMapper = new ModelMapper();
    }

    @Override
    public ListUserDTO findAll() {
        List<UserDTO> users = this.userRepository.findAll()
                .stream()
                .map(u ->modelMapper.map(u, UserDTO.class))
                .toList();

        return new ListUserDTO(users);
    }

    @Override
    public RespUserDTO insertUser(final UserDTO userDto) {
        User user = this.modelMapper.map(userDto, User.class);

        user.getAddress().setUser(user);

        User savedUser = this.userRepository.save(user);

        UserDTO u = this.modelMapper.map(savedUser, UserDTO.class);
        return new RespUserDTO(u, "Usuario guardado con exito.");
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
