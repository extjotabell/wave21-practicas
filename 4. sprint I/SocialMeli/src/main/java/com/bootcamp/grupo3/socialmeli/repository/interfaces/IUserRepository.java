package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
  List<User> getFollowedByUser(int userId);
}
