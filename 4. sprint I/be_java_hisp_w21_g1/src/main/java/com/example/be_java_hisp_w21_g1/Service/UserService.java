package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1.Exception.BadRequestException;
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

    public boolean follow(FollowPostDTO followPostDTO){
        Optional<User> user = userRepository.findUserById(followPostDTO.getUserId());
        Optional<User> seller = userRepository.findUserById(followPostDTO.getUserIdToFollow());

        //validar que no esten null
        if(user.isEmpty() || seller.isEmpty()) return false;

        //validar que sea vendedor el seller
        if(!seller.get().isSeller()) return false;

        //validar que no exista la relacion
        if (user.get().getFollowed().stream().anyMatch(followed -> followed.getUser_id() == seller.get().getUser_id())) return false;

        userRepository.relateUserAndSeller(user.get(),seller.get());
        return true;
    }

    public boolean unFollow(FollowPostDTO followPostDTO){
        Optional<User> user = userRepository.findUserById(followPostDTO.getUserId());
        Optional<User> seller = userRepository.findUserById(followPostDTO.getUserIdToFollow());

        //validar que no esten null
        if(user.isEmpty() || seller.isEmpty()) return false;

        //validar que exista la relacion
        if (!user.get().getFollowed().stream().anyMatch(followed -> followed.getUser_id() == seller.get().getUser_id())) return false;

        userRepository.unRelateUserAndSeller(user.get(), seller.get());
        return true;
    }
}
