package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.IUserRepository;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static jdk.internal.org.objectweb.asm.util.CheckClassAdapter.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceIntegrationTests {




    @Mock
    @Autowired
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @BeforeEach

    public void beforeEach() {
       // userRepository  = new UserRepository();

    }

    //   public FollowersCountDTO getFollowersCount(int idUser);

    @Test

    public void gettingFollowersCount() {

        //Arrange
        int userId = 1;
        String userName = "usuario";
        int followersCount = 2;

        User user1 = new User(2,"usuario1",null,null, null);
        User user2 = new User(3,"usuario2",null,null, null);
        List<User> followers = List.of(user1, user2);
        User foundUser = new User(userId,userName,followers,null, null);
        FollowersCountDTO expected = new FollowersCountDTO(userId, userName, followersCount);

        Mockito.when(userRepository.findUserById(userId)).thenReturn(Optional.of(foundUser));

        //Act

        FollowersCountDTO actual = userService.getFollowersCount(userId);

        //Assert

      Assertions.assertEquals(actual, expected);




    }



}
