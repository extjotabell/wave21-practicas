package com.example.be_java_hisp_w21_g02.utils;

import com.example.be_java_hisp_w21_g02.dto.PostDTO;
import com.example.be_java_hisp_w21_g02.dto.request.PostRequestDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowerDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersListDTO;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.User;
import org.modelmapper.ModelMapper;

import java.util.List;

public class Mapper {

    private final ModelMapper _modelMapper;

    public Mapper(){
        this._modelMapper = new ModelMapper();
    }

    public Post mapPostRequestDTOToPost(PostRequestDTO postRequestDTO){
        return _modelMapper.map(postRequestDTO, Post.class);
    }

    public PostDTO mapPostToPostDTO(Post post){
        return _modelMapper.map(post, PostDTO.class);
    }

    public FollowersCountDTO mapUserToFollowersCountDTO(User user) {
        return _modelMapper.map(user, FollowersCountDTO.class);
    }

    public FollowersListDTO mapUserToFollowersListDTO(User user, List<FollowerDTO> followers) {
        FollowersListDTO followersListDTO = _modelMapper.map(user, FollowersListDTO.class);
        followersListDTO.setFollowers(followers);
        return followersListDTO;
    }

    public FollowedListDTO mapUserToFollowedListDTO(User user, List<FollowerDTO> followeds) {
        FollowedListDTO followedListDTO = _modelMapper.map(user, FollowedListDTO.class);
        followedListDTO.setFollowed(followeds);
        return followedListDTO;
    }

    public FollowerDTO mapUserToFollowerDTO(User user) {
        return _modelMapper.map(user, FollowerDTO.class);
    }
}