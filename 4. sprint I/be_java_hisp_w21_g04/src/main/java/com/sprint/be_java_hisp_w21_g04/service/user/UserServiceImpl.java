package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.UserFollowResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserFollowersCountDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserUnfollowResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.User;
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

    @Override
    public UserFollowResponseDto followUser(int userId, int userIdToFollow) {
        // Entidad
        User user = userRepository.findUserById(userId);
        User userToFollow = userRepository.findUserById(userIdToFollow);
        // Transformar a dto
        UserFollowResponseDto userFollowResponseDto = new UserFollowResponseDto();
        userFollowResponseDto.setMessage("Has seguido a " + userToFollow.getUserName());
        userFollowResponseDto.setStatusCode(200);
        return userFollowResponseDto;
    }

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

    @Override
    public UserUnfollowResponseDto unfollowUser(int userId, int userIdToUnfollow) {
        // Entidad
        User user = userRepository.findUserById(userId);
        User userToUnfollow = userRepository.findUserById(userIdToUnfollow);
        // Transformar a dto
        UserUnfollowResponseDto userUnfollowResponseDto = new UserUnfollowResponseDto();
        userUnfollowResponseDto.setMessage("Has dejado de seguir a " + userToUnfollow.getUserName());
        userUnfollowResponseDto.setStatusCode(200);
        return userUnfollowResponseDto;
    }
}
