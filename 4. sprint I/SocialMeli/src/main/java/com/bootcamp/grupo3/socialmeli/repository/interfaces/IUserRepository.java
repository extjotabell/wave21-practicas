package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.User;

import java.util.Optional;

public interface IUserRepository {
    boolean userExists(int id);
    Optional<User> getUser(int id);
}
