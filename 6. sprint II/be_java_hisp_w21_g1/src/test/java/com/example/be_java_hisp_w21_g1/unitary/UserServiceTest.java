package com.example.be_java_hisp_w21_g1.unitary;

import com.example.be_java_hisp_w21_g1.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1.Exception.NotFoundException;
import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Model.Product;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.IUserRepository;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import com.example.be_java_hisp_w21_g1.Service.IUserService;
import com.example.be_java_hisp_w21_g1.Service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
    @Mock
    IUserRepository userRepository;
    @InjectMocks
    UserService userService;

    @Test
    @DisplayName("T-0001 - Verificar que el usuario a seguir exista - Happy Path")
    void verifiedUserExistenceOk(){
        //Arrange
        Product product1 = new Product(1, "Producto1", "Type1", "Brand1", "Color1", "Notes1");

        Post post1 = new Post(1, 1, LocalDate.of(2023, 06, 04), product1, 1, 25.50);

        List<Post> posts = new ArrayList<>();
        posts.add(post1);

        FollowPostDTO followPostDTO = new FollowPostDTO(1, 2);

        Optional<User> user = Optional.of(new User(1, "Pepe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        Optional<User> seller = Optional.of(new User(2, "Pablo", new ArrayList<>(), new ArrayList<>(), posts));

        when(userRepository.findUserById(followPostDTO.getUserId())).thenReturn(user);
        when(userRepository.findUserById(followPostDTO.getUserIdToFollow())).thenReturn(seller);

        //Act
        boolean actualResult = userService.follow(followPostDTO);

        //Assert
        Assertions.assertTrue(actualResult);
    }

    @Test
    @DisplayName("T-0001 - Verificar que el usuario a seguir no exista - Bad Path")
    void verifiedUserExistenceNonOk(){
        //Arrange
        FollowPostDTO followPostDTO = new FollowPostDTO(1, 2);

        Optional<User> user = Optional.of(new User(1, "Pepe", new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        Optional<User> seller = Optional.empty();

        when(userRepository.findUserById(followPostDTO.getUserId())).thenReturn(user);
        when(userRepository.findUserById(followPostDTO.getUserIdToFollow())).thenReturn(seller);

        //Act
        //Assert
        Assertions.assertThrows(NotFoundException.class, ()-> {
            userService.follow(followPostDTO);
        });

    }

}
