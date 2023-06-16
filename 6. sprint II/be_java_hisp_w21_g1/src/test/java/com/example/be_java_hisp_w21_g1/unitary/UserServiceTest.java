package com.example.be_java_hisp_w21_g1.unitary;

import com.example.be_java_hisp_w21_g1.DTO.Response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g1.Model.User;
import com.example.be_java_hisp_w21_g1.Repository.IUserRepository;
import com.example.be_java_hisp_w21_g1.DTO.Request.FollowPostDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowedListDTO;
import com.example.be_java_hisp_w21_g1.DTO.Response.FollowerListDTO;
import com.example.be_java_hisp_w21_g1.Exception.NotFoundException;
import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Model.Product;


import com.example.be_java_hisp_w21_g1.Service.UserService;
import net.bytebuddy.dynamic.DynamicType;
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

import java.util.List;
import java.util.Optional;



import java.util.ArrayList;
import java.time.LocalDate;


import static org.mockito.Mockito.when;



@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class UserServiceTest {
   @Autowired
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

    @Test
    @DisplayName("T-0002 - Verificar que el usuario a dejar de seguir exista")
    void verifyUnfollow(){
        // arrange
        FollowPostDTO followPostDTO = new FollowPostDTO(1, 2);

        User seller = new User(2, "Seller 1", null, null, null);
        User user = new User(1, "Usuario 1", null, List.of(seller), null);
        seller.setFollowers(List.of(user));

        Mockito.when(userRepository.findUserById(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findUserById(2)).thenReturn(Optional.of(seller));

        // assert
        Assertions.assertTrue(userService.unFollow(followPostDTO));
    }

    @Test
    @DisplayName("T-0002.1 - Verificar que retorna false al no encontrar el usuario a dejar de seguir")
    void unfollowNonexistentUser(){
        // arrange
        FollowPostDTO followPostDTO = new FollowPostDTO(1, 2);

        User seller = new User(2, "Seller 1", null, null, null);
        User user = new User(1, "Usuario 1", null, List.of(seller), null);
        seller.setFollowers(List.of(user));

        Mockito.when(userRepository.findUserById(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findUserById(2)).thenReturn(Optional.empty());


        // assert
        Assertions.assertFalse(userService.unFollow(followPostDTO));
    }

    @Test
    @DisplayName("T-0002.2 - Verificar que haya una relacion al dejar de seguir")
    void unfollowNonFollower(){
        // arrange
        FollowPostDTO followPostDTO = new FollowPostDTO(1, 2);

        User seller = new User(2, "Seller 1", List.of(), null, null);
        User user = new User(1, "Usuario 1", null, List.of(), null);

        Mockito.when(userRepository.findUserById(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findUserById(2)).thenReturn(Optional.of(seller));

        // assert
        Assertions.assertFalse(userService.unFollow(followPostDTO));
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

        int userId = 99;
        Optional<User> user = Optional.empty();
        //Act

        Mockito.when(userRepository.findUserById(userId)).thenReturn(user);

        //Assert
        Assertions.assertThrows(NotFoundException.class, ()-> userService.getFollowersCount(userId));

    }

    @Test
    @DisplayName("T-0004 - (Seguidores) Verificar el correcto ordenamiento ascendente por nombre. (US-0008)")
    void getFollowersListAscOk(){
        //ARRANGE
        int idUser = 1;
        String order = "name_asc";
        User follower1 = new User();
        User follower2 = new User();
        follower1.setUser_id(2);
        follower1.setUser_name("Andrea");
        follower2.setUser_id(3);
        follower2.setUser_name("Santiago");

        Optional<User> userMock = Optional.of(new User(
                idUser,
                "Pepe",
                List.of(follower2,follower1),
                List.of(),
                List.of()
        ));

        //MOCK
        Mockito
                .when(userRepository.findUserById(idUser)).thenReturn(userMock);

        //ACT
        FollowerListDTO result = userService.getFollowersList(idUser, order);

        //ASSERT
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.getFollowers().get(0).getUser_id());
        Assertions.assertEquals(3, result.getFollowers().get(1).getUser_id());

    }

    @Test
    @DisplayName("T-0004 - (Seguidores) Verificar el correcto ordenamiento descendente por nombre. (US-0008)")
    void getFollowersListDescOk(){
        //ARRANGE
        int idUser = 1;
        String order = "name_desc";
        User follower1 = new User();
        User follower2 = new User();
        follower1.setUser_id(2);
        follower1.setUser_name("Andrea");
        follower2.setUser_id(3);
        follower2.setUser_name("Santiago");

        Optional<User> userMock = Optional.of(new User(
                idUser,
                "Pepe",
                List.of(follower2,follower1),
                List.of(),
                List.of()
        ));

        //MOCK
        Mockito
                .when(userRepository.findUserById(idUser)).thenReturn(userMock);

        //ACT
        FollowerListDTO result = userService.getFollowersList(idUser, order);

        //ASSERT
        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.getFollowers().get(0).getUser_id());
        Assertions.assertEquals(2, result.getFollowers().get(1).getUser_id());

    }

    @Test
    @DisplayName("T-0004 - (Seguidos) Verificar el correcto ordenamiento ascendente por nombre. (US-0008)")
    void getFollowedsListAscOk(){
        //ARRANGE
        int idUser = 1;
        String order = "name_asc";
        User followed1 = new User();
        User followed2 = new User();
        followed1.setUser_id(2);
        followed1.setUser_name("Andrea");
        followed2.setUser_id(3);
        followed2.setUser_name("Santiago");

        Optional<User> userMock = Optional.of(new User(
                idUser,
                "Pepe",
                List.of(),
                List.of(followed2,followed1),
                List.of()
        ));

        //MOCK
        Mockito
                .when(userRepository.findUserById(idUser)).thenReturn(userMock);

        //ACT
        FollowedListDTO result = userService.getFollowedList(idUser, order);

        //ASSERT
        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.getFollowed().get(0).getUser_id());
        Assertions.assertEquals(3, result.getFollowed().get(1).getUser_id());

    }

    @Test
    @DisplayName("T-0004 - (Seguidos) Verificar el correcto ordenamiento descendente por nombre. (US-0008)")
    void getFollowedsListDescOk(){
        //ARRANGE
        int idUser = 1;
        String order = "name_desc";
        User followed1 = new User();
        User followed2 = new User();
        followed1.setUser_id(2);
        followed1.setUser_name("Andrea");
        followed2.setUser_id(3);
        followed2.setUser_name("Santiago");

        Optional<User> userMock = Optional.of(new User(
                idUser,
                "Pepe",
                List.of(),
                List.of(followed2,followed1),
                List.of()
        ));

        //MOCK
        Mockito
                .when(userRepository.findUserById(idUser)).thenReturn(userMock);

        //ACT
        FollowedListDTO result = userService.getFollowedList(idUser, order);

        //ASSERT
        Assertions.assertNotNull(result);
        Assertions.assertEquals(3, result.getFollowed().get(0).getUser_id());
        Assertions.assertEquals(2, result.getFollowed().get(1).getUser_id());

    }
    

}
