package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.config.ModelMapperConfig;
import com.bootcamp.grupo3.socialmeli.dto.request.LoginDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.*;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.exception.UserPermissionException;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.order.UserOrderType;
import com.bootcamp.grupo3.socialmeli.repository.UserRepository;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

//@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ContextConfiguration(classes= ModelMapperConfig.class)
public class UserTest {

  @Mock
  IUserRepository userRepository;

  @Spy
  ModelMapper modelMapper;

  @InjectMocks
  UserService userService;

  /**
  public UserTest() {
    this.userService = new UserService(this.userRepository, new ModelMapper());
  }
   */


  @Test
  void followTestOk() throws Exception {
    String token = "";
    Optional<User> mockUser = createUser(1, "sere", "1234");
    Optional<User> mockUserToFollow = createUser(3, "marta", "1234");

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(mockUser);
    Mockito.when(userRepository.getUserByID(3)).thenReturn(mockUserToFollow);

    userService.follow(token, 3);

    Assertions.assertTrue(mockUser.get().getFollowed().contains(mockUserToFollow.get()));
  }

  @Test
  void followTestWithNoValidTokenException() {
    String token = "";
    Optional<User> mockUser = createUser(1, "sere", "1234");

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(Optional.empty());
    Mockito.when(userRepository.getUserByID(1)).thenReturn(mockUser);

    Assertions.assertThrows(
      UserPermissionException.class,
      () -> userService.follow(token, 3)
    );
  }

  @Test
  void followNoValidUserToFollowException() {
    String token = "";
    Optional<User> mockUser = createUser(1, "sere", "1234");

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(mockUser);
    Mockito.when(userRepository.getUserByID(3)).thenReturn(Optional.empty());

    Assertions.assertThrows(
      UserNotFoundException.class,
      () -> userService.follow(token, 3)
    );
  }

  @Test
  void unfollowTestOk() throws Exception {
    String token = "";
    Optional<User> mockUser = createUser(1, "mile", "1234");

    var f = new ArrayList<>(Arrays.asList(mockUser.get()));

    mockUser.get().setFollowers(f);
    mockUser.get().setFollowed(f);

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(mockUser);
    Mockito.when(userRepository.getUserByID(3)).thenReturn(mockUser);

    userService.unfollow(token, 3);

    Assertions.assertFalse(mockUser.get().getFollowers().contains(mockUser));
  }

  @Test
  void unfollowTestWithNoValidToken() {
    String token = "";
    Optional<User> mockUser = createUser(1, "sere", "1234");

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(Optional.empty());
    Mockito.when(userRepository.getUserByID(3)).thenReturn(Optional.empty());

    Assertions.assertThrows(
      UserPermissionException.class,
      () -> userService.unfollow(token, 3)
    );
  }

  @Test
  void getFollowedInNaturalOrderOk() throws Exception {
    String token = "1234";
    String order = "name_asc";

    Optional<User> user = createUser(1, "maxi", "1234");

    Optional<User> madelain = createUser(2, "madelain", "1234");
    UserDTO madelainDto = new UserDTO(madelain.get().getId(), madelain.get().getName());

    Optional<User> samuel = createUser(3, "samuel", "1234");
    UserDTO samuelDto = new UserDTO(samuel.get().getId(), samuel.get().getName());

    user.get().setFollowed(new ArrayList<>(Arrays.asList(madelain.get(), samuel.get())));

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(user);

    UserFollowedListDTO r = userService.getFollowed(token, order);

    Assertions.assertEquals(2, r.getFollowed().size());
    Assertions.assertTrue(
      r.getFollowed()
        .stream()
        .anyMatch(u -> u.getName().equals(samuelDto.getName()))
    );
    Assertions.assertAll(
      () -> r.getFollowed().get(0).getName().equals(madelainDto.getName()),
      () -> r.getFollowed().get(1).getName().equals(samuelDto.getName())
    );
  }

  @Test
  void getFollowedInDescendentOrderOk() throws Exception {
    String token = "1234";
    String order = "name_desc";

    Optional<User> user = createUser(1, "maxi", "1234");

    Optional<User> madelain = createUser(2, "madelain", "1234");
    UserDTO madelainDto = new UserDTO(madelain.get().getId(), madelain.get().getName());

    Optional<User> samuel = createUser(3, "samuel", "1234");
    UserDTO samuelDto = new UserDTO(samuel.get().getId(), samuel.get().getName());

    user.get().setFollowed(new ArrayList<>(Arrays.asList(madelain.get(), samuel.get())));

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(user);

    UserFollowedListDTO r = userService.getFollowed(token, order);

    Assertions.assertAll(
      () -> r.getFollowed().get(0).getName().equals(samuelDto.getName()),
      () -> r.getFollowed().get(1).getName().equals(madelainDto.getName())
    );
  }

  @Test
  void getFollowedWithInvalidTokenException() {

    Mockito.when(userRepository.getUserByToken("")).thenReturn(Optional.empty());

    Assertions.assertThrows(
      UserPermissionException.class,
      () -> userService.getFollowed("", "")
     );
  }

  @Test
  void getFollowersOk() throws Exception {
    String token = "1234";

    Optional<User> user = createUser(1, "maxi", "1234");
    Optional<User> madelain = createUser(2, "madelain", "1234");
    Optional<User> samuel = createUser(3, "samuel", "1234");

    user.get().setFollowers(new ArrayList<>(Arrays.asList(madelain.get(), samuel.get())));

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(user);

    UserFollowersListDTO f = userService.getFollowers(token, UserOrderType.DEFAULT);

    Assertions.assertTrue(f.getFollowers().stream().anyMatch(u -> u.getName().equals("samuel")));
    Assertions.assertTrue(f.getFollowers().stream().anyMatch(u -> u.getName().equals("madelain")));
  }

  @Test
  void getFollowedCountOk() throws Exception {
    String token = "1234";

    Optional<User> user = createUser(1, "maxi", "1234");
    Optional<User> madelain = createUser(2, "madelain", "1234");
    Optional<User> samuel = createUser(3, "samuel", "1234");

    user.get().setFollowers(new ArrayList<>(Arrays.asList(madelain.get(), samuel.get())));

    Mockito.when(userRepository.getUserByToken(token)).thenReturn(user);

    UserFollowerCountDTO f = userService.getUserFollowersCount(token);

    Assertions.assertEquals(f.getFollowersCount(), 2);
  }

  @Test
  void createUser() {
    UserPasswordDTO u = new UserPasswordDTO("Leo", "1234");
    UserIdDTO expected = new UserIdDTO(1);

    Mockito.when(userRepository.createUser(Mockito.any())).thenReturn(1);
    UserIdDTO r = userService.createUser(u);

    Assertions.assertEquals(expected.id(), r.id());
  }

  @Test
  void validateUser() {
    LoginDTO l = new LoginDTO(1, "1234");

    Mockito.when(userRepository.generateToken(1, "1234")).thenReturn("345698");
    Mockito.when(userRepository.userExists(1)).thenReturn(true);

    TokenDTO t = userService.validateUser(l);

    Assertions.assertEquals(t.token(), "345698");
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
