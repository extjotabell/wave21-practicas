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
import com.example.be_java_hisp_w21_g02.utils.Mapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UsersServiceImpl implements IUsersService{

    private final IUserRepository _usersRepository;
    private Mapper _mapper;

    public UsersServiceImpl(IUserRepository usersRepository) {
        this._usersRepository = usersRepository;
        this._mapper = new Mapper();
    }

    public void followUser(int userId, int userIdToFollow){
        User persistedUser = _usersRepository.getUser(userId);
        User persistedFollowUser = _usersRepository.getUser(userIdToFollow);

        ExceptionChecker.checkUserFollowException(persistedUser, persistedFollowUser);

        persistedFollowUser.beFollowed(userId);
        _usersRepository.persistFollows(persistedUser, persistedFollowUser);
    }

    public void unFollowUser(int userId, int userIdToUnFollow){
        User persistedUser = _usersRepository.getUser(userId);
        User persistedUnFollowUser = _usersRepository.getUser(userIdToUnFollow);

        ExceptionChecker.checkUserUnfollowException(persistedUser, persistedUnFollowUser);

        persistedUser.unFollow(userIdToUnFollow);
        persistedUnFollowUser.unBeFollowed(userId);
        _usersRepository.persistFollows(persistedUser, persistedUnFollowUser);
    }

    public FollowersCountDTO getFollowersCount(int userId) {

        User persistedUser = _usersRepository.getUser(userId);
        ExceptionChecker.checkUserAndSellerException(persistedUser);

        FollowersCountDTO result = _mapper.mapUserToFollowersCountDTO(persistedUser);
        result.setFollowersCount(persistedUser.getFollowers().size());

        return result;
    }

    public FollowersListDTO getFollowersList(int userId, String order){

        order = order != null ? order : Constants.ORDER_DATE_DESC;
        ExceptionChecker.checkOrderExistsException(order);

        User persistedUser = _usersRepository.getUser(userId);
        ExceptionChecker.checkUserAndSellerException(persistedUser);
        List<FollowerDTO> followersDTO = getFollowDTO(persistedUser.getFollowers());
        orderCollectionByOrderParam(followersDTO, order);
        return _mapper.mapUserToFollowersListDTO(persistedUser, followersDTO);
    }

    public FollowedListDTO getFollowedList(int userId, String order){

        order = order != null ? order : Constants.ORDER_DATE_DESC;
        ExceptionChecker.checkOrderExistsException(order);

        User persistedUser = _usersRepository.getUser(userId);
        if(persistedUser == null){
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
        }
        List<FollowerDTO> followedDTO = getFollowDTO(persistedUser.getFollowing());
        orderCollectionByOrderParam(followedDTO, order);
        return _mapper.mapUserToFollowedListDTO(persistedUser, followedDTO);
    }

    //region Extra Methods

    private List<FollowerDTO> getFollowDTO(Set<Integer> usersIds){
        List<User> users = _usersRepository.getUsers(usersIds);
        return users.stream().map(user -> _mapper.mapUserToFollowerDTO(user)).collect(Collectors.toList());
    }

    /**
     * Orders a list of users by name in ascending or descending order
     * @param collection list of users to be ordered
     * @param order parameter to order the list by name in ascending or descending order
     */
    private void orderCollectionByOrderParam(List<FollowerDTO> collection, String order) {
        if (order.equalsIgnoreCase(Constants.ORDER_NAME_ASC)) {
            collection.sort(Comparator.comparing(FollowerDTO::getUsername));
        } else if (order.equalsIgnoreCase(Constants.ORDER_NAME_DESC)) {
            collection.sort(Comparator.comparing(FollowerDTO::getUsername).reversed());
        }
    }
    //endregion
}
