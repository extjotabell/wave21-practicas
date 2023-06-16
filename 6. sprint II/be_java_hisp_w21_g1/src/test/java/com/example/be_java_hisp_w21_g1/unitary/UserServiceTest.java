package com.example.be_java_hisp_w21_g1.unitary;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.IUserRepository;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class UserServiceTest {
   @Autowired
   @Mock
   IUserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("T-0001 - Verificar que el usuario a seguir exista")
    void verifiedUserExistence(){

    }

    @Test
    @DisplayName("US-0003 - Happy path :) ")
    public void orderListOk() {

    }

    @Test
    @DisplayName("US-0003 - Sad path :( ")
    public void orderListThrowsException() {
        //Lanza BadRequestException
    }

    /*Optional<User> foundUser = userRepository.findUserById(idUser);
        if (foundUser.isEmpty()) {
            throw new NotFoundException("No se encontro el usuario con el ID" + idUser);
        }

        User user = foundUser.get();
        int followersCount = user.followersCount();
        return new FollowersCountDTO(idUser, user.getUser_name(),followersCount);
    */

    @Test
    @DisplayName("T-0007 - Happy Path :D ")
    void followerCountOk(){
        //Arrange
        int userId = 1;
        String user_name = "Juan";
        List<User> followers = new ArrayList<>();
        followers.add(new User(2,"Pepe", null, null, null));
        User user = new User(userId,user_name, followers, null, null);

        FollowersCountDTO expected = new FollowersCountDTO(userId,user_name, 1);

        //Act
        Mockito.when(userRepository.findUserById(userId)).thenReturn(Optional.of(user));
        FollowersCountDTO actual = userService.getFollowersCount(userId);

        //Assert
       Assertions.assertEquals(expected, actual);


    }


    @Test
    @DisplayName("T-0007 - Sad Path D:")
    void followerCountThrowsException(){
        // Lanza NotFoundException
        //Arrange

        //Act


        //Assert

    }








}
