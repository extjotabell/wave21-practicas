package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.assertj.core.internal.Doubles;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTests {

    @Mock
    IStudentDAO studentRepository;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Test 001 - obtener un promedio menor a 9 ")
    public void analyzeScoresLessThan9() {
        //Arrange
        Long studentId = 1L;
        SubjectDTO subject1 = new SubjectDTO("Ingles", 8.5);
        SubjectDTO subject2 = new SubjectDTO("Quimica", 5.7);
        StudentDTO stu = new StudentDTO(1L, "Pablo", "", 0D, List.of(subject1, subject2));
        double average = 7.1;
        String message = String.format("El alumno %s ha obtenido un promedio de %s. Puedes mejorar.", stu.getStudentName(), new DecimalFormat("#.##").format(average));
        when(studentRepository.findById(studentId)).thenReturn(stu);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(average, result.getAverageScore());
        assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("Test 002 - obtener un promedio mayor a 9 ")
    public void analyzeScoresMoreThan9() {
        //Arrange
        Long studentId = 1L;
        SubjectDTO subject1 = new SubjectDTO("Ingles", 10D);
        SubjectDTO subject2 = new SubjectDTO("Quimica", 10D);
        StudentDTO stu = new StudentDTO(1L, "Pablo", "", 0D, List.of(subject1, subject2));
        double average = 10;
        String message = String.format("El alumno %s ha obtenido un promedio de %s. Felicitaciones!", stu.getStudentName(), new DecimalFormat("#.##").format(average));
        when(studentRepository.findById(studentId)).thenReturn(stu);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(average, result.getAverageScore());
        assertEquals(message, result.getMessage());
    }

    @Test
    @DisplayName("Test 003 - obtener un promedio igual a 9 ")
    public void analyzeScoresEqualTo9() {
        //Arrange
        Long studentId = 1L;
        SubjectDTO subject1 = new SubjectDTO("Ingles", 9D);
        SubjectDTO subject2 = new SubjectDTO("Quimica", 9D);
        StudentDTO stu = new StudentDTO(1L, "Pablo", "", 0D, List.of(subject1, subject2));
        double average = 9;
        String message = String.format("El alumno %s ha obtenido un promedio de %s. Felicitaciones!", stu.getStudentName(), new DecimalFormat("#.##").format(average));
        when(studentRepository.findById(studentId)).thenReturn(stu);

        //Act
        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(average, result.getAverageScore());
        assertEquals(message, result.getMessage());
    }
}
