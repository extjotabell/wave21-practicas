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

import static org.junit.jupiter.api.Assertions.*;

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

    @BeforeEach
    void setUp() {
        init_test_003_004();
    }

    @Test
    void follow() {
    }

    @Test
    void unfollow() {
    }

    @Test
    void getFollowed() {
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
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Funciona Correctamente")
    void getFollowedTest(){
        /*Los seguidores de Ramiro son Juansito, Lucho y Fabri*/
        /*Arrange*/
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.ofNullable(ramiro));
        /*Act*/
        UserFollowedListDTO listaObtenida = service.getFollowed(ramiro.getId(), "");
        /*Assert*/
        Assertions.assertEquals(ramiro.getId(),listaObtenida.getId());
        Assertions.assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertEquals(juansito.getName(),listaObtenida.getFollowed().get(0).getName());
        Assertions.assertEquals(fabri.getName(),listaObtenida.getFollowed().get(2).getName());
    }

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Funciona Correctamente")
    void getFollowersTest(){
        /*Los seguidos por Ramiro son nahuel, Lucho y Fabri*/
        /*Arrange*/
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.ofNullable(ramiro));
        /*Act*/
        UserFollowersListDTO listaObtenida = service.getFollowers(ramiro.getId(), "");
        /*Assert*/
        Assertions.assertEquals(ramiro.getId(),listaObtenida.getId());
        Assertions.assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertEquals(nauhel.getName(),listaObtenida.getFollowers().get(0).getName());
        Assertions.assertEquals(fabri.getName(),listaObtenida.getFollowers().get(2).getName());
    }

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Usuario invalido en follower")
    void getFollowersTestByInvalidUser(){
        /*Usuario Invalido*/
        /*Arrange*/
        int idInvalido = 555;
        Mockito.when(userRepo.getUserByID(idInvalido)).thenReturn(Optional.empty());
        /*Act && Assert*/
        Assertions.assertThrows(UserNotFoundException.class, ()-> service.getFollowers(idInvalido, ""));

    }

    @Test
    @DisplayName("T003- Verificar que el tipo de ordenamiento alfabético exista (US-0008)-Usuario invalido en followed")
    void getFollowedTestByInvalidUser(){
        /*Usuario Invalido*/
        /*Arrange*/
        int idInvalido = 555;
        Mockito.when(userRepo.getUserByID(idInvalido)).thenReturn(Optional.empty());
        /*Act && Assert*/
        Assertions.assertThrows(UserNotFoundException.class, ()-> service.getFollowed(idInvalido, ""));

    }

    @Test
    @DisplayName("T004- Devuelve la lista ordenada según el criterio solicitado - FOLLOWED NAME ASC")
    void getFollowedTestByNameASC(){
        /* La lista de los seguidores de Ramiro quedaria Fabri, Juansito, Lucho*/
        /*Arrange*/
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.ofNullable(ramiro));
        /*Act*/
        UserFollowedListDTO listaObtenida = service.getFollowed(ramiro.getId(), "name_asc");
        /*Assert*/
        Assertions.assertEquals(ramiro.getId(),listaObtenida.getId());
        Assertions.assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertTrue(Comparators.isInOrder(listaObtenida.getFollowed(),Comparator.naturalOrder()));

       /* Assertions.assertEquals(fabri.getName(),listaObtenida.getFollowed().get(0).getName());
        Assertions.assertEquals(juansito.getName(),listaObtenida.getFollowed().get(1).getName());
        Assertions.assertEquals(lucho.getName(),listaObtenida.getFollowed().get(2).getName());*/
    }

    @Test
    @DisplayName("T004- Devuelve la lista ordenada según el criterio solicitado - FOLLOWED NAME DESC")
    void getFollowedTestByNameDESC(){
        /* La lista de los seguidores de Ramiro quedaria Lucho, Juansito, Fabri*/
        /*Arrange*/
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.ofNullable(ramiro));
        /*Act*/
        UserFollowedListDTO listaObtenida = service.getFollowed(ramiro.getId(), "name_desc");
        /*Assertion*/
        Assertions.assertEquals(ramiro.getId(),listaObtenida.getId());
        Assertions.assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertTrue(Comparators.isInOrder(listaObtenida.getFollowed(),Comparator.reverseOrder()));

        /*
        Assertions.assertEquals(lucho.getName(),listaObtenida.getFollowed().get(0).getName());
        Assertions.assertEquals(fabri.getName(),listaObtenida.getFollowed().get(2).getName());*/
    }



    @Test
    @DisplayName("T004- Devuelve la lista ordenada según el criterio solicitado - FOLLOWERS NAME ASC")
    void getFollowersTestByNameASC(){
        /*La lista  de los seguidos por Ramiro quedaria Fabri , Lucho, Nauhel */
        /*Arrange*/
        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.ofNullable(ramiro));
        /*Act*/
        UserFollowersListDTO listaObtenida = service.getFollowers(ramiro.getId(), "name_asc");
        /*Assert*/
        Assertions.assertEquals(ramiro.getId(),listaObtenida.getId());
        Assertions.assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertTrue(Comparators.isInOrder(listaObtenida.getFollowers(),Comparator.naturalOrder()));

        /*
        Assertions.assertEquals(fabri.getName(),listaObtenida.getFollowers().get(0).getName());
        Assertions.assertEquals(lucho.getName(),listaObtenida.getFollowers().get(1).getName());
        Assertions.assertEquals(nauhel.getName(),listaObtenida.getFollowers().get(2).getName());*/
    }

    @Test
    @DisplayName("T004- Devuelve la lista ordenada según el criterio solicitado - FOLLOWERS NAME DESC")
    void getFollowersTestByNameDESC(){

        /*La lista  de los seguidos por Ramiro quedaria Nauhel , Lucho , Fabri */

        Mockito.when(userRepo.getUserByID(ramiro.getId())).thenReturn(Optional.ofNullable(ramiro));

        UserFollowersListDTO listaObtenida = service.getFollowers(ramiro.getId(), "name_desc");

        Assertions.assertEquals(ramiro.getId(),listaObtenida.getId());
        Assertions.assertEquals(ramiro.getName(),listaObtenida.getName());
        Assertions.assertTrue(Comparators.isInOrder(listaObtenida.getFollowers(),Comparator.reverseOrder()));
/*
        Assertions.assertEquals(nauhel.getName(),listaObtenida.getFollowers().get(0).getName());
        Assertions.assertEquals(fabri.getName(),listaObtenida.getFollowers().get(2).getName());*/
    }


    void init_test_003_004 (){
        ramiro = new User(1, "Ramiro", new ArrayList<>(), new ArrayList<>());
        nauhel = new User(2, "nauhel", new ArrayList<>(), new ArrayList<>());
        juansito = new User(3, "juancito", new ArrayList<>(), new ArrayList<>());
        lucho = new User(4, "luchoDelCampo", new ArrayList<>(), new ArrayList<>());
        fabri = new User(5, "Fabri", new ArrayList<>(), new ArrayList<>());

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
}