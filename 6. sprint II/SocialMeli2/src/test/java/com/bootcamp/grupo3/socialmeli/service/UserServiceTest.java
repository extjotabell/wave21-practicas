package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTest {
    @Mock
    UserRepository userRepo;

    @InjectMocks
    UserService service;

    @Spy
    ModelMapper mapper;

    User ramiro;
    User nauhel;
    User juansito;
    User lucho;
    User fabri;
    User orne;

    @BeforeEach
    void setUp() {
        init_test_003_004_007();
    }

    @Test
    void follow() {
    }

    @Test
    void unfollow() {
    }

    @Test
    void getFollowed() {
    }

    @Test
    void getFollowers() {
    }

    @Test
    void userExists() {
    }

    @Test
    void getFollowedByUser() {
    }

    @Test
    @DisplayName("T-0007")
    void getUserFollowersCount() {
        //Arrange
        int id = 1;
        UserFollowerCountDTO expectedResult = new UserFollowerCountDTO(ramiro.getId(), ramiro.getName(), ramiro.getFollowers().size());
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));
        //Act
        UserFollowerCountDTO actualResult = service.getUserFollowersCount(id);
        //Assert
        assertEquals(expectedResult, actualResult);
    }

    void init_test_003_004_007 (){
        ramiro = new User(1, "ramiro", new ArrayList<>(), new ArrayList<>());
        nauhel = new User(2, "nauhel", new ArrayList<>(), new ArrayList<>());
        juansito = new User(3, "juancito", new ArrayList<>(), new ArrayList<>());
        lucho = new User(4, "luchoDelCampo", new ArrayList<>(), new ArrayList<>());
        fabri = new User(5, "fabri", new ArrayList<>(), new ArrayList<>());
        orne = new User(6, "orne", new ArrayList<>(), new ArrayList<>());

        List<User> followers = new ArrayList<>();
        List<User> followed = new ArrayList<>();
        followed.add(juansito);
        followed.add(lucho);
        followed.add(fabri);
        ramiro.setFollowed(followed);
        followers.add(nauhel);
        followers.add(lucho);
        followers.add(fabri);
        ramiro.setFollowers(followers);
    }

}