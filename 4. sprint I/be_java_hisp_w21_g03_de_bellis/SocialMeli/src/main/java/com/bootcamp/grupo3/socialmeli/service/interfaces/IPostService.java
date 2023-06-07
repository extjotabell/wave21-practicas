package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.model.Post;
import com.bootcamp.grupo3.socialmeli.order.PostOrderType;


public interface IPostService {
    int createPost(PostDTO body) throws UserPermissionException;
    UserPostListDTO getPostList(String token, PostOrderType order) throws UserPermissionException;
    Post getPost(Integer integer);
}
