package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository(){
        users.add(User.builder().id(1).name("mtato").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        users.add(User.builder().id(2).name("luchoDeMeli").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        users.add(User.builder().id(3).name("GabitoDeMerlo").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        users.add(User.builder().id(4).name("LaOrneDeFlorida").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        users.add(User.builder().id(5).name("Juansito").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        users.add(User.builder().id(6).name("nauhel").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        users.add(User.builder().id(7).name("Favrisio").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
        users.add(User.builder().id(8).name("Mersh").followed(new ArrayList<>()).followers(new ArrayList<>()).build());
    }

    @Override
    public Optional<User> getUserByID(int userID) {
        return this.users
                .stream()
                .filter(user -> user.getId() == userID)
                .findFirst();
    }
}
