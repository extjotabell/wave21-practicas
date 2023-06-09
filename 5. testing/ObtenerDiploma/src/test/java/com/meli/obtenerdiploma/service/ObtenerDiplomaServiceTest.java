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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    @DisplayName("AnalizeScores")
    void analyzeScoresTestOk() {
        //Arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(23L, "Javier", "", 9.5, new ArrayList<>());
        when(studentDAO.findById( studentId )).thenReturn(expected);
        //Act
        StudentDTO result = diplomaService.analyzeScores(studentId);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("AnalizeScores puntaje caso promedio mayor a 9")
    public void analyzeScoresMayorANueveOKTest(){
        //Arrange
        long studentId = 2L;
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(new SubjectDTO("Programación", 9.0)
                , new SubjectDTO("Matemáticas", 10.0)));
        StudentDTO expectedDTO = new StudentDTO();
        expectedDTO.setId(studentId);
        expectedDTO.setSubjects(subjects);
        expectedDTO.setStudentName("Pepito");

        when(studentDAO.findById(studentId)).thenReturn(expectedDTO);

        //Act
        StudentDTO obtainedDTO = diplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedDTO.getAverageScore(),obtainedDTO.getAverageScore());
        assertEquals(expectedDTO.getMessage(),obtainedDTO.getMessage());
    }

    @Test
    @DisplayName("AnalizeScores puntaje caso promedio menor a 9")
    public void analyzeScoresMenorANueveOKTest(){
        //Arrange
        long studentId = 2L;
        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(new SubjectDTO("Programación", 5.0)
                , new SubjectDTO("Matemáticas", 7.0)));
        StudentDTO expectedDTO = new StudentDTO();
        expectedDTO.setId(studentId);
        expectedDTO.setSubjects(subjects);
        expectedDTO.setStudentName("Pepito");

        when(studentDAO.findById(studentId)).thenReturn(expectedDTO);

        //Act
        StudentDTO obtainedDTO = diplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedDTO.getAverageScore(),obtainedDTO.getAverageScore());
        assertEquals(expectedDTO.getMessage(),obtainedDTO.getMessage());
    }

}
