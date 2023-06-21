package com.example.be_java_hisp_w21_g02.unit;

import com.example.be_java_hisp_w21_g02.exceptions.UserFollowingException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotSellerException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import com.example.be_java_hisp_w21_g02.service.UsersServiceImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserServiceTest {

    @Mock
    IUserRepository _userRepository;

    @InjectMocks
    UsersServiceImpl _userService;

    private static User user;
    private static User userToFollow;

    @BeforeEach
    void setup(){
        user = new  User(1, "Pedro", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        userToFollow = new User(2, "Martin", new HashSet<>(), new HashSet<>(), new ArrayList<>());
    }

    @Test
    @DisplayName("Unit Test US01 T01 - Follow existing user")
    void followUserTestUserToFollowExists(){
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1),3, 50D, new Product())));

        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Act
        _userService.followUser(user.getId(), userToFollow.getId());

        //Assert
        verify(_userRepository, atLeastOnce()).getUser(user.getId());
        verify(_userRepository, atLeastOnce()).persistFollows(user,userToFollow);

    }

    @Test
    @DisplayName("Unit Test US01 T02 - Follow non-existing user throws exception")
    void followUserTestUserToFollowDoesntExists() {
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(1)).thenReturn(user);
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class , () -> _userService.followUser(user.getId(), nonExistentUserId));
    }

    @Test
    @DisplayName("Unit Test US01 T03 - Follow user that is already followed throws exception")
    void followUserTestUserToFollowAlreadyBeingFollowed(){
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1),3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        _userService.followUser(user.getId(), userToFollow.getId());

        //Assert
        UserFollowingException userFollowingException =
            Assertions.assertThrows(UserFollowingException.class , () -> _userService.followUser(user.getId(), userToFollow.getId()));
        Assertions.assertEquals("This user is already following the user you want to follow", userFollowingException.getMessage());
    }

    @Test
    @DisplayName("Unit Test US01 T04 - Follow user that is not a seller throws exception")
    void followUserTestUserToFollowIsNotASeller(){
        //Arrange
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Act & Assert
        Assertions.assertThrows(UserNotSellerException.class , () -> _userService.followUser(user.getId(), userToFollow.getId()));
    }
    @Test
    @DisplayName("Unit Test US01 T05 - Follow myself throws exception")
    void followUserTestUserToFollowMyself(){
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1),3, 50D, new Product())));

        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Act & Assert
        UserFollowingException userFollowingException =
                Assertions.assertThrows(UserFollowingException.class , () -> _userService.followUser(userToFollow.getId(), userToFollow.getId()));
        Assertions.assertEquals( "The user can't follow itself", userFollowingException.getMessage());

    }

    @Test
    @DisplayName("Unit Test US01 T06 - user who follows does not exist throws exception")
    void followUserTestUserWhoFollowsNotExists(){
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class , () -> _userService.followUser(nonExistentUserId, userToFollow.getId()));
    }

    @Test
    @DisplayName("Unit Test US07 T01 - Unfollow existing user")
    void unfollowUserTestUserToUnfollowExists(){
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1),3, 50D, new Product())));
        when(_userRepository.getUser(1)).thenReturn(user);
        when(_userRepository.getUser(2)).thenReturn(userToFollow);
        _userService.followUser(user.getId(), userToFollow.getId());

        //Act
        _userService.unFollowUser(user.getId(), userToFollow.getId());

        //Assert
        verify(_userRepository, atLeastOnce()).persistFollows(user, userToFollow);
    }

    @Test
    @DisplayName("Unit Test US07 T02 - UnFollow non-existing user throws exception")
    void unfollowUserTestUserToUnFollowDoesntExists() {
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(1)).thenReturn(user);
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class , () -> _userService.unFollowUser(user.getId(), nonExistentUserId));
    }

    @Test
    @DisplayName("Unit Test US07 T03 - UnFollow user that is not being followed throws exception")
    void unfollowUserTestUserToUnFollowNotBeingFollowed(){
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1),3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Assert
        UserFollowingException userFollowingException =
                Assertions.assertThrows(UserFollowingException.class , () -> _userService.unFollowUser(user.getId(), userToFollow.getId()));
        Assertions.assertEquals("This user is not following the user you want to unfollow", userFollowingException.getMessage());
    }

    @Test
    @DisplayName("Unit Test US07 T04 - unFollow user that is not a seller throws exception")
    void unfollowUserTestUserToUnFollowIsNotASeller(){
        //Arrange
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Act & Assert
        Assertions.assertThrows(UserNotSellerException.class , () -> _userService.unFollowUser(user.getId(), userToFollow.getId()));
    }

    @Test
    @DisplayName("Unit Test US07 T05 - user who unfollows does not exist throws exception")
    void unfollowUserTestUserWhoUnFollowsNotExists(){
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class , () -> _userService.unFollowUser(nonExistentUserId, userToFollow.getId()));
    }
}
