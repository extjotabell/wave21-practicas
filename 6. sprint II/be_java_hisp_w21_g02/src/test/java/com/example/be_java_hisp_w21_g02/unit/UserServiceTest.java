package com.example.be_java_hisp_w21_g02.unit;

import com.example.be_java_hisp_w21_g02.repository.UserRepositoryImpl;
import com.example.be_java_hisp_w21_g02.service.ProductsServiceImpl;
import com.example.be_java_hisp_w21_g02.service.UsersServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    UserRepositoryImpl userRepository;

    @InjectMocks
    UsersServiceImpl userService;

    @Test
    @DisplayName("Unit Test T01 - Verificar que el usuario a seguir exista.")
    void followUserTestUserToFollowExists(){
        //Arrange
        //Act
        //Assert
    }

    @Test
    @DisplayName("Unit Test T02 - Verificar que el usuario a dejar de seguir exista.")
    void unfollowUserTestUserToUnfollowExists(){
        //Arrange
        //Act
        //Assert
    }


}
