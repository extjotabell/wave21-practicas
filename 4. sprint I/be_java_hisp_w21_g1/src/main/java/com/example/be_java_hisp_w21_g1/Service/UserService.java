package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowUserDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowedListDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowerListDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.Exception.NotFoundException;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public FollowersCountDTO getFollowersCount(int idUser) {

        Optional<User> foundUser = userRepository.findUserById(idUser);
        if (foundUser.isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        int followersCount = user.followersCount();
        return new FollowersCountDTO(idUser, user.getUser_name(),followersCount);
      
    }

    @Override
    public FollowerListDTO getFollowersList(int idUser) {
        Optional<User> foundUser = userRepository.findUserById(idUser);

        if (foundUser.isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        List<FollowUserDTO> followedList = user.getFollowers().stream()
                .map(u -> new FollowUserDTO(u.getUser_id(), u.getUser_name()))
                .toList();
        return new FollowerListDTO(idUser, user.getUser_name(),followedList);
    }

    @Override
    public FollowedListDTO getFollowedList(int idUser) {
        Optional<User> foundUser = userRepository.findUserById(idUser);

        if (foundUser.isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        List<FollowUserDTO> followedList = user.getFollowed().stream()
                .map(u -> new FollowUserDTO(u.getUser_id(), u.getUser_name()))
                .toList();
        return new FollowedListDTO(idUser, user.getUser_name(),followedList);
    }

}
