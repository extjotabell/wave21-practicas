package com.example.be_java_hisp_w21_g1.integration;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowUserDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowerListDTO;
import com.example.be_java_hisp_w21_g1.Exception.BadRequestException;
import com.example.be_java_hisp_w21_g1.Exception.NotFoundException;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.IUserRepository;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
    @Mock
    IUserRepository userRepository;

    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("Obtener la lista de seguidores - Camino Feliz")
    void getFollowersList(){
        //Arrange
        List<User> followersMock = new ArrayList<>();
        followersMock.add(new User(2,"Diana",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));
        followersMock.add(new User(3,"Lucia",new ArrayList<>(),new ArrayList<>(),new ArrayList<>()));

        User userMock = new User(1,"Luz",followersMock,new ArrayList<>(),new ArrayList<>());

        List<FollowUserDTO> followerExpected = new ArrayList<>();
        followerExpected.add(new FollowUserDTO(2,"Diana"));
        followerExpected.add(new FollowUserDTO(3,"Lucia"));

        FollowerListDTO expected = new FollowerListDTO(1,"Luz",followerExpected);
        //Mock
        when(userRepository.findUserById(1)).thenReturn(Optional.of(userMock));
        //Act
        FollowerListDTO result = userService.getFollowersList(1,null);
        //Assert
        assertEquals(expected,result);
    }

    @Test
    @DisplayName("Obtener la lista de seguidores - Camino triste")
    void getFollowersListNoOk(){
        //Arrange
        Optional<User> userMock = Optional.empty();

        //Mock
        when(userRepository.findUserById(1)).thenReturn(userMock);

        //Assert
        Assertions.assertThrows(NotFoundException.class, ()-> {
            userService.getFollowedList(1,null);
        });
    }
}
