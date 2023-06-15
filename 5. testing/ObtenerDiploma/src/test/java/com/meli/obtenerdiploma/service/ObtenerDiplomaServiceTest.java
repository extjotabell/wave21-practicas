package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    @DisplayName("AnalyzeScores Unit Test")
    void analyzeScoresTestOk() {
        //Arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(23L, "Javier", "", 8.0, new ArrayList<>());
        when(studentDAO.findById(any())).thenReturn(expected);
        //Act
        StudentDTO result = diplomaService.analyzeScores(studentId);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("AnalyzeScore Test - Less than 9 ")
    public void analyzeScoresLessThan9() {
        //Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(1L, "Pablo", "", 0D,
                List.of(new SubjectDTO("Ingles", 8.5),
                        new SubjectDTO("Quimica", 5.7)));
        double average = 7.1;
        String message = String.format("El alumno %s ha obtenido un promedio de %s. Puedes mejorar.", student.getStudentName(), new DecimalFormat("#.##").format(average));
        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO result = diplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(average, result.getAverageScore());
        assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("AnalyzeScore Test - More than 9 ")
    public void analyzeScoresMoreThan9() {
        //Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(1L, "Pablo", "", 0D,
                List.of(new SubjectDTO("Ingles", 10D),
                        new SubjectDTO("Quimica", 10D)));
        double average = 10;
        String message = String.format("El alumno %s ha obtenido un promedio de %s. Felicitaciones!", student.getStudentName(), new DecimalFormat("#.##").format(average));
        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO result = diplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(average, result.getAverageScore());
        assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("AnalyzeScore Test - Equals to 9 ")
    public void analyzeScoresEqualsTo9() {
        //Arrange
        Long studentId = 1L;
        StudentDTO student = new StudentDTO(1L, "Pablo", "", 0D,
                List.of(new SubjectDTO("Ingles", 9D),
                        new SubjectDTO("Quimica", 9D)));
        double average = 9;
        String message = String.format("El alumno %s ha obtenido un promedio de %s. Puedes mejorar.", student.getStudentName(), new DecimalFormat("#.##").format(average));
        when(studentDAO.findById(studentId)).thenReturn(student);

        //Act
        StudentDTO result = diplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(average, result.getAverageScore());
        assertEquals(message, result.getMessage());
    }
}

