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
        User ramiro = new User(4, "ramiro", new ArrayList<>(), new ArrayList<>());
        User mer = new User (5, "mer", new ArrayList<>(), new ArrayList<>());
        User lucho = new User (6, "lucho", new ArrayList<>(), new ArrayList<>());
        users.add(mtato);
        users.add(nauhel);
        users.add(juansito);
        users.add(ramiro);
        users.add(mer);
        users.add(lucho);

        ramiro.setFollowers(new ArrayList<>(List.of(mer,lucho)));
        mer.setFollowed(new ArrayList<>(List.of(ramiro,lucho)));
        mer.setFollowers(new ArrayList<>(List.of(lucho)));
        lucho.setFollowed(new ArrayList<>(List.of(ramiro,mer)));
        lucho.setFollowers(List.of(mer));
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
