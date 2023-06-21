package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserAlreadyFollowedException;
import com.bootcamp.grupo3.socialmeli.exception.UserEqualsException;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    IUserRepository userRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    UserService underTest;

    UserFollowedListDTO userFollowedListDTOMock;

    User userMock;

    @BeforeEach
    void setUp() {
        userFollowedListDTOMock=mockUserFollowedListDTO();
        userMock=mockUser();
    }

    @Test
    @DisplayName("Follow happy path") void followOkTest() {
        //Arrange
        User user = new User(1,"Juan", new ArrayList<>(), new ArrayList<>());
        User userToFollow = new User(2,"Pedro", new ArrayList<>(), new ArrayList<>());
        MessageDTO expectedMessage = new MessageDTO("Juan siguió a Pedro correctamente!");

        //Act
        Mockito.when(userRepository.getUserByID(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.getUserByID(2)).thenReturn(Optional.of(userToFollow));
        MessageDTO resultMessege = underTest.follow(1, 2);
        //Assert
        assertEquals(expectedMessage, resultMessege);
    }

    @Test
    @DisplayName("AutoFollow sad path")
    void autofollowThrowExTest() {
        assertThrows(UserEqualsException.class, ()-> underTest.follow(1, 1));
    }

    @Test
    @DisplayName("Follow sad path - already following the user")
    void follow_alreadyFollowing_ThrowExTest() {
        //Arrange
        User userToFollow = new User(2,"Pedro", new ArrayList<>(), new ArrayList<>());
        User user = new User(1,"Juan", new ArrayList<>(), Arrays.asList(userToFollow));

        //Act
        Mockito.when(userRepository.getUserByID(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepository.getUserByID(2)).thenReturn(Optional.of(userToFollow));

        //Assert
        assertThrows(UserAlreadyFollowedException.class, ()->underTest.follow(1,2));
    }

    @Test
    @DisplayName("Follow sad path - userToFollow doesn't exist")
    void follow_userToFollowDoesntExist_ThrowExTest() {
        //Arrange
        User user = new User(1,"Juan", new ArrayList<>(), new ArrayList<>());

        //Act
        Mockito.when(userRepository.getUserByID(1)).thenReturn(Optional.of(user));

        //Assert
        assertThrows(UserNotFoundException.class, ()->underTest.follow(1,2));
    }
    @Test
    @DisplayName("Follow sad path - user doesn't exist")
    void follow_userDoesntExist_ThrowExTest() {
        //Arrange
        User userToFollow = new User(2,"Pedro", new ArrayList<>(), new ArrayList<>());

        //Act
        //Assert
        assertThrows(UserNotFoundException.class, ()->underTest.follow(1,2));
    }

    @Test
    @DisplayName("unfollow happy path")
    void unfollow_userExists_returnsValidMessage() {
        Mockito.when(userRepository.getUserByID(1))
                .thenReturn(Optional.of(userMock));

        userMock.getFollowed().get(0).getFollowers().add(userMock);

        Mockito.when(userRepository.getUserByID(2))
                .thenReturn(Optional.of(userMock.getFollowed().get(0)));

        String expectedMessage= userMock.getName()+" dejo de seguir a " + userMock.getFollowed().get(0).getName() + " correctamente!";

        MessageDTO messageDTORespoonse = underTest.unfollow(1, 2);

        assertEquals(messageDTORespoonse.getMessage(),expectedMessage);
    }

    @Test
    @DisplayName("unfollow user doesn't exists")
    void unfollow_userDoesntExists_throwsException() {

        assertThrows(UserNotFoundException.class,
                ()->underTest.unfollow(1,2));
    }

    @Test
    @DisplayName("unfollow user is not followed path")
    void unfollow_userExists_butDontFollow() {
        User user=userMock.getFollowed().get(0);

        userMock.getFollowed().remove(1);
        userMock.getFollowed().remove(0);

        Mockito.when(userRepository.getUserByID(1))
                .thenReturn(Optional.of(userMock));

        Mockito.when(userRepository.getUserByID(2))
                .thenReturn(Optional.of(user));

        assertThrows(UserNotFoundException.class,
                ()->underTest.unfollow(1,2));
    }

    @Test
    @DisplayName("unfollow user id equals exception")
    void unfollow_userIdEquals_throwsException() {
        assertThrows(UserEqualsException.class,
                ()-> underTest.unfollow(1,1));
    }

    @Test
    void getFollowers() {
    }

    @Test
    void userExists() {
    }

    @Test
    void getFollowedByUser() {
    }

    @Test
    void getUserFollowersCount() {

    }


    private UserFollowedListDTO mockUserFollowedListDTO(){
        UserDTO userDTO = new UserDTO(2,"Juan");
        UserDTO userDTO2 = new UserDTO(3,"Martin");
        return new UserFollowedListDTO(1,"Renata",Arrays.asList(userDTO,userDTO2));
    }

    private User mockUser(){
        User followed1= new User(2,"Juan",new ArrayList<>(),new ArrayList<>());
        User followed2= new User(3,"Martin",new ArrayList<>(),new ArrayList<>());
        return new User(1,"Renata",new ArrayList<>(Arrays.asList()),new ArrayList<>(Arrays.asList(followed1,followed2)));
    }
}