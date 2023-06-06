package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowerDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersListDTO;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotSellerException;
import com.example.be_java_hisp_w21_g02.exceptions.UserFollowingException;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public FollowersCountDTO getFollowersCount(int userId){

        User persistedUser = _usersRepository.getUser(userId);

        if(persistedUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }
        if (!persistedUser.isSeller()) {
            throw new UserNotSellerException("El usuario a seguir no es un vendedor");
        }

        FollowersCountDTO response = new FollowersCountDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                persistedUser.getFollowers().size()
        );

        return response;
    }

    public FollowersListDTO getFollowersList(int userId){
        User persistedUser = _usersRepository.getUser(userId);

        if(persistedUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }

        if (!persistedUser.isSeller()) {
            throw new UserNotSellerException("El usuario no es un vendedor");
        }

        List<User> followers = _usersRepository.getUsers(persistedUser.getFollowers());
        List<FollowerDTO> followersDTO = new ArrayList<>();
        followers.forEach(follower -> followersDTO.add(new FollowerDTO(follower.getId(),follower.getUsername())));

        return new FollowersListDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                followersDTO
        );
    }

    public FollowedListDTO getFollowedList(int userId){
        User persistedUser = _usersRepository.getUser(userId);

        if(persistedUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }
        List<User> followed =  _usersRepository.getUsers(persistedUser.getFollowing());
        List<FollowerDTO> followedDTO = new ArrayList<>();
        followed.forEach(following -> followedDTO.add(new FollowerDTO(following.getId(),following.getUsername())));

        return new FollowedListDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                followedDTO
        );

    }

}
