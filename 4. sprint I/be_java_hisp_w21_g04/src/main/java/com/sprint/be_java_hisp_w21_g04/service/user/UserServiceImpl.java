package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.UserAlreadyFollowedException;
import com.sprint.be_java_hisp_w21_g04.exception.UserFollowNotAllowedException;
import com.sprint.be_java_hisp_w21_g04.exception.UserNotFollowedException;
import com.sprint.be_java_hisp_w21_g04.exception.UserNotFoundException;
import com.sprint.be_java_hisp_w21_g04.repository.user.UserRepositoryImpl;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService {
    private final UserRepositoryImpl userRepository;
    private ModelMapper _mapper;

    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this.userRepository = userRepository;
        this._mapper = new ModelMapper();
    }

    @Override
    public FollowersResponseDto getFollowersById(int userId) {

        List<UserResponseDto> followers = userRepository.getFollowersById(userId).stream().map(follower -> _mapper.map(userRepository.getById(follower), UserResponseDto.class)).collect(Collectors.toList());

        return new FollowersResponseDto(userId, userRepository.getById(userId).getUserName(), followers);
    }

    // US-0001
    @Override
    public UserFollowResponseDto followUser(int userId, int userIdToFollow) {
        // Entidad
        User user = userRepository.findUserById(userId);
        User userToFollow = userRepository.findUserById(userIdToFollow);

        if (user == null || userToFollow == null){
            throw new UserNotFoundException("Usuario no encontrado");
        }

        // Validar que el usuario no exista en la lista
        if (user.getFollowed().contains(userToFollow.getUserId()) || userToFollow.getFollowers().contains(user.getUserId())){
            throw new UserAlreadyFollowedException("Ya se están siguiendo.");
        }

        // Validar que el usuario a seguir sea distinto al usuario actual
        if (user.getUserId() == userToFollow.getUserId()){
            throw new UserFollowNotAllowedException("No puedes seguirte a ti mismo.");
        }

        // Agregar a la lista de seguidos
        user.getFollowed().add(userToFollow.getUserId());

        // Agregar a la lista de seguidores
        userToFollow.getFollowers().add(user.getUserId());

        System.out.println("userId: " + userId + " userIdToFollow: " + userIdToFollow + " : " + user.getFollowed());

        // Transformar a dto
        UserFollowResponseDto userFollowResponseDto = new UserFollowResponseDto();
        userFollowResponseDto.setMessage("Has seguido a " + userToFollow.getUserName());
        userFollowResponseDto.setStatusCode(200);
        return userFollowResponseDto;
    }

    // US-0002
    @Override
    public UserFollowersCountDto getFollowersCount(int userId) {
        // Entidad
        User user = userRepository.findUserById(userId);
        if (user == null){
            throw new UserNotFoundException("Usuario no encontrado");
        }
        // Transformar a dto
        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUserId(user.getUserId());
        userFollowersCountDto.setUserName(user.getUserName());
        userFollowersCountDto.setFollowersCount(user.getFollowers().size());
        return userFollowersCountDto;
    }

    // US-0007
    @Override
    public UserUnfollowResponseDto unfollowUser(int userId, int userIdToUnfollow) {
        // Entidad
        User user = userRepository.findUserById(userId);
        User userToUnfollow = userRepository.findUserById(userIdToUnfollow);
        if (user == null || userToUnfollow == null){
            throw new UserNotFoundException("Usuario no encontrado");
        }

        // Validar que el usuario exista en la lista
        if (!user.getFollowed().contains(userToUnfollow.getUserId()) || !userToUnfollow.getFollowers().contains(user.getUserId())){
            throw new UserNotFollowedException("No se están siguiendo.");
        }

        // Eliminar de la lista de seguidos
        // Sacar el indice de la lista de seguidos a través del user id
        int userIndex = user.getFollowed().indexOf(userToUnfollow.getUserId());
        user.getFollowed().remove(userIndex);


        // Eliminar de la lista de seguidores
        int userToUnfollowIndex = userToUnfollow.getFollowers().indexOf(user.getUserId());
        userToUnfollow.getFollowers().remove(userToUnfollowIndex);

        // Transformar a dto
        UserUnfollowResponseDto userUnfollowResponseDto = new UserUnfollowResponseDto();
        userUnfollowResponseDto.setMessage("Has dejado de seguir a " + userToUnfollow.getUserName());
        userUnfollowResponseDto.setStatusCode(200);
        return userUnfollowResponseDto;
    }
}
