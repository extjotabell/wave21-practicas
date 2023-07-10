package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.UserDto;
import com.example.RelacionesJpaW21.entity.OneToOne.User;
import com.example.RelacionesJpaW21.repository.IUserRepository;
import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto insertUser(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto, User.class);
        user = userRepository.save(user);
        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto deleteUser(Long id) {
        return null;
    }
}
