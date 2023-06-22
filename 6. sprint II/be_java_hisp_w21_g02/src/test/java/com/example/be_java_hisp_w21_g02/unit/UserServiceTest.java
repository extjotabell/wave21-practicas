package com.example.be_java_hisp_w21_g02.unit;

import com.example.be_java_hisp_w21_g02.dto.response.FollowedListDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowerDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersCountDTO;
import com.example.be_java_hisp_w21_g02.dto.response.FollowersListDTO;
import com.example.be_java_hisp_w21_g02.exceptions.OrderNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserFollowingException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotFoundException;
import com.example.be_java_hisp_w21_g02.exceptions.UserNotSellerException;
import com.example.be_java_hisp_w21_g02.model.Post;
import com.example.be_java_hisp_w21_g02.model.Product;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.repository.IUserRepository;
import com.example.be_java_hisp_w21_g02.service.UsersServiceImpl;
import com.example.be_java_hisp_w21_g02.utils.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.*;

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

    // Variables for Followers Lists
    private User user1;
    private User user2;
    private User user3;
    private User user4;
    private FollowersListDTO expectedFollowersListDTO;
    private FollowedListDTO expectedFollowedListDTO;

    @BeforeEach
    void setup() {
        user = new User(1, "Pedro", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        userToFollow = new User(2, "Martin", new HashSet<>(), new HashSet<>(), new ArrayList<>());
    }

    @Test
    @DisplayName("Unit Test US01 T-0001 01 - Follow existing user")
    void followUserTestUserToFollowExists() {
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));

        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Act
        _userService.followUser(user.getId(), userToFollow.getId());

        //Assert
        verify(_userRepository, atLeastOnce()).getUser(user.getId());
        verify(_userRepository, atLeastOnce()).persistFollows(user, userToFollow);

    }

    @Test
    @DisplayName("Unit Test US01 T-0001 02 - Follow non-existing user throws exception")
    void followUserTestUserToFollowDoesntExists() {
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(1)).thenReturn(user);
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> _userService.followUser(user.getId(), nonExistentUserId));
    }

    @Test
    @DisplayName("Unit Test US01 T-0001 03 - Follow user that is already followed throws exception")
    void followUserTestUserToFollowAlreadyBeingFollowed() {
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        _userService.followUser(user.getId(), userToFollow.getId());

        //Assert
        UserFollowingException userFollowingException =
                Assertions.assertThrows(UserFollowingException.class, () -> _userService.followUser(user.getId(), userToFollow.getId()));
        Assertions.assertEquals("This user is already following the user you want to follow", userFollowingException.getMessage());
    }

    @Test
    @DisplayName("Unit Test US01 T-0001 04 - Follow user that is not a seller throws exception")
    void followUserTestUserToFollowIsNotASeller() {
        //Arrange
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Act & Assert
        Assertions.assertThrows(UserNotSellerException.class, () -> _userService.followUser(user.getId(), userToFollow.getId()));
    }

    @Test
    @DisplayName("Unit Test US01 T-0001 05 - Follow myself throws exception")
    void followUserTestUserToFollowMyself() {
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));

        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Act & Assert
        UserFollowingException userFollowingException =
                Assertions.assertThrows(UserFollowingException.class, () -> _userService.followUser(userToFollow.getId(), userToFollow.getId()));
        Assertions.assertEquals("The user can't follow itself", userFollowingException.getMessage());

    }

    @Test
    @DisplayName("Unit Test US01 T-0001 06 - user who follows does not exist throws exception")
    void followUserTestUserWhoFollowsNotExists() {
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> _userService.followUser(nonExistentUserId, userToFollow.getId()));
    }

    @Test
    @DisplayName("Unit Test US07 T-0002 01 - Unfollow existing user")
    void unfollowUserTestUserToUnfollowExists() {
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));

        when(_userRepository.getUser(1)).thenReturn(user);
        when(_userRepository.getUser(2)).thenReturn(userToFollow);
        _userService.followUser(user.getId(), userToFollow.getId());

        //Act
        _userService.unFollowUser(user.getId(), userToFollow.getId());

        //Assert
        verify(_userRepository, atLeastOnce()).persistFollows(user, userToFollow);
    }

    @Test
    @DisplayName("Unit Test US07 T-0002 02 - UnFollow non-existing user throws exception")
    void unfollowUserTestUserToUnFollowDoesntExists() {
        //Arrange

        int nonExistentUserId = 3000;
        when(_userRepository.getUser(1)).thenReturn(user);
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> _userService.unFollowUser(user.getId(), nonExistentUserId));
    }

    @Test
    @DisplayName("Unit Test US07 T-0002 03 - UnFollow user that is not being followed throws exception")
    void unfollowUserTestUserToUnFollowNotBeingFollowed() {
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Assert
        UserFollowingException userFollowingException =
                Assertions.assertThrows(UserFollowingException.class, () -> _userService.unFollowUser(user.getId(), userToFollow.getId()));
        Assertions.assertEquals("This user is not following the user you want to unfollow", userFollowingException.getMessage());
    }

    @Test
    @DisplayName("Unit Test US07 T-0002 04 - unFollow user that is not a seller throws exception")
    void unfollowUserTestUserToUnFollowIsNotASeller() {
        //Arrange
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);

        //Act & Assert
        Assertions.assertThrows(UserNotSellerException.class, () -> _userService.unFollowUser(user.getId(), userToFollow.getId()));
    }

    @Test
    @DisplayName("Unit Test US07 T-0002 05 - user who unfollows does not exist throws exception")
    void unfollowUserTestUserWhoUnFollowsNotExists() {
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> _userService.unFollowUser(nonExistentUserId, userToFollow.getId()));
    }

    @Test
    @DisplayName("Unit Test US02 T-0007 01 - user with no followers gets 0 followers")
    void getFollowersCountTestWithNoFollowers() {
        //Arrange
        user.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        FollowersCountDTO expected = new FollowersCountDTO(user.getId(), user.getUsername(), 0);

        //Act
        FollowersCountDTO result = _userService.getFollowersCount(user.getId());

        // Assert
        Assertions.assertEquals(expected, result);
    }


    @Test
    @DisplayName("Unit Test US02 T-0007 02 - user with one follower gets 1 follower")
    void getFollowersCountTestWithOneFollower() {
        //Arrange
        userToFollow.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);
        when(_userRepository.getUser(userToFollow.getId())).thenReturn(userToFollow);
        _userService.followUser(user.getId(), userToFollow.getId());
        FollowersCountDTO expected = new FollowersCountDTO(userToFollow.getId(), userToFollow.getUsername(), 1);

        //Act
        FollowersCountDTO result = _userService.getFollowersCount(userToFollow.getId());

        //Assert
        Assertions.assertEquals(result, expected);
    }

    @Test
    @DisplayName("Unit Test US02 T-0007 03 - user is not a seller")
    void getFollowersCountTestUserIsNotSeller() {
        //Arrange
        when(_userRepository.getUser(user.getId())).thenReturn(user);

        //Act & Assert
        Assertions.assertThrows(UserNotSellerException.class, () -> _userService.getFollowersCount(user.getId()));
    }

    @Test
    @DisplayName("Unit Test US02 T-0007 04 - Non-existent user throws exception")
    void getFollowersCountTestUserDoesntExists() {
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> _userService.getFollowersCount(nonExistentUserId));
    }


    @Test
    @DisplayName("Unit Test US08 T-0003 01 - Asking for ascending order in followers list does not throw exception")
    void getFollowersListOrderAscendingExistsTest() {
        //Arrange
        user.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> _userService.getFollowersList(user.getId(), Constants.ORDER_NAME_ASC));
    }

    @Test
    @DisplayName("Unit Test US08 T-0003 02 - Asking for descending followers list order does not throw exception")
    void getFollowersListOrderDescendingExistsTest() {
        //Arrange
        user.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> _userService.getFollowersList(user.getId(), Constants.ORDER_NAME_DESC));
    }

    @Test
    @DisplayName("Unit Test US08 T-0003 03 - Non-existent user in followers list throws exception")
    void getFollowersListOrderTestUserDoesntExists() {
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> _userService.getFollowersList(nonExistentUserId, Constants.ORDER_NAME_ASC));
    }

    @Test
    @DisplayName("Unit Test US08 T-0003 04 - Asking for followers list without existent order")
    void getFollowersListOrderTestOrderDoesntExists() {
        //Arrange
        user.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));

        //Act & Assert
        Assertions.assertThrows(OrderNotFoundException.class, () -> _userService.getFollowersList(user.getId(), "wrong_order"));
    }

    @Test
    @DisplayName("Unit Test US08 T-0003 05 - Asking for ascending order in followed list does not throw exception")
    void getFollowedListOrderAscendingExistsTest() {
        //Arrange
        user.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> _userService.getFollowedList(user.getId(), Constants.ORDER_NAME_ASC));
    }

    @Test
    @DisplayName("Unit Test US08 T-0003 06 - Asking for descending followed list order does not throw exception")
    void getFollowedListOrderDescendingExistsTest() {
        //Arrange
        user.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));
        when(_userRepository.getUser(user.getId())).thenReturn(user);

        //Act & Assert
        Assertions.assertDoesNotThrow(() -> _userService.getFollowedList(user.getId(), Constants.ORDER_NAME_DESC));
    }

    @Test
    @DisplayName("Unit Test US08 T-0003 07 - Non-existent user in followed list throws exception")
    void getFollowedListOrderTestUserDoesntExists() {
        //Arrange
        int nonExistentUserId = 3000;
        when(_userRepository.getUser(nonExistentUserId)).thenReturn(null);

        //Act & Assert
        Assertions.assertThrows(UserNotFoundException.class, () -> _userService.getFollowedList(nonExistentUserId, Constants.ORDER_NAME_ASC));
    }

    @Test
    @DisplayName("Unit Test US08 T-0003 08 - Asking for followed list without existent order")
    void getFollowedListOrderTestOrderDoesntExists() {
        //Arrange
        user.setPosts(List.of(new Post(2, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));

        //Act & Assert
        Assertions.assertThrows(OrderNotFoundException.class, () -> _userService.getFollowedList(user.getId(), "wrong_order"));
    }


    private void createScenarioForLists(boolean isFollowedList) {

        // Creation of followers
        user1 = new User(2, "Charles", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        user2 = new User(3, "Shawn", new HashSet<>(), new HashSet<>(), new ArrayList<>());
        user3 = new User(4, "Peter", new HashSet<>(), new HashSet<>(), new ArrayList<>());

        // Creation of Seller User
        user4 = new User(5, "SellerUser",
                new HashSet<>(),
                new HashSet<>(),
                new ArrayList<>()
        );

        List<User> userList;
        if(isFollowedList){
            user1.setPosts(
                    List.of(new Post(user1.getId(), 1, LocalDate.now().minusDays(1), 3, 50D, new Product())
                    ));
            user2.setPosts(
                    List.of(new Post(user2.getId(), 1, LocalDate.now().minusDays(1), 3, 50D, new Product())
                    ));
            user3.setPosts(
                    List.of(new Post(user3.getId(), 1, LocalDate.now().minusDays(1), 3, 50D, new Product())
                    ));
            user4.setPosts(new ArrayList<>());

            userList = new ArrayList<>(List.of(user1, user2, user3));
            when(_userRepository.getUsers(Set.of(user1.getId(), user2.getId(), user3.getId())))
                    .thenReturn(userList);
            expectedFollowedListDTO = new FollowedListDTO(user4.getId(), user4.getUsername(), new ArrayList<>(
                    List.of(
                            new FollowerDTO(user1.getId(), user1.getUsername()),
                            new FollowerDTO(user2.getId(), user2.getUsername()),
                            new FollowerDTO(user3.getId(), user3.getUsername())
                    )
            ));
        }
        else{
            user4.setPosts(List.of(new Post(5, 1, LocalDate.now().minusDays(1), 3, 50D, new Product())));

            userList = new ArrayList<>(List.of(user1, user2, user3));
            when(_userRepository.getUsers(Set.of(user1.getId(), user2.getId(), user3.getId())))
                    .thenReturn(userList);
            expectedFollowersListDTO = new FollowersListDTO(user4.getId(), user4.getUsername(), new ArrayList<>(
                    List.of(
                            new FollowerDTO(user1.getId(), user1.getUsername()),
                            new FollowerDTO(user2.getId(), user2.getUsername()),
                            new FollowerDTO(user3.getId(), user3.getUsername())
                    )
            ));
        }

        when(_userRepository.getUser(user1.getId())).thenReturn(user1);
        when(_userRepository.getUser(user2.getId())).thenReturn(user2);
        when(_userRepository.getUser(user3.getId())).thenReturn(user3);
        when(_userRepository.getUser(user4.getId())).thenReturn(user4);



    }

    @Test
    @DisplayName("Unit Test US08 T-0004 01 - Asking for followers list with ascendant order")
    void getFollowersListOrderAscendantTest() {
        //Arrange
        createScenarioForLists(false);

        _userService.followUser(user1.getId(), user4.getId());
        _userService.followUser(user2.getId(), user4.getId());
        _userService.followUser(user3.getId(), user4.getId());

        // Act
        expectedFollowersListDTO.getFollowers().sort(Comparator.comparing(FollowerDTO::getUsername));

        FollowersListDTO result = _userService.getFollowersList(user4.getId(), Constants.ORDER_NAME_ASC);

        //Assert
        Assertions.assertEquals(expectedFollowersListDTO, result);
    }

    @Test
    @DisplayName("Unit Test US08 T-0004 02 - Asking for followers list with descendant order")
    void getFollowersListOrderDescendantTest() {
        //Arrange
        createScenarioForLists(false);

        _userService.followUser(user1.getId(), user4.getId());
        _userService.followUser(user2.getId(), user4.getId());
        _userService.followUser(user3.getId(), user4.getId());

        // Act
        expectedFollowersListDTO.getFollowers().sort(Comparator.comparing(FollowerDTO::getUsername).reversed());

        FollowersListDTO result = _userService.getFollowersList(user4.getId(), Constants.ORDER_NAME_DESC);

        //Assert
        Assertions.assertEquals(expectedFollowersListDTO, result);
    }

    @Test
    @DisplayName("Unit Test US08 T-0004 03 - Asking for followed list with ascendant order")
    void getFollowedListOrderAscendantTest() {
        //Arrange
        createScenarioForLists(true);
        _userService.followUser(user4.getId(), user1.getId());
        _userService.followUser(user4.getId(), user2.getId());
        _userService.followUser(user4.getId(), user3.getId());
        // Act
        expectedFollowedListDTO.getFollowed().sort(Comparator.comparing(FollowerDTO::getUsername));

        FollowedListDTO result = _userService.getFollowedList(user4.getId(), Constants.ORDER_NAME_ASC);

        //Assert
        Assertions.assertEquals(expectedFollowedListDTO, result);
    }

    @Test
    @DisplayName("Unit Test US08 T-0004 04 - Asking for followed list with descendant order")
    void getFollowedListOrderDescendantTest() {
        //Arrange
        createScenarioForLists(true);
        _userService.followUser(user4.getId(), user1.getId());
        _userService.followUser(user4.getId(), user2.getId());
        _userService.followUser(user4.getId(), user3.getId());
        // Act
        expectedFollowedListDTO.getFollowed().sort(Comparator.comparing(FollowerDTO::getUsername).reversed());

        FollowedListDTO result = _userService.getFollowedList(user4.getId(), Constants.ORDER_NAME_DESC);

        //Assert
        Assertions.assertEquals(expectedFollowedListDTO, result);
    }

}
