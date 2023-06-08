package com.sprint.be_java_hisp_w21_g04.service.user;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.*;
import com.sprint.be_java_hisp_w21_g04.repository.user.IUserRepository;
import com.sprint.be_java_hisp_w21_g04.repository.user.UserRepositoryImpl;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowedResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;
import com.sprint.be_java_hisp_w21_g04.exception.IllegalDataException;
import com.sprint.be_java_hisp_w21_g04.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository _userRepository;


    private ModelMapper _mapper;
    public UserServiceImpl(UserRepositoryImpl userRepository) {
        this._userRepository = userRepository;
        this._mapper = new ModelMapper();
    }

    @Override
    public ResponseDto followUser(int userId, int userIdToFollow) {
        User user = _userRepository.findUserById(userId);
        User userToFollow = _userRepository.findUserById(userIdToFollow);
        if (user == null || userToFollow == null){
            throw new UserNotFoundException("Usuario no encontrado.");
        }
        if (user.getFollowed().contains(userToFollow.getUserId()) || userToFollow.getFollowers().contains(user.getUserId())){
            throw new UserAlreadyFollowedException(String.format("Ya sigues a %s.", userToFollow.getUserName()));
        }
        if (user.getUserId() == userToFollow.getUserId()){
            throw new UserFollowNotAllowedException("No puedes seguirte a ti mismo.");
        }
        user.getFollowed().add(userToFollow.getUserId());
        userToFollow.getFollowers().add(user.getUserId());
        ResponseDto userFollowResponseDto = new ResponseDto();
        userFollowResponseDto.setMessage(String.format("Ahora sigues a %s.", userToFollow.getUserName()));
        return userFollowResponseDto;
    }
    @Override
    public UserFollowersCountDto getFollowersCount(int userId) {
        User user = _userRepository.findUserById(userId);
        if (user == null){
            throw new UserNotFoundException("Usuario no encontrado.");
        }
        UserFollowersCountDto userFollowersCountDto = new UserFollowersCountDto();
        userFollowersCountDto.setUserId(user.getUserId());
        userFollowersCountDto.setUserName(user.getUserName());
        userFollowersCountDto.setFollowersCount(user.getFollowers().size());
        return userFollowersCountDto;
    }
    @Override
    public ResponseDto unfollowUser(int userId, int userIdToUnfollow){
        User user = _userRepository.findUserById(userId);
        User userToUnfollow = _userRepository.findUserById(userIdToUnfollow);
        if (user == null || userToUnfollow == null){
            throw new UserNotFoundException("Usuario no encontrado.");
        }
        if (!user.getFollowed().contains(userToUnfollow.getUserId()) || !userToUnfollow.getFollowers().contains(user.getUserId())){
            throw new UserNotFollowedException(String.format("No sigues a %s.", userToUnfollow.getUserName()));
        }
        if (user.getUserId() == userToUnfollow.getUserId()){
            throw new UserUnfollowNotAllowedException("No puedes dejar de seguirte a ti mismo.");
        }
        user.getFollowed().remove(userToUnfollow.getUserId());
        userToUnfollow.getFollowers().remove(user.getUserId());
        ResponseDto userUnfollowResponseDto = new ResponseDto();
        userUnfollowResponseDto.setMessage(String.format("Dejaste de seguir a %s.", userToUnfollow.getUserName()));
        return userUnfollowResponseDto;
    }
    @Override
    public FollowersResponseDto getFollowersById(int userId) {
        List<UserResponseDto> followers = _userRepository
                .getFollowersById(userId)
                .stream()
                .map(follower -> _mapper.map(_userRepository.getById(follower), UserResponseDto.class))
                .collect(Collectors.toList());
        if (followers.isEmpty()) throw new NotFoundException("No se encontraron seguidores para el vendedor");
        return new FollowersResponseDto(userId, _userRepository.getById(userId).getUserName(), followers);
    }
    @Override
    public FollowersResponseDto getFollowersByIdSorted(int userId, String order) {
        if (!(order.equals("name_asc") || order.equals("name_desc"))) {
            throw new IllegalDataException("Ordenamiento invalido");
        }
        List<UserResponseDto> followers = _userRepository.getFollowersById(userId)
                .stream()
                .map(follower -> _mapper.map(_userRepository.getById(follower), UserResponseDto.class))
                .sorted((u1, u2) -> order.equals("name_asc") ? u1.getUserName().compareTo(u2.getUserName())
                        : u2.getUserName().compareTo(u1.getUserName()))
                .collect(Collectors.toList());
        if (followers.isEmpty()) throw new NotFoundException("No se encontraron seguidores para el vendedor");
        return new FollowersResponseDto(userId, _userRepository.getById(userId).getUserName(), followers);
    }
    @Override
    public FollowedResponseDto getFollowedById(int userId) {
        List<UserResponseDto> followedList = _userRepository.getFollowedById(userId)
                .stream()
                .map(followed -> _mapper.map(_userRepository.getById(followed), UserResponseDto.class))
                .collect(Collectors.toList());
        if (followedList.isEmpty()) throw new NotFoundException("El usuario no sigue a ningún vendedor");
        return new FollowedResponseDto(userId, _userRepository.getById(userId).getUserName(), followedList);
    }
    @Override
    public FollowedResponseDto getFollowedByIdSorted(int userId, String order) {
        if (!(order.equals("name_asc") || order.equals("name_desc"))) {
            throw new IllegalDataException("Ordenamiento invalido");
        }
        List<UserResponseDto> followedList = _userRepository.getFollowedById(userId)
                .stream()
                .map(followed -> _mapper.map(_userRepository.getById(followed), UserResponseDto.class))
                .sorted((u1, u2) -> order.equals("name_asc") ? u1.getUserName().compareTo(u2.getUserName())
                        : u2.getUserName().compareTo(u1.getUserName()))
                .collect(Collectors.toList());
        if (followedList.isEmpty()) throw new NotFoundException("El usuario no sigue a ningún vendedor");
        return new FollowedResponseDto(userId, _userRepository.getById(userId).getUserName(), followedList);
    }

    @Override
    public ResponseDto removeUser(int userId) {
        String user = _userRepository.removeUser(userId);
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage(String.format("El usuario %s ha sido eliminado", user));
        return responseDto;
    }


}