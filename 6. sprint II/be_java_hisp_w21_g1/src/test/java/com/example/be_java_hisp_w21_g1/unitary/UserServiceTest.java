package com.example.be_java_hisp_w21_g1.unitary;

import com.example.be_java_hisp_w21_g1.Repository.IUserRepository;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

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

}
