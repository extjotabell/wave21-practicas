package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(IUserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }
}
