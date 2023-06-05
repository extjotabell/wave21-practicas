package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotSellerException;
import com.example.be_java_hisp_w21_g02.exceptions.UserFollowingException;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements IUsersService{

    @Autowired
    private IUserRepository _usersRepository;

    public void followUser(int userId, int userIdToFollow){
        User persistedUser = _usersRepository.getUser(userId);
        User persistedFollowUser = _usersRepository.getUser(userIdToFollow);

        if(persistedUser == null || persistedFollowUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }
        if (!persistedFollowUser.isSeller()) {
            throw new UserNotSellerException("El usuario a seguir no es un vendedor");
        }
        if (!persistedUser.follow(userIdToFollow)){
            throw new UserFollowingException("El usuario ya seguia al usuario indicado");
        }

        persistedFollowUser.beFollowed(userId);
        _usersRepository.persistFollows(persistedUser, persistedFollowUser);
    }

    public void unFollowUser(int userId, int userIdToUnFollow){
        User persistedUnUser = _usersRepository.getUser(userId);
        User persistedUnFollowUser = _usersRepository.getUser(userIdToUnFollow); //flav

        if(persistedUnUser == null || persistedUnFollowUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }

        if (!persistedUnFollowUser.isSeller()){
            throw new UserNotSellerException("El usuario que quiere dejar de seguir no es un vendedor");
        }

        if(persistedUnUser.verifyFollower(userIdToUnFollow)){
            persistedUnUser.unFollow(userIdToUnFollow);
            persistedUnFollowUser.unBeFollowed(userId);
            _usersRepository.persistFollows(persistedUnUser, persistedUnFollowUser);
        }
        else{
            throw new UserFollowingException("El id de usuario ingresado no es un seguidor del usuario que quiere dejar de seguir");
        }



    }

}
