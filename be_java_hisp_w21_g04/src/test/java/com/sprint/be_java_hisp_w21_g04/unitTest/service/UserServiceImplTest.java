package com.sprint.be_java_hisp_w21_g04.unitTest.service;
import com.sprint.be_java_hisp_w21_g04.dto.response.FollowedResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.ResponseDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserFollowersCountDto;
import com.sprint.be_java_hisp_w21_g04.dto.response.UserResponseDto;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.*;
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

    @Test
    @DisplayName("T0002 - Caso ideal (US-0007)")
    void unfollowUserPerfectCase() {
        // Arrange
        int userId = 1;
        int userIdToUnfollow = 2;
        List<Integer> followedUsers = new ArrayList<>(List.of(userIdToUnfollow));
        List<Integer> followersUsers = new ArrayList<>(List.of(userId));
        User user = new User(1,"DavidWilson",new ArrayList<>(), followedUsers);
        User userToUnfollow = new User(2,"MikeJohnson", followersUsers,new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userRepository.findUserById(userIdToUnfollow)).thenReturn(userToUnfollow);
        // Act
        ResponseDto responseDto = userService.unfollowUser(userId, userIdToUnfollow);
        // Assert
        assertNotNull(responseDto);
        assertEquals("Has dejado de seguir a MikeJohnson", responseDto.getMessage());
        assertFalse(user.getFollowed().contains(userIdToUnfollow));
        assertFalse(userToUnfollow.getFollowers().contains(userId));
    }

    @Test
    @DisplayName("T0002 - Caso cuando usuario a dejar de seguir no existe (US-0007)")
    void UnfollowUserWhenUserNotExist() {
        // Arrange
        int userId = 1;
        int userIdToUnfollow = 2;
        User user = new User(1,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userRepository.findUserById(userIdToUnfollow)).thenReturn(null);
        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userService.unfollowUser(userId, userIdToUnfollow));
        assertFalse(user.getFollowed().contains(userIdToUnfollow));
    }

    @Test
    @DisplayName("T0002 - Caso cuando usuario1 no sigue a usuario2 (US-0007)")
    void UnfollowUserWhenUserIsNotFollowing() {
        // Arrange
        int userId = 1;
        int userIdToUnfollow = 2;
        User user = new User(1,"DavidWilson",new ArrayList<>(), new ArrayList<>());
        User userToUnfollow = new User(2,"MikeJohnson", new ArrayList<>(),new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(user);
        when(userRepository.findUserById(userIdToUnfollow)).thenReturn(userToUnfollow);
        // Act & Assert
        assertThrows(UserNotFollowedException.class, () -> userService.unfollowUser(userId, userIdToUnfollow));
        assertTrue(user.getFollowed().isEmpty());
        assertTrue(userToUnfollow.getFollowers().isEmpty());
    }

    @Test
    @DisplayName("T0002 - Caso cuando no puedes dejar de seguirte a tí mismo. (US-0007)")
    void UnfollowUserWhenUserUnfollowsItself() {
        // Arrange
        int userId = 1;
        int userIdToUnfollow = 1;
        User user = new User(1,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        when(userRepository.findUserById(userId)).thenReturn(user);
        // Act & Assert
        assertThrows(UserUnfollowNotAllowedException.class, () -> userService.unfollowUser(userId, userIdToUnfollow));
        assertFalse(user.getFollowed().contains(userIdToUnfollow));
        assertTrue(user.getFollowed().isEmpty());
    }

    @Test
    @DisplayName("T0007 - Caso ideal donde se obtiene la cantidad correcta de followers. (US-0002)")
    void getFollowersCount(){
        // Arrange
        int userOneId = 1;
        int userTwoId = 2;
        int userThreeId = 3;
        UserFollowersCountDto expectedFollowersCount = new UserFollowersCountDto();
        expectedFollowersCount.setUserId(userThreeId);
        expectedFollowersCount.setUserName("Jackie Chan");
        expectedFollowersCount.setFollowersCount(2);
        List<Integer> followedUsers = new ArrayList<>(List.of(userThreeId));
        List<Integer> followersUsers = new ArrayList<>(List.of(userOneId, userTwoId));
        User user1 = new User(userOneId,"DavidWilson",new ArrayList<>(), followedUsers);
        User user2 = new User(userTwoId,"MikeJohnson", new ArrayList<>(), followedUsers);
        // User 3 is followed by user 1 and user 2
        User user3 = new User(userThreeId,"Jackie Chan", followersUsers, new ArrayList<>());
        when(userRepository.findUserById(userThreeId)).thenReturn(user3);
        // Act
        UserFollowersCountDto responseDto = userService.getFollowersCount(userThreeId);
        // Assert
        assertNotNull(responseDto);
        assertEquals(expectedFollowersCount, responseDto);
    }

    @Test
    @DisplayName("T0007 - Caso cuando usuario no existe (US-0002)")
    void getFollowersCountWhenUserNotExist(){
        // Arrange
        int userId = 1;
        when(userRepository.findUserById(userId)).thenReturn(null);
        // Act & Assert
        assertThrows(UserNotFoundException.class, () -> userService.getFollowersCount(userId));
    }
}