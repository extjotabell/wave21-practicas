package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.LoginDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.*;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.order.UserOrder;
import com.bootcamp.grupo3.socialmeli.order.UserOrderType;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    private User getUserByID(final int userId) {
      Optional<User> user = userRepository.getUserByID(userId);
      return user.orElseThrow(() -> new UserNotFoundException("No se ha encontrado el usuario"));
    }

    public User getUserByToken(final String token) throws UserPermissionException {
      Optional<User> user = userRepository.getUserByToken(token);
      return user.orElseThrow(() -> new UserPermissionException("No se ha encontrado el usuario"));
    }

    @Override
    public UserIdDTO createUser(final UserPasswordDTO u) {
      // TODO: Hash password :p
      User user = new User();
      user.setName(u.name());
      user.setPassword(u.password());

      int id = userRepository.createUser(user);

      return new UserIdDTO(id);
    }

    @Override
    public TokenDTO validateUser(LoginDTO login) {
      if(!this.userExists(login.userId()))
        throw new UserNotFoundException("No se encontro el usuario que desea loguear");

      String token = userRepository.generateToken(login.userId(), login.password());
      return new TokenDTO(token);
    }

    @Override
    public MessageDTO follow(final String token, final int userIdToFollow) throws UserPermissionException {
        User user = this.getUserByToken(token);

        User userToFollow = this.getUserByID(userIdToFollow);

        user.getFollowed().add(userToFollow);
        userToFollow.getFollowers().add(user);

        return new MessageDTO(
          String.format(
            "%s followed %s successfully!",
            user.getName(),
            userToFollow.getName()
          )
        );
    }

    @Override
    public MessageDTO unfollow(final String token, final int userIdToUnfollow) throws UserPermissionException {

        User user = this.getUserByToken(token);
        User userToUnfollow = this.getUserByID(userIdToUnfollow);

        user.getFollowed().remove(userToUnfollow);
        userToUnfollow.getFollowers().remove(user);

        return new MessageDTO(
          String.format(
            "%s unfollowed %s successfully!",
            user.getName(),
            userToUnfollow.getName()
          )
        );
    }

    public UserFollowedListDTO getFollowed(final String token, final String order) throws UserPermissionException {
        UserFollowedListDTO user = modelMapper.map(
          this.getUserByToken(token),
          UserFollowedListDTO.class
        );

        if(ASCEND_ORDER.equals(order))
          user.getFollowed().sort(Comparator.naturalOrder());
        else if(DESCEND_ORDER.equals(order))
          user.getFollowed().sort(Comparator.reverseOrder());

        return user;
    }

    @Override
    public UserFollowersListDTO getFollowers(final String token, final UserOrderType order) throws UserPermissionException {
        UserFollowersListDTO user = modelMapper.map(
          this.getUserByToken(token),
          UserFollowersListDTO.class
        );

        UserOrder userOrderable = new UserOrder();
        Comparator<UserDTO> c = userOrderable.getComparator(order);
        user.getFollowers().sort(c);

        return user;
    }

    private boolean userExists(final int userId) {
        return userRepository.userExists(userId);
    }

    @Override
    public boolean userExists(final String token) throws UserPermissionException {
      return userRepository.userExists(
        this.getUserByToken(token).getId()
      );
    }

    @Override
    public List<Integer> getFollowedByUser(final String token) throws UserPermissionException {
        return this.getUserByToken(token)
                .getFollowed()
                .stream()
                .map(User::getId)
                .collect(Collectors.toList());

    }

    @Override
    public UserFollowerCountDTO getUserFollowersCount(final String token) throws UserPermissionException {
        User user = this.getUserByToken(token);

        UserFollowerCountDTO userFollowerCountDTO = modelMapper.map(user,UserFollowerCountDTO.class);
        userFollowerCountDTO.setFollowersCount(user.getFollowers().size());

        return userFollowerCountDTO;
    }
}
