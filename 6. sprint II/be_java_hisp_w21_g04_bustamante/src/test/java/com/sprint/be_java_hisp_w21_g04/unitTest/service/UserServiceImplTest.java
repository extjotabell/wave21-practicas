package com.sprint.be_java_hisp_w21_g04.unitTest.service;
import com.sprint.be_java_hisp_w21_g04.dto.response.*;
import com.sprint.be_java_hisp_w21_g04.entity.User;
import com.sprint.be_java_hisp_w21_g04.exception.*;
import com.sprint.be_java_hisp_w21_g04.repository.user.UserRepositoryImpl;
import com.sprint.be_java_hisp_w21_g04.service.user.UserServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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
    @DisplayName("T0003-Validando el ordenamiento ascendente por la cantidad de seguidos")
    public void getFollowedByIdSortedTestFollowedCountAsc(){

        //Arrange
        int userId = 4;

        List<Integer> idFollowed = Arrays.asList(5,3);

        User followed1 = new User(5,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        User followed2 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        User followed3 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        FollowedResponseDto followedResponseDto = new FollowedResponseDto(4,"EmilyDavis", Arrays.asList(new UserResponseDto(5,"DavidWilson"),
                new UserResponseDto(3,"MikeJohnson")));

        int expectedResult = followedResponseDto.getFollowed().size();

        when(userRepository.getFollowedById(userId)).thenReturn(idFollowed);
        when(userRepository.getById(anyInt()))
                .thenReturn(followed1)
                .thenReturn(followed2)
                .thenReturn(followed3);

        //Act
        int result1 = userService.getFollowedByIdSorted(userId,"name_asc").getFollowed().size();

        //Assert
        assertEquals(expectedResult,result1);

    }

    @Test
    @DisplayName("T0003-Validando el ordenamiento descendente por la cantidad de seguidos")
    public void getFollowedByIdSortedTestFollowedCountDesc(){

        //Arrange
        int userId = 4;

        List<Integer> idFollowed = Arrays.asList(5,3);

        User followed1 = new User(5,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        User followed2 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        User followed3 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        FollowedResponseDto followedResponseDto = new FollowedResponseDto(4,"EmilyDavis", Arrays.asList(new UserResponseDto(5,"DavidWilson"),
                new UserResponseDto(3,"MikeJohnson")));

        int expectedResult = followedResponseDto.getFollowed().size();

        when(userRepository.getFollowedById(userId)).thenReturn(idFollowed);
        when(userRepository.getById(anyInt()))
                .thenReturn(followed1)
                .thenReturn(followed2)
                .thenReturn(followed3);

        //Act
        int result2 = userService.getFollowedByIdSorted(userId,"name_desc").getFollowed().size();

        //Assert
        assertEquals(expectedResult,result2);

    }

    @Test
    @DisplayName("T0003-Validando el ordenamiento ascendente por la cantidad de seguidores")
    public void getFollowersByIdSortedTestFollowersCountAsc(){

        //Arrange
        int userId = 3;

        List<Integer> idFollowers = Arrays.asList(7,4);

        User follower1 = new User(7,"JacobBrown",new ArrayList<>(),new ArrayList<>());
        User follower2 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        User follower3 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        FollowersResponseDto followersResponseDto = new FollowersResponseDto(3,"MikeJohnson", Arrays.asList(new UserResponseDto(4,"EmilyDavis"),
                new UserResponseDto(7,"JacobBrown")));

        int expectedResult = followersResponseDto.getFollowers().size();

        when(userRepository.getFollowersById(userId)).thenReturn(idFollowers);
        when(userRepository.getById(anyInt()))
                .thenReturn(follower1)
                .thenReturn(follower2)
                .thenReturn(follower3);

        //Act
        int result1 = userService.getFollowersByIdSorted(userId,"name_asc").getFollowers().size();

        //Assert
        assertEquals(expectedResult,result1);
    }

    @Test
    @DisplayName("T0003-Validando el ordenamiento descendente por la cantidad de seguidores")
    public void getFollowersByIdSortedTestFollowersSortCountDesc(){

        //Arrange
        int userId = 3;

        List<Integer> idFollowers = Arrays.asList(7,4);

        User follower1 = new User(7,"JacobBrown",new ArrayList<>(),new ArrayList<>());
        User follower2 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        User follower3 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        FollowersResponseDto followersResponseDto = new FollowersResponseDto(3,"MikeJohnson", Arrays.asList(new UserResponseDto(4,"EmilyDavis"),
                new UserResponseDto(7,"JacobBrown")));

        int expectedResult = followersResponseDto.getFollowers().size();

        when(userRepository.getFollowersById(userId)).thenReturn(idFollowers);
        when(userRepository.getById(anyInt()))
                .thenReturn(follower1)
                .thenReturn(follower2)
                .thenReturn(follower3);

        //Act
        int result2 = userService.getFollowersByIdSorted(userId,"name_desc").getFollowers().size();

        //Assert
        assertEquals(expectedResult,result2);
    }

    @Test
    @DisplayName("T0003-Obteniendo lista de seguidos de un usuario por id con orden correcto")
    public void getFollowedByIdSortedTestFollowedSortCorrect(){

        //Arrange
        int userId = 4;

        List<Integer> idFollowed = Arrays.asList(5,3);

        User followed1 = new User(5,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        User followed2 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        User followed3 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        FollowedResponseDto expectedResult = new FollowedResponseDto(4,"EmilyDavis", Arrays.asList(new UserResponseDto(5,"DavidWilson"),
                new UserResponseDto(3,"MikeJohnson")));

        when(userRepository.getFollowedById(userId)).thenReturn(idFollowed);
        when(userRepository.getById(anyInt()))
                .thenReturn(followed1)
                .thenReturn(followed2)
                .thenReturn(followed3);

        //Act

        //Assert
        assertDoesNotThrow(() -> userService.getFollowedByIdSorted(userId,"name_asc"));
        assertDoesNotThrow(() -> userService.getFollowedByIdSorted(userId,"name_desc"));
    }

    @Test
    @DisplayName("T0003-Obteniendo lista de seguidos de un usuario por id con orden erroneo")
    public void getFollowedByIdSortedTestFollowedSortError(){

        //Arrange
        int userId = 3;

        //Act

        //Assert
        assertThrows(IllegalDataException.class, () -> userService.getFollowedByIdSorted(userId,"name_"));
    }

    @Test
    @DisplayName("T0003-Obteniendo lista de seguidores de un usuario por id con orden erroneo")
    public void getFollowersByIdSortedTestFollowersSortCorrect(){

        //Arrange
        int userId = 3;

        List<Integer> idFollowers = Arrays.asList(7,4);

        User follower1 = new User(7,"JacobBrown",new ArrayList<>(),new ArrayList<>());
        User follower2 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        User follower3 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        FollowersResponseDto expectedResult = new FollowersResponseDto(3,"MikeJohnson", Arrays.asList(new UserResponseDto(4,"EmilyDavis"),
                new UserResponseDto(7,"JacobBrown")));

        when(userRepository.getFollowersById(userId)).thenReturn(idFollowers);
        when(userRepository.getById(anyInt()))
                .thenReturn(follower1)
                .thenReturn(follower2)
                .thenReturn(follower3);

        //Act

        //Assert
        assertDoesNotThrow( () -> userService.getFollowersByIdSorted(userId,"name_asc"));
        assertDoesNotThrow( () -> userService.getFollowersByIdSorted(userId,"name_desc"));
    }

    @Test
    @DisplayName("T0003-Obteniendo lista de seguidores de un usuario por id con orden erroneo")
    public void getFollowersByIdSortedTestFollowersSortError(){

        //Arrange
        int userId = 3;

        //Act

        //Assert
        assertThrows(IllegalDataException.class, () -> userService.getFollowersByIdSorted(userId,"name_"));
    }

    @Test
    @DisplayName("T0004-Obteniendo lista de seguidos de un usuario por id con orden ascendente")
    public void getFollowedByIdSortedTestFollowedAsc() {

        //Arrange
        int userId = 4;

        List<Integer> idFollowed = Arrays.asList(5,3);

        User followed1 = new User(5,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        User followed2 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        User followed3 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        FollowedResponseDto expectedResult = new FollowedResponseDto(4,"EmilyDavis", Arrays.asList(new UserResponseDto(5,"DavidWilson"),
                new UserResponseDto(3,"MikeJohnson")));

        when(userRepository.getFollowedById(userId)).thenReturn(idFollowed);
        when(userRepository.getById(anyInt()))
                .thenReturn(followed1)
                .thenReturn(followed2)
                .thenReturn(followed3);

        //Act
        FollowedResponseDto result = userService.getFollowedByIdSorted(userId,"name_asc");

        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    @DisplayName("T0004-Obteniendo lista de seguidos de un usuario por id con orden descendente")
    public void getFollowedByIdSortedTestFollowedDesc() {

        //Arrange
        int userId = 4;

        List<Integer> idFollowed = Arrays.asList(5,3);

        User followed1 = new User(5,"DavidWilson",new ArrayList<>(),new ArrayList<>());
        User followed2 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        User followed3 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        FollowedResponseDto expectedResult = new FollowedResponseDto(4,"EmilyDavis", Arrays.asList(new UserResponseDto(3,"MikeJohnson"),
                new UserResponseDto(5,"DavidWilson")));

        when(userRepository.getFollowedById(userId)).thenReturn(idFollowed);
        when(userRepository.getById(anyInt()))
                .thenReturn(followed1)
                .thenReturn(followed2)
                .thenReturn(followed3);

        //Act
        FollowedResponseDto result = userService.getFollowedByIdSorted(userId,"name_desc");

        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    @DisplayName("T0004-Obteniendo lista de seguidores de un usuario por id con orden ascendente")
    public void getFollowersByIdSortedTestFollowersAsc() {

        //Arrange
        int userId = 3;

        List<Integer> idFollowers = Arrays.asList(7,4);

        User follower1 = new User(7,"JacobBrown",new ArrayList<>(),new ArrayList<>());
        User follower2 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        User follower3 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());
        FollowersResponseDto expectedResult = new FollowersResponseDto(3,"MikeJohnson", Arrays.asList(new UserResponseDto(4,"EmilyDavis"),
                new UserResponseDto(7,"JacobBrown")));

        when(userRepository.getFollowersById(userId)).thenReturn(idFollowers);
        when(userRepository.getById(anyInt()))
                .thenReturn(follower1)
                .thenReturn(follower2)
                .thenReturn(follower3);

        //Act
        FollowersResponseDto result = userService.getFollowersByIdSorted(userId,"name_asc");

        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    @DisplayName("T0004-Obteniendo lista de seguidores de un usuario por id con orden descendente")
    public void getFollowersByIdSortedTestFollowersDesc() {

        //Arrange
        int userId = 3;

        List<Integer> idFollowers = Arrays.asList(7,4);
        User follower1 = new User(7,"JacobBrown",new ArrayList<>(),new ArrayList<>());
        User follower2 = new User(4,"EmilyDavis",new ArrayList<>(),new ArrayList<>());
        User follower3 = new User(3,"MikeJohnson",new ArrayList<>(),new ArrayList<>());

        FollowersResponseDto expectedResult = new FollowersResponseDto(3,"MikeJohnson", Arrays.asList(new UserResponseDto(7,"JacobBrown"),
                new UserResponseDto(4,"EmilyDavis")));

        when(userRepository.getFollowersById(userId)).thenReturn(idFollowers);
        when(userRepository.getById(anyInt()))
                .thenReturn(follower1)
                .thenReturn(follower2)
                .thenReturn(follower3);

        //Act
        FollowersResponseDto result = userService.getFollowersByIdSorted(userId,"name_desc");

        //Assert
        assertEquals(expectedResult,result);
    }

    @Test
    @DisplayName("T0004-Lanzando Excepcion cuando el usuario no existe en seguidos")
    public void getFollowedByIdSortedTestFollowedUserNotFound(){

        //Arrange
        int userId = 30;

        when(userRepository.getFollowedById(userId)).thenThrow(new IllegalDataException("Usuario no registrado"));

        //Act

        //Assert
        assertThrows(IllegalDataException.class, () -> userService.getFollowedByIdSorted(userId,"name_asc"));
    }

    @Test
    @DisplayName("T0004-Lanzando Excepcion cuando el usuario no existe en seguidores")
    public void getFollowersByIdSortedTestFollowedUserNotFound(){

        //Arrange
        int userId = 30;
        when(userRepository.getFollowersById(userId)).thenThrow(new IllegalDataException("Vendedor no registrado"));

        //Act

        //Assert
        assertThrows(IllegalDataException.class, () -> userService.getFollowersByIdSorted(userId,"name_asc"));
    }

    @Test
    @DisplayName("T0004-Lanzando Excepcion cuando el vendedor no tiene seguidos")
    public void getFollowedByIdSortedTestUserHasNoFollowed(){

        //Arrange
        int userId = 3;

        List<Integer> followed = new ArrayList<>();
        when(userRepository.getFollowedById(userId)).thenReturn(followed);

        //Act

        //Assert
        assertThrows(NotFoundException.class, () -> userService.getFollowedByIdSorted(userId,"name_asc"));
    }

    @Test
    @DisplayName("T0004-Lanzando Excepcion cuando el vendedor no tiene seguidores")
    public void getFollowersByIdSortedTestUserHasNoFollowers(){

        //Arrange
        int userId = 3;

        List<Integer> followers = new ArrayList<>();
        when(userRepository.getFollowersById(userId)).thenReturn(followers);

        //Act

        //Assert
        assertThrows(NotFoundException.class, () -> userService.getFollowersByIdSorted(userId,"name_asc"));
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


    @Test
    @DisplayName("T0009 - Caso ideal donde se consigue la lista de seguidores de un usuario")
    public void getFollowersByIdPerfectCase() {
        // Arrange
        int userId = 1;
        User user1 = new User(1,"DavidWilson",new ArrayList<>(), new ArrayList<>());
        List<Integer> followerIds = new ArrayList<>();
        followerIds.add(2);
        followerIds.add(3);

        when(userRepository.getFollowersById(userId)).thenReturn(followerIds);
        when(userRepository.getById(anyInt())).thenReturn(user1);


        // Act
        FollowersResponseDto result = userService.getFollowersById(userId);

        // Assert
        Assertions.assertEquals(userId, result.getUserId());
        Assertions.assertEquals(user1.getUserName(), result.getUserName());
        Assertions.assertEquals(2, result.getFollowers().size());

    }
}