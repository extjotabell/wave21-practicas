package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.response.UserDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowersListDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserAlreadyFollowedException;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.UserRepository;
import com.google.common.collect.Comparators;
import org.junit.jupiter.api.Assertions;
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
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class UserServiceTest {
    @Mock
    UserRepository userRepo;

    @InjectMocks
    UserService service;

    @Spy
    ModelMapper mapper;

    User ramiro;
    User nauhel;
    User juansito;
    User lucho;
    User fabri;
    User orne;
    UserFollowedListDTO userFollowedListDTOMock;
    User userMock;

    @BeforeEach
    void setUp() {
        init_test_003_004();
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
        Mockito.when(userRepo.getUserByID(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepo.getUserByID(2)).thenReturn(Optional.of(userToFollow));
        MessageDTO resultMessege = service.follow(1, 2);

        //Assert
        assertEquals(expectedMessage, resultMessege);
    }

    @Test
    @DisplayName("AutoFollow sad path")
    void autofollowThrowExTest() {
        assertThrows(UserEqualsException.class, ()-> service.follow(1, 1));
    }

    @Test
    @DisplayName("Follow sad path - already following the user")
    void follow_alreadyFollowing_ThrowExTest() {
        //Arrange
        User userToFollow = new User(2,"Pedro", new ArrayList<>(), new ArrayList<>());
        User user = new User(1,"Juan", new ArrayList<>(), Arrays.asList(userToFollow));

        //Act
        Mockito.when(userRepo.getUserByID(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepo.getUserByID(2)).thenReturn(Optional.of(userToFollow));

        //Assert
        assertThrows(UserAlreadyFollowedException.class, ()->service.follow(1,2));
    }

    @Test
    @DisplayName("Follow sad path - userToFollow doesn't exist")
    void follow_userToFollowDoesntExist_ThrowExTest() {
        //Arrange
        User user = new User(1,"Juan", new ArrayList<>(), new ArrayList<>());

        //Act
        Mockito.when(userRepo.getUserByID(1)).thenReturn(Optional.of(user));

        //Assert
        assertThrows(UserNotFoundException.class, ()->service.follow(1,2));
    }
    @Test
    @DisplayName("Follow sad path - user doesn't exist")
    void follow_userDoesntExist_ThrowExTest() {
        //Arrange
        User userToFollow = new User(2,"Pedro", new ArrayList<>(), new ArrayList<>());

        //Act
        //Assert
        assertThrows(UserNotFoundException.class, ()->service.follow(1,2));
    }

    @Test
    @DisplayName("unfollow happy path")
    void unfollow_userExists_returnsValidMessage() {
        //Arrange
        Mockito.when(userRepo.getUserByID(1))
                .thenReturn(Optional.of(userMock));

        userMock.getFollowed().get(0).getFollowers().add(userMock);

        Mockito.when(userRepo.getUserByID(2))
                .thenReturn(Optional.of(userMock.getFollowed().get(0)));

        //Act
        String expectedMessage= userMock.getName()+" dejo de seguir a " + userMock.getFollowed().get(0).getName() + " correctamente!";

        //Assert
        MessageDTO messageDTORespoonse = service.unfollow(1, 2);

        assertEquals(messageDTORespoonse.getMessage(),expectedMessage);
    }

    @Test
    @DisplayName("unfollow user doesn't exists")
    void unfollow_userDoesntExists_throwsException() {

        assertThrows(UserNotFoundException.class,
                ()->service.unfollow(1,2));
    }

    @Test
    @DisplayName("unfollow user is not followed path")
    void unfollow_userExists_butDontFollow() {
        //Arrange
        User user=userMock.getFollowed().get(0);

        userMock.getFollowed().remove(1);
        userMock.getFollowed().remove(0);

        Mockito.when(userRepo.getUserByID(1))
                .thenReturn(Optional.of(userMock));

        Mockito.when(userRepo.getUserByID(2))
                .thenReturn(Optional.of(user));

        //Act && Assert
        assertThrows(UserNotFoundException.class,
                ()->service.unfollow(1,2));
    }

    @Test
    @DisplayName("unfollow user id equals exception")
    void unfollow_userIdEquals_throwsException() {
        assertThrows(UserEqualsException.class,
                ()-> service.unfollow(1,1));
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

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Permite continuar con normalidad, con seguidos")
    void getFollowedTest(){
        /*Los seguidores de Ramiro son Juansito, Lucho y Fabri*/
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowedListDTO listaObtenida = service.getFollowed(ramiro.getId(), "");

        //Assert
        assertEquals(ramiro.getId(),listaObtenida.getId());
        assertEquals(ramiro.getName(),listaObtenida.getName());
        assertEquals(juansito.getName(),listaObtenida.getFollowed().get(0).getName());
        assertEquals(fabri.getName(),listaObtenida.getFollowed().get(2).getName());
    }

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Permite continuar con normalidad con seguidores")
    void getFollowersTest(){
        /*Los seguidos por Ramiro son nahuel, Lucho y Fabri*/
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowersListDTO listaObtenida = service.getFollowers(ramiro.getId(), "");

        //Assert
        assertEquals(ramiro.getId(),listaObtenida.getId());
        assertEquals(ramiro.getName(),listaObtenida.getName());
        assertEquals(nauhel.getName(),listaObtenida.getFollowers().get(0).getName());
        assertEquals(fabri.getName(),listaObtenida.getFollowers().get(2).getName());
    }

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Usuario invalido en follower")
    void getFollowersTestByInvalidUser(){
        /*Usuario Invalido*/
        //Arrange
        int idInvalido = 555;
        Mockito.when(userRepo.getUserByID(idInvalido)).thenReturn(Optional.empty());

        //Act && Assert
        assertThrows(UserNotFoundException.class, ()-> service.getFollowers(idInvalido, ""));

    }

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Usuario invalido en followed")
    void getFollowedTestByInvalidUser(){
        /*Usuario Invalido*/
        //Arrange
        int idInvalido = 555;
        Mockito.when(userRepo.getUserByID(idInvalido)).thenReturn(Optional.empty());

        //Act && Assert
        assertThrows(UserNotFoundException.class, ()-> service.getFollowed(idInvalido, ""));

    }

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Permite continuar con normalidad, sin seguidos")
    void getEmptyFollowedTest(){
        /*Orne no sigue a nadie*/
        //Arrange
        Mockito.when(userRepo.getUserByID(orne.getId())).thenReturn(Optional.of(orne));

        //Act
        UserFollowedListDTO listaObtenida = service.getFollowed(orne.getId(), "");

        //Assert
        Assertions.assertTrue(listaObtenida.getFollowed().isEmpty());

    }

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Permite continuar con normalidad sin seguidos")
    void getEmptyFollowersTest(){
        /*Nadie sigue a orne :(*/
        //Arrange
        Mockito.when(userRepo.getUserByID(orne.getId())).thenReturn(Optional.of(orne));

        //Act
        UserFollowersListDTO listaObtenida = service.getFollowers(orne.getId(), "");

        //Assert
        Assertions.assertTrue(listaObtenida.getFollowers().isEmpty());

    }


    @Test
    @DisplayName("T004- Devuelve la lista ordenada según el criterio solicitado - FOLLOWED NAME ASC")
    void getFollowedTestByNameASC(){
        /* La lista de los seguidores de Ramiro quedaria Fabri, Juansito, Lucho*/
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowedListDTO listaObtenida = service.getFollowed(ramiro.getId(), "name_asc");

        //Assert
        assertEquals(ramiro.getId(),listaObtenida.getId());
        assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertTrue(Comparators.isInOrder(listaObtenida.getFollowed(),Comparator.naturalOrder()));
    }

    @Test
    @DisplayName("T004- Devuelve la lista ordenada según el criterio solicitado - FOLLOWED NAME DESC")
    void getFollowedTestByNameDESC(){
        /* La lista de los seguidores de Ramiro quedaria Lucho, Juansito, Fabri*/
        /*Arrange*/
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));
        /*Act*/
        UserFollowedListDTO listaObtenida = service.getFollowed(ramiro.getId(), "name_desc");
        /*Assertion*/
        assertEquals(ramiro.getId(),listaObtenida.getId());
        assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertTrue(Comparators.isInOrder(listaObtenida.getFollowed(),Comparator.reverseOrder()));

        /*
        Assertions.assertEquals(lucho.getName(),listaObtenida.getFollowed().get(0).getName());
        Assertions.assertEquals(fabri.getName(),listaObtenida.getFollowed().get(2).getName());*/
    }



    @Test
    @DisplayName("T004- Devuelve la lista ordenada según el criterio solicitado - FOLLOWERS NAME ASC")
    void getFollowersTestByNameASC(){
        /*La lista  de los seguidos por Ramiro quedaria Fabri , Lucho, Nauhel */
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowersListDTO listaObtenida = service.getFollowers(ramiro.getId(), "name_asc");

        //Assert
        assertEquals(ramiro.getId(),listaObtenida.getId());
        assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertTrue(Comparators.isInOrder(listaObtenida.getFollowers(),Comparator.naturalOrder()));
    }

    @Test
    @DisplayName("T004- Devuelve la lista ordenada según el criterio solicitado - FOLLOWERS NAME DESC")
    void getFollowersTestByNameDESC(){

        /*La lista  de los seguidos por Ramiro quedaria Nauhel , Lucho , Fabri */
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowersListDTO listaObtenida = service.getFollowers(ramiro.getId(), "name_desc");

        //Assert
        assertEquals(ramiro.getId(),listaObtenida.getId());
        assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertTrue(Comparators.isInOrder(listaObtenida.getFollowers(),Comparator.reverseOrder()));
    }


    void init_test_003_004 (){
        ramiro = new User(1, "Ramiro", new ArrayList<>(), new ArrayList<>());
        nauhel = new User(2, "nauhel", new ArrayList<>(), new ArrayList<>());
        juansito = new User(3, "juancito", new ArrayList<>(), new ArrayList<>());
        lucho = new User(4, "luchoDelCampo", new ArrayList<>(), new ArrayList<>());
        fabri = new User(5, "Fabri", new ArrayList<>(), new ArrayList<>());
        orne = new User(6, "Orne", new ArrayList<>(), new ArrayList<>());

        List<User> followers = new ArrayList<>();
        List<User> followed = new ArrayList<>();
        followed.add(juansito);
        followed.add(lucho);
        followed.add(fabri);
        ramiro.setFollowed(followed);
        followers.add(nauhel);
        followers.add(lucho);
        followers.add(fabri);
        ramiro.setFollowers(followers);
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