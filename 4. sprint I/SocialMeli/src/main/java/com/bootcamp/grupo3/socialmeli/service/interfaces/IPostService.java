package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.PostDTO;

public interface IPostService {
    int createPost(PostDTO body);
}
