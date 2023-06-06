package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private IUserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(IUserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean userExists(int id) {
        return userRepository.userExists(id);
    }

    @Override
    public UserFollowerCountDTO getUserFollowersCount(int id) {
        Optional<User> user = userRepository.getUser(id);
        if (user.isPresent()){
            UserFollowerCountDTO userFollowerCountDTO = modelMapper.map(user.get(),UserFollowerCountDTO.class);
            System.out.println("Followers: " + user.get());
            userFollowerCountDTO.setFollowersCount(user.get().getFollowers().size());
            return userFollowerCountDTO;
        }else {
            throw new RuntimeException("User no se encontro");
        }
    }
}
