package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
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
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    //EJERCICIO #2

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analizar puntaje caso promedio mayor a 9")
    public void analyzeScoresMayorANueveOKTest(){
        //Arrange
        long studentId = 2;
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(new SubjectDTO("Programación", 9.0)
                , new SubjectDTO("Matemáticas", 10.0)));
        StudentDTO resultDTO = getStudentDTOMock(subjects);
        StudentDTO expectedDTO = getStudentDTOExpected(subjects);
        expectedDTO.setAverageScore(9.50);
        expectedDTO.setMessage("El alumno Pepito ha obtenido un promedio de 9.5. Felicitaciones!");
        when(studentDAO.findById(studentId)).thenReturn(resultDTO);

        //Act
        StudentDTO obtainedDTO = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedDTO.getAverageScore(),obtainedDTO.getAverageScore());
        assertEquals(expectedDTO.getMessage(),obtainedDTO.getMessage());
        assertNotSame(expectedDTO,obtainedDTO);
    }


    private StudentDTO getStudentDTOMock(List<SubjectDTO> subjects){
        StudentDTO result = new StudentDTO();
        result.setId(1L);
        result.setSubjects(subjects);
        result.setStudentName("Pepito");

        result.setAverageScore(null);
        result.setMessage(null);
        return result;
    }

    private StudentDTO getStudentDTOExpected(List<SubjectDTO> subjects){
        StudentDTO result = new StudentDTO();
        result.setId(1L);
        result.setSubjects(subjects);
        result.setStudentName("Pepito");

        return result;
    }

    @Test
    @DisplayName("Analizar puntaje caso promedio menor  a 9")
    public void analyzeScoresMenorANueveOKTest(){
        //Arrange
        long studentId = 2;
        List<SubjectDTO> subjects =  new ArrayList<>(Arrays.asList(new SubjectDTO("Programación", 1.0)
                , new SubjectDTO("Matemáticas", 1.0)));
        StudentDTO resultDTO = getStudentDTOMock(subjects);
        StudentDTO expectedDTO = getStudentDTOExpected(subjects);
        when(studentDAO.findById(studentId)).thenReturn(resultDTO);
        expectedDTO.setAverageScore(1D);
        expectedDTO.setMessage("El alumno Pepito ha obtenido un promedio de 1. Puedes mejorar.");

        //Act
        StudentDTO obtainedDTO = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedDTO.getAverageScore(),obtainedDTO.getAverageScore());
        assertEquals(expectedDTO.getMessage(),obtainedDTO.getMessage());
        assertNotSame(expectedDTO,obtainedDTO);
    }
}
