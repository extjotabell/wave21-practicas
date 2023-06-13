package com.otenerdiploma.OtenerDiploma.Controller;

import com.otenerdiploma.OtenerDiploma.controller.ObtenerDiplomaController;
import com.otenerdiploma.OtenerDiploma.model.StudentDTO;
import com.otenerdiploma.OtenerDiploma.model.SubjectDTO;
import com.otenerdiploma.OtenerDiploma.service.IObtenerDiplomaService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {
    @Mock
    private IObtenerDiplomaService service;
    @InjectMocks
    private ObtenerDiplomaController controller;
    @Test
    void analyzeScores(){
        Long studentId = 1L;
        List<SubjectDTO> subjects1 = new ArrayList<>();
        subjects1.add(new SubjectDTO("Matematicas", 9.5));
        subjects1.add(new SubjectDTO("Historia", 8.0));
        StudentDTO student = new StudentDTO(studentId, "Karla", "El alumno Karla ha obtenido un promedio de 8.75. Puedes mejorar.", 8.75, subjects1);

        List<SubjectDTO> subjects2 = new ArrayList<>();
        subjects2.add(new SubjectDTO("Matematicas", 9.5));
        subjects2.add(new SubjectDTO("Historia", 8.0));
        StudentDTO expected = new StudentDTO(studentId, "Karla", null, null, subjects2);

        when(service.analyzeScores(studentId)).thenReturn(student);

        StudentDTO result = controller.analyzeScores(studentId);

        assertNotNull(result);
        assertEquals("Karla", result.getStudentName());
        String expectedMessage = "El alumno Karla ha obtenido un promedio de 8.75. Puedes mejorar.";
        assertEquals(8.75, result.getAverageScore());
        assertEquals(expectedMessage, result.getMessage());
    }
}
