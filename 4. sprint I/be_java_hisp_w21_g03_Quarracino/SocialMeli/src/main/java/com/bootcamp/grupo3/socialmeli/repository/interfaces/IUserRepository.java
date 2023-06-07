package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> getUserByID(int userID);
    boolean userExists(int id);
}
