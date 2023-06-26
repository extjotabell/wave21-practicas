package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analyze Score Happy Path ")
    void testAnalyzeScore(){

        Long studentId = 1L;

        List<SubjectDTO> subjects = Arrays.asList(
                new SubjectDTO("Math", 9.5),
                new SubjectDTO("Science", 8.7),
                new SubjectDTO("History", 7.8)
        );

        double avarageScoreMock = (9.5+8.7+7.8)/3;
        StudentDTO studenMock = new StudentDTO(1L,"Fran","",0.0,subjects);

        StudentDTO studentExpected = new StudentDTO(1L,"Fran","El alumno Fran ha obtenido un promedio de 8,67. Puedes mejorar.",avarageScoreMock,subjects);

        when(studentDAO.findById(studentId)).thenReturn(studenMock);

        StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

        assertEquals(studentExpected,result);
    }

    @Test
    @DisplayName("Analyze Score Student not found")
    void testAnalyzeScoreUserNotFound(){
        when(studentDAO.findById(8L)).thenThrow(StudentNotFoundException.class);

        assertThrows(StudentNotFoundException.class,
                () -> obtenerDiplomaService.analyzeScores(8L));
    }
    }