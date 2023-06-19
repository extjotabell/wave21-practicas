package com.example.be_java_hisp_w21_g02.service;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.UserPostResponseDTO;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import com.example.be_java_hisp_w21_g02.utils.ExceptionChecker;
import com.example.be_java_hisp_w21_g02.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

@Service
public class ProductsServiceImpl implements IProductsService{

    private final IUserRepository _userRepository;
    private Mapper _mapper;

    public ProductsServiceImpl(IUserRepository userRepository) {
        this._userRepository = userRepository;
        this._mapper = new Mapper();
    }

    @Override
    public ResponseEntity<?> createPost(PostRequestDTO postRequestDTO) {
        Post post = _mapper.mapPostRequestDTOToPost(postRequestDTO);
        try{
            ExceptionChecker.checkBadRequestException(postRequestDTO);

            _userRepository.createPost(post);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> listFollowingPosts2Weeks(int userId) {
        List<User> responseList;
        try{
            responseList = _userRepository.listFollowingPosts2Weeks(userId);
        }catch (NullPointerException e) {
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
        }

        List<PostDTO> postsDTO = responseList.stream()
                .flatMap(user -> user.getPosts().stream())
                .map(post -> _mapper.mapPostToPostDTO(post))
                .toList();

        return ResponseEntity.ok(new UserPostResponseDTO(userId, postsDTO));
    }

    @Override
    public ResponseEntity<?> listFollowingPosts2Weeks(int userId, String order) {
        List<User> responseList;
        try {
            responseList = _userRepository.listFollowingPosts2Weeks(userId);
        } catch (NullPointerException e) {
            throw new UserNotFoundException("We couldn't find a user with the mentioned ID");
        }

        List<Post> postList =
                responseList.stream()
                        .flatMap(user -> user.getPosts().stream())
                        .sorted(
                                Objects.equals(order, Constants.ORDER_DATE_DESC) ?
                                        Comparator.comparing(Post::getDate).reversed() :
                                        Comparator.comparing(Post::getDate))
                        .toList();


        List<PostDTO> postsDTO = postList.stream().map( post -> _mapper.mapPostToPostDTO(post)).toList();

        return ResponseEntity.ok(new UserPostResponseDTO(userId, postsDTO));
    }
}