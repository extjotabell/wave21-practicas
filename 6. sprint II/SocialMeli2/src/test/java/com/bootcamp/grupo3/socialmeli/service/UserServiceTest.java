package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.response.MessageDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowedListDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowerCountDTO;
import com.bootcamp.grupo3.socialmeli.dto.response.UserFollowersListDTO;
import com.bootcamp.grupo3.socialmeli.exception.UserAlreadyFollowedException;
import com.bootcamp.grupo3.socialmeli.exception.UserEqualsException;
import com.bootcamp.grupo3.socialmeli.exception.UserNotFoundException;
import com.bootcamp.grupo3.socialmeli.model.User;
import com.bootcamp.grupo3.socialmeli.repository.UserRepository;
import com.google.common.collect.Comparators;
import org.junit.jupiter.api.Assertions;
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

import java.util.*;

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

    @BeforeEach
    void setUp() {
        init();
    }

    @Test
    @DisplayName("T-0001 / Verificar que el usuario a seguir exista. (US-0001) / Permite continuar con normalidad.")
    void followOkTest() {
        //Arrange
        User user = ramiro;
        User userToFollow = orne;
        MessageDTO expectedMessage = new MessageDTO("Ramiro siguió a Orne correctamente!");

        //Act
        Mockito.when(userRepo.getUserByID(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepo.getUserByID(2)).thenReturn(Optional.of(userToFollow));
        MessageDTO resultMessage = service.follow(1, 2);

        //Assert
        assertEquals(expectedMessage, resultMessage);
    }

    @Test
    @DisplayName("T-0001 / Verificar que el usuario a seguir exista. (US-0001) / No permite auto follow")
    void autoFollowThrowExTest() {
        assertThrows(UserEqualsException.class, () -> service.follow(1, 1));
    }

    @Test
    @DisplayName("T-0001 / Verificar que el usuario a seguir exista. (US-0001) / No permite re seguir")
    void follow_alreadyFollowing_ThrowExTest() {
        //Arrange
        User userToFollow = new User(2, "Pedro", new ArrayList<>(), new ArrayList<>());
        User user = new User(1, "Juan", new ArrayList<>(), Arrays.asList(userToFollow));

        //Act
        Mockito.when(userRepo.getUserByID(1)).thenReturn(Optional.of(user));
        Mockito.when(userRepo.getUserByID(2)).thenReturn(Optional.of(userToFollow));

        //Assert
        assertThrows(UserAlreadyFollowedException.class, () -> service.follow(1, 2));
    }

    @Test
    @DisplayName("T-0001 / Verificar que el usuario a seguir exista. (US-0001) / Usuario a seguir no existe")
    void follow_userToFollowDoesntExist_ThrowExTest() {
        //Arrange
        User user = new User(1, "Juan", new ArrayList<>(), new ArrayList<>());

        //Act
        Mockito.when(userRepo.getUserByID(1)).thenReturn(Optional.of(user));

        //Assert
        assertThrows(UserNotFoundException.class, () -> service.follow(1, 2));
    }

    @Test
    @DisplayName("T-0001 / Verificar que el usuario a seguir exista. (US-0001) / Usuario no existe")
    void follow_userDoesntExist_ThrowExTest() {
        //Arrange
        User userToFollow = new User(2, "Pedro", new ArrayList<>(), new ArrayList<>());

        //Act
        //Assert
        assertThrows(UserNotFoundException.class, () -> service.follow(1, 2));
    }

    @Test
    @DisplayName("T-0002 / Verificar que el usuario a dejar de seguir exista. (US-0007) / Permite continuar con normalidad.")
    void unfollow_userExists_returnsValidMessage() {
        //Arrange
        Mockito.when(userRepo.getUserByID(1))
                .thenReturn(Optional.of(ramiro));

        ramiro.getFollowed().get(0).getFollowers().add(ramiro);

        Mockito.when(userRepo.getUserByID(2))
                .thenReturn(Optional.of(ramiro.getFollowed().get(0)));

        //Act
        String expectedMessage = ramiro.getName() + " dejo de seguir a " + ramiro.getFollowed().get(0).getName() + " correctamente!";

        //Assert
        MessageDTO messageDTOResponse = service.unfollow(1, 2);
        assertEquals(expectedMessage, messageDTOResponse.getMessage());
    }

    @Test
    @DisplayName("T-0002 / Verificar que el usuario a dejar de seguir exista. (US-0007) / Usuario no existe")
    void unfollow_userDoesntExists_throwsException() {

        assertThrows(UserNotFoundException.class,
                () -> service.unfollow(1, 2));
    }

    @Test
    @DisplayName("T-0002 / Verificar que el usuario a dejar de seguir exista. (US-0007) / No permite unfollow sin follow previo")
    void unfollow_userExists_butDontFollow() {
        //Arrange
        User user = ramiro.getFollowed().get(0);

        ramiro.getFollowed().remove(1);
        ramiro.getFollowed().remove(0);

        Mockito.when(userRepo.getUserByID(1))
                .thenReturn(Optional.of(ramiro));

        Mockito.when(userRepo.getUserByID(2))
                .thenReturn(Optional.of(user));

        //Act && Assert
        assertThrows(UserNotFoundException.class,
                () -> service.unfollow(1, 2));
    }

    @Test
    @DisplayName("T-0002 / Verificar que el usuario a dejar de seguir exista. (US-0007) / No permite auto unfollow")
    void unfollow_userIdEquals_throwsException() {
        assertThrows(UserEqualsException.class,
                () -> service.unfollow(1, 1));
    }

    @Test
    @DisplayName("T-0003 / Verificar que el tipo de ordenamiento alfabético exista (US-0008) / Permite continuar con normalidad, con seguidos")
    void getFollowedTest() {
        /*Los seguidores de Ramiro son Juansito, Lucho y Fabri*/
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowedListDTO resultList = service.getFollowed(ramiro.getId(), "");

        //Assert
        assertEquals(ramiro.getId(), resultList.getId());
        assertEquals(ramiro.getName(), resultList.getName());
        assertEquals(juansito.getName(), resultList.getFollowed().get(0).getName());
        assertEquals(fabri.getName(), resultList.getFollowed().get(2).getName());
    }

    @Test
    @DisplayName("T-0003 / Verificar que el tipo de ordenamiento alfabético exista (US-0008) / Permite continuar con normalidad con seguidores")
    void getFollowersTest() {
        /*Los seguidos por Ramiro son nahuel, Lucho y Fabri*/
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowersListDTO resultList = service.getFollowers(ramiro.getId(), "");

        //Assert
        assertEquals(ramiro.getId(), resultList.getId());
        assertEquals(ramiro.getName(), resultList.getName());
        assertEquals(nauhel.getName(), resultList.getFollowers().get(0).getName());
        assertEquals(fabri.getName(), resultList.getFollowers().get(2).getName());
    }

    @Test
    @DisplayName("T-0003 / Verificar que el tipo de ordenamiento alfabético exista (US-0008) / Usuario no existe en followers")
    void getFollowersTestByInvalidUser() {
        /*Usuario Invalido*/
        //Arrange
        int invalidId = 555;
        Mockito.when(userRepo.getUserByID(invalidId)).thenReturn(Optional.empty());

        //Act && Assert
        assertThrows(UserNotFoundException.class, () -> service.getFollowers(invalidId, ""));

    }

    @Test
    @DisplayName("T-0003 / Verificar que el tipo de ordenamiento alfabético exista (US-0008) / Usuario no existe en followed")
    void getFollowedTestByInvalidUser() {
        /*Usuario Invalido*/
        //Arrange
        int invalidId = 555;
        Mockito.when(userRepo.getUserByID(invalidId)).thenReturn(Optional.empty());

        //Act && Assert
        assertThrows(UserNotFoundException.class, () -> service.getFollowed(invalidId, ""));

    }

    @Test
    @DisplayName("T-0003 / Verificar que el tipo de ordenamiento alfabético exista (US-0008) / Permite continuar con normalidad en followed, sin seguidos")
    void getEmptyFollowedTest() {
        /*Orne no sigue a nadie*/
        //Arrange
        Mockito.when(userRepo.getUserByID(orne.getId())).thenReturn(Optional.of(orne));

        //Act
        UserFollowedListDTO resultList = service.getFollowed(orne.getId(), "");

        //Assert
        Assertions.assertTrue(resultList.getFollowed().isEmpty());

    }

    @Test
    @DisplayName("T-0003 / Verificar que el tipo de ordenamiento alfabético exista (US-0008) / Permite continuar con normalidad en followers, sin seguidos")
    void getEmptyFollowersTest() {
        /*Nadie sigue a orne :(*/
        //Arrange
        Mockito.when(userRepo.getUserByID(orne.getId())).thenReturn(Optional.of(orne));

        //Act
        UserFollowersListDTO resultList = service.getFollowers(orne.getId(), "");

        //Assert
        Assertions.assertTrue(resultList.getFollowers().isEmpty());
    }


    @Test
    @DisplayName("T-0004 / Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008) / Ordenamiento ascendente en followed")
    void getFollowedTestByNameASC() {
        /* La lista de los seguidores de Ramiro quedaria Fabri, Juansito, Lucho*/
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowedListDTO resultList = service.getFollowed(ramiro.getId(), "name_asc");

        //Assert
        assertEquals(ramiro.getId(), resultList.getId());
        assertEquals(ramiro.getName(), resultList.getName());
        Assertions.assertTrue(Comparators.isInOrder(resultList.getFollowed(), Comparator.naturalOrder()));
    }

    @Test
    @DisplayName("T-0004 / Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008) / Ordenamiento descendiente en followed")
    void getFollowedTestByNameDESC() {
        /* La lista de los seguidores de Ramiro quedaria Lucho, Juansito, Fabri*/
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowedListDTO resultList = service.getFollowed(ramiro.getId(), "name_desc");

        //Assertion
        assertEquals(ramiro.getId(), resultList.getId());
        assertEquals(ramiro.getName(), resultList.getName());
        Assertions.assertTrue(Comparators.isInOrder(resultList.getFollowed(), Comparator.reverseOrder()));
    }

    @Test
    @DisplayName("T-0004 / Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008) / Ordenamiento ascendente en followers")
    void getFollowersTestByNameASC() {
        /*La lista  de los seguidos por Ramiro quedaria Fabri , Lucho, Nauhel */
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowersListDTO resultList = service.getFollowers(ramiro.getId(), "name_asc");

        //Assert
        assertEquals(ramiro.getId(), resultList.getId());
        assertEquals(ramiro.getName(), resultList.getName());
        Assertions.assertTrue(Comparators.isInOrder(resultList.getFollowers(), Comparator.naturalOrder()));
    }

    @Test
    @DisplayName("T-0004 / Verificar el correcto ordenamiento ascendente y descendente por nombre. (US-0008) / Ordenamiento descendente en followers")
    void getFollowersTestByNameDESC() {

        /*La lista  de los seguidos por Ramiro quedaria Nauhel , Lucho , Fabri */
        //Arrange
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowersListDTO resultList = service.getFollowers(ramiro.getId(), "name_desc");

        //Assert
        assertEquals(ramiro.getId(), resultList.getId());
        assertEquals(ramiro.getName(), resultList.getName());
        Assertions.assertTrue(Comparators.isInOrder(resultList.getFollowers(), Comparator.reverseOrder()));
    }

    @Test
    @DisplayName("T-0007 / Verificar que la cantidad de seguidores de un determinado usuario sea correcta. (US-0002)")
    void getUserFollowersCount() {
        //Arrange
        int id = 1;
        UserFollowerCountDTO expectedResult = new UserFollowerCountDTO(ramiro.getId(), ramiro.getName(), ramiro.getFollowers().size());
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.of(ramiro));

        //Act
        UserFollowerCountDTO actualResult = service.getUserFollowersCount(id);

        //Assert
        assertEquals(expectedResult, actualResult);
    }

    @Test
    @DisplayName("T-0007 / Verificar que la cantidad de seguidores de un determinado usuario sea correcta/ Usuario invalido (US-0002)")
    void getUserFollowersCountForInvalidUSer() {
        //Arrange
        int invalidID = 1000;
        UserFollowerCountDTO expectedResult = new UserFollowerCountDTO(ramiro.getId(), ramiro.getName(), ramiro.getFollowers().size());
        Mockito.when(userRepo.getUserByID(invalidID)).thenReturn(Optional.empty());

        // ACt && Assert
        assertThrows(UserNotFoundException.class, () -> service.getUserFollowersCount(invalidID));
    }

    void init() {
        ramiro = new User(1, "Ramiro", new ArrayList<>(), new ArrayList<>());
        nauhel = new User(2, "nauhel", new ArrayList<>(), new ArrayList<>());
        juansito = new User(3, "juancito", new ArrayList<>(), new ArrayList<>());
        lucho = new User(4, "luchoDelCampo", new ArrayList<>(), new ArrayList<>());
        fabri = new User(5, "Fabri", new ArrayList<>(), new ArrayList<>());
        orne = new User(6, "Orne", new ArrayList<>(), new ArrayList<>());

        //Seguidores de Ramiro
        ramiro.setFollowed(new ArrayList<>(List.of(juansito, lucho, fabri)));
        juansito.setFollowers(new ArrayList<>(List.of(ramiro)));
        lucho.setFollowers(new ArrayList<>(List.of(ramiro)));
        fabri.setFollowers(new ArrayList<>(List.of(ramiro)));

        //Seguidos por Ramiro
        ramiro.setFollowers(new ArrayList<>(List.of(nauhel, lucho, fabri)));
        nauhel.setFollowed(new ArrayList<>(List.of(ramiro)));
        lucho.setFollowed(new ArrayList<>(List.of(ramiro)));
        fabri.setFollowed(new ArrayList<>(List.of(ramiro)));
    }
}