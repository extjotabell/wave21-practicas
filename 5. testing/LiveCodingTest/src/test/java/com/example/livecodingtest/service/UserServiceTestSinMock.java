package com.example.livecodingtest.service;

import com.example.livecodingtest.dto.UserDto;
import com.example.livecodingtest.exception.NotFoundException;
import com.example.livecodingtest.repository.IUserRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTestSinMock {

    @Autowired
    IUserService userService;

    @Autowired
    IUserRepository userRepository;

    @Test
    @DisplayName("Camino Feliz crear usuario...")
    void crearUsuarioOkTest(){
        //arrange
        UserDto userDto = new UserDto("Diego", "Maradona",60);
        UserDto expected = new UserDto("Diego", "Maradona",60);
        //act
        UserDto act = userService.crearUsuario(userDto);

        //assert
        assertEquals(expected,act);
    }

    @Test
    @DisplayName("Camino no tan feliz...")
    void buscarTodosThrowExTest(){
        //act and assert
        assertThrows(NotFoundException.class,()->{
            userService.buscarTodos();
        });
    }

    @Test
    @DisplayName("US0001-Camino Feliz :D")
    void buscarTodosOkTest() {

        //ARRANGE
        List<UserDto> expected = new ArrayList<>();
        expected.add(new UserDto("Jose","Perez", 32));
        expected.add(new UserDto("María", "Paz", 25));
        expected.add(new UserDto("Emilio", "Gonzales", 30));

        //ACT
        List<UserDto> result = userService.buscarTodos();
        //ASSERT
        assertEquals(expected,result);
    }


    @Test
    @DisplayName("US0002-Camino feliz :D")
    void buscarUnUsuarioPorNombreOKTest(){

        //ARRANGE
        String name= "Jose";
        UserDto expected = new UserDto("Jose","Perez", 32);

        //ACT
        UserDto result = userService.buscarUnUsuarioPorNombre(name);

        //ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("US0001-Test para probar el camino correcto del metodo calculeTotal")
    void calculeTotalOkTest(){
        //Arrange - Definir los parámetros con valores que debe recibir el método a testear.
        int a = 6;
        int b = 4;
        int resultadoEsperado = 10;

        //Act
        int result = userService.calculeTotal(a,b);

        //Assert
        assertEquals(resultadoEsperado,result);

    }



}
