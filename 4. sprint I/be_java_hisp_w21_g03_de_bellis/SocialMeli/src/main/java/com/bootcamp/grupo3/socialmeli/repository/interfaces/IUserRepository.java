package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserRepository {
    Optional<User> getUserByID(int userID);
    boolean userExists(int id);

    int createUser(User u);

    String generateToken(int userId, String password);
    boolean validateToken(String token);

    Optional<User> getUserByToken(final String token);
}
