package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowerDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersListDTO;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import com.example.be_java_hisp_w21_g02.utils.ExceptionChecker;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

@Service
public class UsersServiceImpl implements IUsersService{

    private final IUserRepository _usersRepository;

    public UsersServiceImpl(IUserRepository _usersRepository) {
        this._usersRepository = _usersRepository;
    }

    public void followUser(int userId, int userIdToFollow){
        User persistedUser = _usersRepository.getUser(userId);
        User persistedFollowUser = _usersRepository.getUser(userIdToFollow);

        ExceptionChecker.checkUserFollowingException(persistedUser, persistedFollowUser, "This user is already following the user you want to follow");

        persistedFollowUser.beFollowed(userId);
        _usersRepository.persistFollows(persistedUser, persistedFollowUser);
    }

    public void unFollowUser(int userId, int userIdToUnFollow){
        User persistedUser = _usersRepository.getUser(userId);
        User persistedUnFollowUser = _usersRepository.getUser(userIdToUnFollow);

        ExceptionChecker.checkUserFollowingException(persistedUser, persistedUnFollowUser, "This user is not following the user you want to unfollow");

        persistedUser.unFollow(userIdToUnFollow);
        persistedUnFollowUser.unBeFollowed(userId);
        _usersRepository.persistFollows(persistedUser, persistedUnFollowUser);
    }

    public FollowersCountDTO getFollowersCount(int userId){

        User persistedUser = _usersRepository.getUser(userId);

        ExceptionChecker.checkUserAndSellerException(persistedUser);
        
        return new FollowersCountDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                persistedUser.getFollowers().size()
        );
    }

    public FollowersListDTO getFollowersList(int userId){
        User persistedUser = _usersRepository.getUser(userId);
        ExceptionChecker.checkUserAndSellerException(persistedUser);

        return new FollowersListDTO(
                persistedUser.getId(),
                persistedUser.getUsername(),
                getFollowDTO(persistedUser.getFollowers())
        );
    }

    public FollowersListDTO getFollowersList(int userId, String order){
        User persistedUser = _usersRepository.getUser(userId);
        ExceptionChecker.checkUserAndSellerException(persistedUser);

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
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
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
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
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
