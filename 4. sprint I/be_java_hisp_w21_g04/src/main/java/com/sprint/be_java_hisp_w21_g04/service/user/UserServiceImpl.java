package com.sprint.be_java_hisp_w21_g04.service.user;

import com.sprint.be_java_hisp_w21_g04.dto.response.FollowersResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;
import com.sprint.be_java_hisp_w21_g04.repository.user.IUserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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

        List<UserResponseDto> followers = _userRepository.getFollowersById(userId).stream().map(follower -> _mapper.map(_userRepository.getById(follower), UserResponseDto.class)).collect(Collectors.toList());

        return new FollowersResponseDto(userId, _userRepository.getById(userId).getUserName(), followers);
    }

}
