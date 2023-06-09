package com.bootcamp.grupo3.socialmeli.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.UserRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IUserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UserTest {
  @Mock
  UserRepository userRepository;

  @InjectMocks
  UserService userService;

  @Test
  void followTestOk() throws UserPermissionException {
    String token = "";
    Optional<User> mockUser = createUser(1, "sere", "1234");
    Optional<User> mockUserToFollow = createUser(3, "marta", "1234");

    when(userRepository.getUserByToken(token)).thenReturn(mockUser);
    when(userRepository.getUserByID(3)).thenReturn(mockUserToFollow);

    userService.follow(token, 3);

    assertTrue(mockUser.get().getFollowed().contains(mockUserToFollow.get()));
  }

  @Test
  void followTestWithNoValidToken() {

  }

  @Test
  void unfollowTestOk() {

  }

  @Test
  void unfollowTestWithNoValidToken() {

  }

  private Optional<User> createUser(int id, String name, String p) {
    return Optional.of(
      new User(id, name, p, new ArrayList<>(), new ArrayList<>())
    );
  }

  private Optional<User> createUser(int id, String name, String p, List<User> followed, List<User> followers) {
    return Optional.of(
      new User(id, name, p, followers, followed)
    );
  }
}
