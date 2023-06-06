package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowedResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.IllegalDataException;
import com.sprint.be_java_hisp_w21_g04.exception.NotFoundException;
import com.sprint.be_java_hisp_w21_g04.repository.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements IUserService{


    private IUserRepository _userRepository;
    private ModelMapper _mapper;

    public UserServiceImpl(IUserRepository userRepository) {
        this._userRepository = userRepository;
        this._mapper = new ModelMapper();
    }

    @Override
    public FollowersResponseDto getFollowersById(int userId) {

        List<UserResponseDto> followers = _userRepository.getFollowersById(userId)
                                                         .stream()
                                                         .map(follower -> _mapper.map(_userRepository.getById(follower), UserResponseDto.class))
                                                         .collect(Collectors.toList());

        if (followers.isEmpty()) throw new NotFoundException("No se encontraron seguidores para el vendedor");
        return new FollowersResponseDto(userId, _userRepository.getById(userId).getUserName(), followers);
    }

    @Override
    public FollowersResponseDto getFollowersByIdSorted(int userId, String order) {
        if(!(order.equals("name_asc") || order.equals("name_desc"))){
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
        if(!(order.equals("name_asc") || order.equals("name_desc"))){
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

}
