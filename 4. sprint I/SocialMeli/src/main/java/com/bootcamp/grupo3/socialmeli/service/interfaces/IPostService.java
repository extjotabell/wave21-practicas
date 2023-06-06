package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.response.UserPostListDTO;

public interface IPostService {
  UserPostListDTO getPostList(int userId, String order);

}
