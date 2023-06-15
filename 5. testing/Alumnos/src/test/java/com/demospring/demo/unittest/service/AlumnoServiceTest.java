package com.demospring.demo.unittest.service;

import com.demospring.demo.dto.AlumnoDTO;
import com.demospring.demo.entity.Alumno;
import com.demospring.demo.exceptions.IdNoEncontradoException;
import com.demospring.demo.repository.AlumnoRepository;
import com.demospring.demo.service.AlumnoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Incubating;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class AlumnoServiceTest {

    @InjectMocks
    AlumnoService alumnoService;
    @Mock
    AlumnoRepository alumnoRepository;


    @Test
    @DisplayName("Encuentra alumnno por Id")
    void findByIdTestOK (){

        //Arrange
        String dni = "3000";

        Alumno alumnoMock = new Alumno(dni,"Alumno 1", LocalDate.now(),35, List.of());

        AlumnoDTO expected = new AlumnoDTO(dni,"Alumno 1", LocalDate.now(),35, List.of());

        //Mock
        Mockito.when(alumnoRepository.findById(dni)).thenReturn(Optional.of(alumnoMock));

        //Act
        AlumnoDTO actual = alumnoService.findById(dni);

        //Assert
        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("Alumno inexistente por Id")
    void findByIdTestFail (){

        //Arrange
        String dni = "3000";

        //Mock
        Mockito.when(alumnoRepository.findById(dni)).thenReturn(Optional.empty());

        //Act & Assert
        Assertions.assertThrows(IdNoEncontradoException.class,()  -> alumnoService.findById(dni));
    }
}
