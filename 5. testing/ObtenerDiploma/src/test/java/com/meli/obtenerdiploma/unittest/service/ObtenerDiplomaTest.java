package com.meli.obtenerdiploma.unittest.service;

import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.hamcrest.collection.ArrayAsIterableMatcher;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Test 001 - obtener un promedio menor a 9 ")
    public void analyzeScoresLessThan9() {
        //Arrange
        Long studentId = 1L;
        SubjectDTO s1 = new SubjectDTO("Ingles", 6.0);
        SubjectDTO s2 = new SubjectDTO("Lengua", 5.0);
        StudentDTO stu = new StudentDTO(1L, "Gabriel", "", 0.0, List.of(s1,s2));
        double average = 5.5;
        String message = String.format("El alumno %s ha obtenido un promedio de %s. Puedes mejorar.",
                stu.getStudentName(), new DecimalFormat("#.##").format(average));

        when(studentDAO.findById(studentId)).thenReturn(stu);

        StudentDTO actualResponse = obtenerDiplomaService.analyzeScores(studentId);

        //assert
        assertEquals(average,actualResponse.getAverageScore() );
        assertEquals(message, actualResponse.getMessage());
    }

    @Test
    @DisplayName("Test 002 - obtener un promedio mayor a 9 ")
    public void analyzeScoresGreaterThan9() {
        //Arrange
        Long studentId = 1L;
        SubjectDTO s1 = new SubjectDTO("Ingles", 10.0);
        SubjectDTO s2 = new SubjectDTO("Lengua", 9.0);
        StudentDTO stu = new StudentDTO(1L, "Gabriel", "", 0.0, List.of(s1,s2));
        double average = 9.5;
        String message = String.format("El alumno %s ha obtenido un promedio de %s. Felicitaciones!",
                stu.getStudentName(), new DecimalFormat("#.##").format(average));

        when(studentDAO.findById(studentId)).thenReturn(stu);

        StudentDTO actualResponse = obtenerDiplomaService.analyzeScores(studentId);

        //assert
        assertEquals(average,actualResponse.getAverageScore() );
        assertEquals(message, actualResponse.getMessage());
    }

    @Test
    @DisplayName("Test 002 - estudiante no encontrado ")
    public void analyzeScoresStudentNull() {
        //Arrang
        Long studentId = 1L;
        when(studentDAO.findById(studentId)).thenThrow(StudentNotFoundException.class);
        //when(studentDAO.findById(studentId)).thenReturn(null);


        Assertions.assertThrows(StudentNotFoundException.class, () -> {
            // Código que llama al método que debería lanzar la excepción
            StudentDTO actualResponse = obtenerDiplomaService.analyzeScores(studentId);
        });


    }

}
