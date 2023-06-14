package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    private StudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analizar puntaje caso promedio mayor a 9")
    void analyzeScoresMayorANueveOKTest(){
        //Arrange
        long studentId = 1;
        StudentDTO studentDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOf10("Fabri");

        StudentDTO expectedDTO = TestUtilsGenerator.getStudentWith3SubjectsAverageOf10("Fabri");
        expectedDTO.setAverageScore(10.0);
        expectedDTO.setMessage("El alumno Fabri ha obtenido un promedio de 10. Felicitaciones!");
        when(studentDAO.findById(studentId)).thenReturn(studentDTO);

        //Act
        StudentDTO obtainedDTO = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedDTO.getAverageScore(),obtainedDTO.getAverageScore());
        assertEquals(expectedDTO.getMessage(),obtainedDTO.getMessage());
    }

    @Test
    @DisplayName("Analizar puntaje caso promedio menor  a 9")
    void analyzeScoresMenorANueveOKTest(){
        //Arrange
        long studentId = 1;
        StudentDTO resultDTO = TestUtilsGenerator.getStudentWith3Subjects("Fabri");
        StudentDTO expectedDTO = TestUtilsGenerator.getStudentWith3Subjects("Fabri");
        expectedDTO.setAverageScore(6.0);
        expectedDTO.setMessage("El alumno Fabri ha obtenido un promedio de 6. Puedes mejorar.");
        when(studentDAO.findById(studentId)).thenReturn(resultDTO);

        //Act
        StudentDTO obtainedDTO = obtenerDiplomaService.analyzeScores(studentId);

        //Assert
        assertEquals(expectedDTO,obtainedDTO);
    }
}
