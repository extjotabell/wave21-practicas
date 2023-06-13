package com.otenerdiploma.OtenerDiploma.Service;

import com.otenerdiploma.OtenerDiploma.model.StudentDTO;
import com.otenerdiploma.OtenerDiploma.model.SubjectDTO;
import com.otenerdiploma.OtenerDiploma.repository.IStudentDAO;
import com.otenerdiploma.OtenerDiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Promedio bajo")
    void analyzeScores(){
        Long studentId = 1L;
        String studentName = "Juan";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 8.0));
        StudentDTO student = new StudentDTO(studentId, studentName, null, null, subjects);

        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(student, result);
        assertEquals(8.75, result.getAverageScore());
        String expectedMessage = "El alumno " + studentName + " ha obtenido un promedio de 8.75. Puedes mejorar.";
        assertEquals(expectedMessage, result.getMessage());
    }

    @Test
    @DisplayName("Promedio alto")
    void analyzeScoresHighAverage(){
        Long studentId = 1L;
        String studentName = "Juan";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 10D));
        StudentDTO student = new StudentDTO(studentId, studentName, null, null, subjects);

        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(student, result);
        assertEquals(9.75, result.getAverageScore());
        String expectedMessage = "El alumno " + studentName + " ha obtenido un promedio de 9.75. Felicitaciones!";
        assertEquals(expectedMessage, result.getMessage());
    }
}
