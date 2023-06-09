package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.exception.BadPasswordException;
import com.bootcamp.grupo3.socialmeli.exception.InvalidTokenFormatException;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class UserRepository implements IUserRepository {
    private final List<User> users = new ArrayList<>();
    private final Map<String, Integer> tokens = new HashMap<>();

    public UserRepository() {
        User mtato = new User(1, "mtato", "1234", new ArrayList<>(), new ArrayList<>());
        User nauhel = new User(2, "nauhel", "1234", new ArrayList<>(), new ArrayList<>());
        User juansito = new User(3, "juancito", "1234", new ArrayList<>(), new ArrayList<>());
        users.add(mtato);
        users.add(nauhel);
        users.add(juansito);
    }

    public boolean validateToken(String token) {
      return tokens.containsKey(token); // TODO remove in one point
    }

    @Override
    public boolean userExists(final int id) {
        return users
          .stream()
          .anyMatch(u -> u.getId() == id);
    }

    @Override
    public String generateToken(final int userId, final String password) {
      User user = this.getUserByID(userId)
        .orElseThrow(() -> new UserNotFoundException("No esta registrado el usuario id:"+userId));

      if(!user.getPassword().equals(password)) //TODO comparar hash y no texto
        throw new BadPasswordException("la contraseña no es valida");

      if(tokens.containsValue(userId))
        return tokens.keySet()
          .stream()
          .filter(k -> tokens.get(k) == userId)
          .findFirst()
          .orElse("");

      Random i = new Random();
      //algorithm
      String firstLetterHash = ""+i.nextInt(64, 92);
      String secondLetterHash = ""+i.nextInt(64, 92);
      String thirdLetterHash = ""+i.nextInt(64, 92);

      String token = firstLetterHash+secondLetterHash+thirdLetterHash;
      tokens.put(token, userId);

      return token;
    }

    public int createUser(final User u) {
      users.add(u);
      u.setId(users.size());

      return u.getId();
    }

    public Optional<User> getUserByToken(final String token) {

        Integer id = Optional.ofNullable(tokens.get(token))
          .orElseThrow(() -> new InvalidTokenFormatException("El token no esta registrado o no es valido"));
        return this.getUserByID(id);
    }

    @Override
    public Optional<User> getUserByID(final int userID) {
        return this.users
                .stream()
                .filter(user -> user.getId() == userID)
                .findFirst();
    }
}
