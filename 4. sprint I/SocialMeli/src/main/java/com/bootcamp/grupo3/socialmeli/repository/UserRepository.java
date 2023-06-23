package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();

    public UserRepository() {
        User mtato = new User(1, "mtato", new ArrayList<>(), new ArrayList<>());
        User nauhel = new User(2, "nauhel", new ArrayList<>(), new ArrayList<>());
        User juansito = new User(3, "juancito", new ArrayList<>(), new ArrayList<>());
        User lucho = new User(4, "luchoDelCampo", new ArrayList<>(), new ArrayList<>());
        User orne = new User(5, "orne", new ArrayList<>(), new ArrayList<>());


        nauhel.getFollowers().add(mtato);
        nauhel.getFollowers().add(juansito);
        nauhel.getFollowers().add(orne);
        nauhel.getFollowed().add(lucho);
        nauhel.getFollowed().add(orne);
        mtato.getFollowed().add(nauhel);
        orne.getFollowed().add(nauhel);
        juansito.getFollowed().add(nauhel);
        mtato.getFollowed().add(orne);
        orne.getFollowers().add(mtato);
        orne.getFollowers().add(nauhel);
        lucho.getFollowers().add(nauhel);
        users.add(mtato);
        users.add(nauhel);
        users.add(juansito);
        users.add(lucho);
        users.add(orne);
    }

    @Override
    public boolean userExists(int id) {
        return users.stream().anyMatch(u -> u.getId() == id);
    }

    @Override
    public Optional<User> getUserByID(int userID) {
        return this.users
                .stream()
                .filter(user -> user.getId() == userID)
                .findFirst();
    }
}
