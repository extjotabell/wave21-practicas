package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowersListDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserAlreadyFollowedException;
import com.bootcamp.grupo3.socialmeli.exception.UserEqualsException;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    private static final String ASCEND_ORDER = "name_asc";
    private static final String DESCEND_ORDER = "name_desc";
    private IUserRepository userRepository;
    private ModelMapper modelMapper;

    public UserService(IUserRepository userRepository, ModelMapper modelMapper){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public MessageDTO follow(int userId, int userIdToFollow) {
        if(userId==userIdToFollow)
            throw new UserEqualsException("No te puedes seguir a tí mismo!");

        User user = this.getUserByID(userId);
        User userToFollow = this.getUserByID(userIdToFollow);

        if(user.getFollowed().contains(userToFollow))
            throw new UserAlreadyFollowedException("El usuario " + userToFollow.getName() + " ya es encuentra en tu lista de seguidos!");

        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);

        return new MessageDTO(user.getName() + " siguio a " + userToFollow.getName() + " correctamente!");
    }

    @Override
    public MessageDTO unfollow(int userId, int userIdToUnfollow) {
        if(userId==userIdToUnfollow)
            throw new UserEqualsException("No te puedes dejar de seguir a tí mismo!");

        User user = this.getUserByID(userId);
        User userToUnfollow = this.getUserByID(userIdToUnfollow);

        if(!user.getFollowed().contains(userToUnfollow))
            throw new UserNotFoundException("El usuario " + userToUnfollow.getName() + " no se encuentra en tu lista de seguidos.");

        user.getFollowed().remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(user);

        return new MessageDTO(user.getName() + " dejo de seguir a " + userToUnfollow.getName() + " correctamente!");
    }

    public UserFollowedListDTO getFollowed(int userId, String order){
        UserFollowedListDTO user = modelMapper.map(this.getUserByID(userId), UserFollowedListDTO.class);

        if(ASCEND_ORDER.equals(order)) user.getFollowed().sort(Comparator.naturalOrder());
        else if(DESCEND_ORDER.equals(order)) user.getFollowed().sort(Comparator.reverseOrder());

        return user;
    }

    @Override
    public UserFollowersListDTO getFollowers(int userId, String order) {
        UserFollowersListDTO user = modelMapper.map(this.getUserByID(userId), UserFollowersListDTO.class);

        if(ASCEND_ORDER.equals(order)) user.getFollowers().sort(Comparator.naturalOrder());
        else if(DESCEND_ORDER.equals(order)) user.getFollowers().sort(Comparator.reverseOrder());

        return user;
    }

    @Override
    public User getUserByID(int userId) {
        Optional<User> user = userRepository.getUserByID(userId);
        return user.orElseThrow(() -> new UserNotFoundException("No se ha encontrado el usuario"));
    }

    @Override
    public boolean userExists(int id) {
        return userRepository.userExists(id);
    }

    @Override
    public List<Integer> getFollowedByUser(int id) {
        return this.getUserByID(id).getFollowed()
                .stream()
                .map(User::getId)
                .collect(Collectors.toList());
    }

    @Override
    public UserFollowerCountDTO getUserFollowersCount(int id) {
        User user = this.getUserByID(id);
        UserFollowerCountDTO userFollowerCountDTO = modelMapper.map(user,UserFollowerCountDTO.class);
        userFollowerCountDTO.setFollowersCount(user.getFollowers().size());
        return userFollowerCountDTO;
    }
}
