package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IPostRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IPostService;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PostService implements IPostService {
    private IPostRepository postRepository;
    private IUserService userService;
    private ModelMapper modelMapper;

    public PostService(IPostRepository postRepository, ModelMapper modelMapper, IUserService userService) {
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
        this.userService = userService;
    }

    public int createPost(PostDTO body) {
        Post newPost = modelMapper.map(body, Post.class);
        if (userService.userExists(newPost.getUserId())) {
            return postRepository.createPost(newPost);
        } else {
            throw new RuntimeException("No se encontro el usuario");
        }
    }
}
