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
import com.example.be_java_hisp_w21_g02.utils.Constants;
import com.example.be_java_hisp_w21_g02.utils.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements IUsersService{

    @Autowired
    private IUserRepository _usersRepository;

    public void followUser(int userId, int userIdToFollow){
        User persistedUser = _usersRepository.getUser(userId);
        User persistedFollowUser = _usersRepository.getUser(userIdToFollow);

        checkFollowAndSellerException(persistedUser, persistedFollowUser);

        if (!persistedUser.follow(userIdToFollow)){
            throw new UserFollowingException("El usuario ya seguia al usuario indicado");
        }

        persistedFollowUser.beFollowed(userId);
        _usersRepository.persistFollows(persistedUser, persistedFollowUser);
    }

    public void unFollowUser(int userId, int userIdToUnFollow){
        User persistedUnUser = _usersRepository.getUser(userId);
        User persistedUnFollowUser = _usersRepository.getUser(userIdToUnFollow); //flav

        checkFollowAndSellerException(persistedUnUser, persistedUnFollowUser);

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

        Validations.checkUserAndSellerException(persistedUser);
        
        return new FollowersCountDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                persistedUser.getFollowers().size()
        );
    }

    public FollowersListDTO getFollowersList(int userId){
        User persistedUser = _usersRepository.getUser(userId);
        Validations.checkUserAndSellerException(persistedUser);

        return new FollowersListDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                getFollowDTO(persistedUser.getFollowers())
        );
    }

    public FollowersListDTO getFollowersList(int userId, String order){
        User persistedUser = _usersRepository.getUser(userId);
        Validations.checkUserAndSellerException(persistedUser);

        List<FollowerDTO> followersDTO = getFollowDTO(persistedUser.getFollowers());

        orderCollectionByOrderParam(followersDTO, order);

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

        return new FollowedListDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                getFollowDTO(persistedUser.getFollowing())
        );
    }

    public FollowedListDTO getFollowedList(int userId, String order){
        User persistedUser = _usersRepository.getUser(userId);

        if(persistedUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }

        List<FollowerDTO> followedDTO = getFollowDTO(persistedUser.getFollowing());

        orderCollectionByOrderParam(followedDTO, order);

        return new FollowedListDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                followedDTO
        );
    }

    //region Extra Methods
    private static void checkFollowAndSellerException(User persistedUser, User persistedOtherUser) {
        
        if(persistedUser == null || persistedOtherUser == null){
            throw new UserNotFoundException("No se pudo encontrar un usuario con el ID mencionado");
        }

        if (!persistedOtherUser.isSeller()){
            throw new UserNotSellerException("El usuario no es un vendedor");
        }
    }

    private List<FollowerDTO> getFollowDTO(Set<Integer> usersIds){
        List<User> followers = _usersRepository.getUsers(usersIds);
        List<FollowerDTO> followersDTO = new ArrayList<>();
        followers.forEach(follower -> followersDTO.add(new FollowerDTO(follower.getId(),follower.getUsername())));

        return  followersDTO;
    }

    private void orderCollectionByOrderParam(List<FollowerDTO> collection, String order) {
        if (order.equalsIgnoreCase(Constants.ORDER_NAME_ASC)) {
            collection.sort(Comparator.comparing(FollowerDTO::getUserName));
        } else if (order.equalsIgnoreCase(Constants.ORDER_NAME_DESC)) {
            collection.sort(Comparator.comparing(FollowerDTO::getUserName).reversed());
        }
    }
    //endregion
}
