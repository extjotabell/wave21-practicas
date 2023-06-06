package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowUserDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowedListDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.Exception.NotFoundException;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    @Override
    public FollowersCountDTO getFollowersCount(int idUser) {

        User foundUser = userRepository.findUserById(idUser);
        //inicializado en -1 para marcar un numero cuando no existe el usuario
        int followersCount = -1;
        if(foundUser != null){
            followersCount = foundUser.followersCount();
            return new FollowersCountDTO(idUser, foundUser.getUser_name(),followersCount);
        }
        else {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

      
    }
    @Override
    public FollowedListDTO getFollowersList(int idUser){
        User foundUser = userRepository.findUserById(idUser);

        if(foundUser != null){
            List<FollowUserDTO> followedList = foundUser.getFollowers().stream()
                    .map(u -> new FollowUserDTO(u.getUser_id(), u.getUser_name()))
                    .toList();
            return new FollowedListDTO(idUser, foundUser.getUser_name(),followedList);
        }
        else {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

    }


}
