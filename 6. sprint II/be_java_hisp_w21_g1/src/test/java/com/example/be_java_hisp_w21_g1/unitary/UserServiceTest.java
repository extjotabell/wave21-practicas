package com.example.be_java_hisp_w21_g1.unitary;

import com.example.be_java_hisp_w21_g1.Repository.IUserRepository;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class UserServiceTest {
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



    @Test
    @DisplayName("T-0007 - Happy Path :D ")
    void followerCountOk(){

    }


    @Test
    @DisplayName("T-0007 - Sad Path D:")
    void followerCountThrowsException(){
        // Lanza NotFoundException

    }








}
