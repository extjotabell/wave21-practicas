package com.sprint.be_java_hisp_w21_g04.unitTest.service;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowedResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.ResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.UserAlreadyFollowedException;
import com.sprint.be_java_hisp_w21_g04.exception.UserFollowNotAllowedException;
import com.sprint.be_java_hisp_w21_g04.exception.UserNotFoundException;
import com.sprint.be_java_hisp_w21_g04.repository.user.UserRepositoryImpl;
import com.sprint.be_java_hisp_w21_g04.service.user.UserServiceImpl;
import org.apache.coyote.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    UserRepositoryImpl userRepository;
    @InjectMocks
    UserServiceImpl userService;
    @Test
    @DisplayName("T0001 - Caso ideal (US-0001)")
    void followUserPerfectCase() {
        // Arrange
        // Mockeo lo que recibe y lo que retorna la función
        int userId = 1;
        int userIdToFollow = 2;
        User user = new User(1,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        User userToFollow = new User(2,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userRepository.findUserById(userIdToFollow)).thenReturn(userToFollow);
        // Act
        ResponseDto responseDto = userService.followUser(userId, userIdToFollow);
        // Assert
        assertNotNull(responseDto);
        assertEquals("Has seguido a MikeJohnson", responseDto.getMessage());
        assertTrue(user.getFollowed().contains(userIdToFollow));
        assertTrue(userToFollow.getFollowers().contains(userId));
    }
    @Test
    @DisplayName("T0001 - Caso cuando usuario a seguir no existe (US-0001)")
    void followUserWhenUserNotExist() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;
        User user = new User(1,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userRepository.findUserById(userIdToFollow)).thenReturn(null);
        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userService.followUser(userId, userIdToFollow));
        assertFalse(user.getFollowed().contains(userIdToFollow));
    }
    @Test
    @DisplayName("T0001 - Caso cuando usuario1 ya sigue a usuario2 (US-0001)")
    void followUserWhenUserAlreadyFollows() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 2;
        User user = new User(1,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        User userToFollow = new User(2,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        user.getFollowed().add(userIdToFollow);
        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userRepository.findUserById(userIdToFollow)).thenReturn(userToFollow);
        // Act & Assert
        assertThrows(UserAlreadyFollowedException.class, () -> userService.followUser(userId, userIdToFollow));
        assertTrue(user.getFollowed().contains(userIdToFollow));
    }
    @Test
    @DisplayName("T0001 - Caso cuando usuario no se puede seguir a si mismo (US-0001)")
    void followUserWhenUserFollowsItself() {
        // Arrange
        int userId = 1;
        int userIdToFollow = 1;
        User user = new User(1,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(user);
        // Act & Assert
        assertThrows(UserFollowNotAllowedException.class, () -> userService.followUser(userId, userIdToFollow));
        assertFalse(user.getFollowed().contains(userIdToFollow));
    }
}