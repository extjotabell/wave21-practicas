package com.example.RelacionesJpaW21.service;

import com.example.RelacionesJpaW21.dto.UserDto;
import com.example.RelacionesJpaW21.entity.OneToOne.User;
import com.example.RelacionesJpaW21.repository.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{


    IUserRepository userRepo;

    public UserServiceImpl(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public List<UserDto> findAll() {
        return null;
    }

    @Override
    public UserDto insertUser(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        User user = mapper.map(userDto , User.class);
        UserDto response = mapper.map(userRepo.save(user),UserDto.class);

        return response;
    }

    @Override
    public UserDto deleteUser(Long id) {
        return null;
    }

    @Override
    public UserDto findById(Long id) {
        return null;
    }
}
