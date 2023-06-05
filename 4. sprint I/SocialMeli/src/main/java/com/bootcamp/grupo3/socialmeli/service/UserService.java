package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.User;
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

    @Override
    public String follow(int userId, int userIdToFollow) {
        User user = userRepository.findByID(userId)
                .orElseThrow(() -> new UserNotFoundException("No se ha encontrado el usuario"));
        User userToFollow= userRepository.findByID(userIdToFollow)
                .orElseThrow(() -> new UserNotFoundException("No se ha encontrado el usuario"));

        user.getFollowed().add(userToFollow);

        return user.getName()+ " followed "+userToFollow.getName()+ " successfully!";
    }

    @Override
    public String unfollow(int userId, int userIdToUnfollow) {
        User user = userRepository.findByID(userId)
                .orElseThrow(() -> new UserNotFoundException("No se ha encontrado el usuario"));
        User userToUnfollow= userRepository.findByID(userIdToUnfollow)
                .orElseThrow(() -> new UserNotFoundException("No se ha encontrado el usuario"));

        user.getFollowed().remove(userToUnfollow);

        return user.getName()+ " unfollowed "+userToUnfollow.getName()+ " successfully!";
    }
}
