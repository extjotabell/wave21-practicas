package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.Exception.NotFoundException;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public FollowersCountDTO getFollowersCount(int idUser) {

        Optional<User> foundUser = userRepository.findUserById(idUser);

        if(foundUser.isEmpty()){
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        int followersCount = user.followersCount();
        return new FollowersCountDTO(idUser, user.getUser_name(),followersCount);
      
    }

}
