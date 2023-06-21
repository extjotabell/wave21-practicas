package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowUserDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowerListDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.IUserRepository;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.DescriptorKey;
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
    @DisplayName("Getting followers count for an existing user")
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
    // falta el camino triste

    //public FollowerListDTO getFollowersList(int idUser, String order);

    /*
    *
    "user_id": 1,
    "user_name": "Pepe",
    "followers": [
        {
            "user_id": 2,
            "user_name": "Pablo"
        },
        {
            "user_id": 3,
            "user_name": "Pedro"
        }
    ]
    *
    *
    * */
    @Test
    public void getFollowerList() { //lista sin ordenar
        //Arrange
        int userId = 1;
        FollowUserDTO user1 = new FollowUserDTO(2, "Pablo");
        FollowUserDTO user2 = new FollowUserDTO(3, "Pedro");
        List<FollowUserDTO> followers = List.of(user1, user2);
        User user3 = new User(2,"Pablo",null,null, null);
        User user4 = new User(3,"Pedro",null,null, null);
        List<User> followers1 = List.of(user3, user4);
        User foundUser = new User(userId,"Pepe",followers1,null, null);

        Mockito.when(userRepository.findUserById(userId)).thenReturn(Optional.of(foundUser));

        FollowerListDTO expected = new FollowerListDTO(userId, "Pepe", followers);

        //Act
        FollowerListDTO actual = userService.getFollowersList(userId, null);
        //Assert
        Assertions.assertEquals(actual, expected);

    }






}
