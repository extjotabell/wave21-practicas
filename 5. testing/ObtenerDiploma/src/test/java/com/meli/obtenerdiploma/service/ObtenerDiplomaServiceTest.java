package com.meli.obtenerdiploma.service;

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

import java.text.DecimalFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService obtenerDiplomaService;

    @Test
    @DisplayName("Analizar notas usuario promedio menor a 9")
    void analyzeScoresTest() {
        //arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica", 5D),
                new SubjectDTO("Lengua", 8D),
                new SubjectDTO("Historia", 9D),
                new SubjectDTO("Geografia", 5.2653D),
                new SubjectDTO("Fisica", 6.345D)
        );

        Double average = subjects.stream().mapToDouble(SubjectDTO::getScore).average().orElse(0D);

        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, subjects);
        StudentDTO studenExpected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de " + new DecimalFormat("#.##").format(average) + ". Puedes mejorar.", average, subjects);

        when(studentDAO.findById(1L)).thenReturn(studentMock);
        //act
        StudentDTO studentActual = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(studenExpected, studentActual);
    }

    @Test
    @DisplayName("Analizar notas usuario con promedio mayor a 9")
    void analyzeScoresTest2() {
        //arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica", 10D),
                new SubjectDTO("Lengua", 10D),
                new SubjectDTO("Historia", 10D),
                new SubjectDTO("Geografia", 10D),
                new SubjectDTO("Fisica", 10D)
        );

        Double average = 10D;

        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, subjects);
        StudentDTO studenExpected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de " + 10 + ". Felicitaciones!", average, subjects);

        when(studentDAO.findById(1L)).thenReturn(studentMock);
        //act
        StudentDTO studentActual = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(studenExpected, studentActual);
    }

    @Test
    @DisplayName("Analizar notas usuario con promedio igual a 9")
    void analyzeScoresTest3() {
        //arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica", 9D),
                new SubjectDTO("Lengua", 9D),
                new SubjectDTO("Historia", 9D),
                new SubjectDTO("Geografia", 9D),
                new SubjectDTO("Fisica", 9D)
        );

        Double average = 9D;

        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, subjects);
        StudentDTO studenExpected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de " + 9 + ". Puedes mejorar.", average, subjects);

        when(studentDAO.findById(1L)).thenReturn(studentMock);
        //act
        StudentDTO studentActual = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(studenExpected, studentActual);
    }

    @Test
    @DisplayName("Analizar notas usuario con promedio igual a 0")
    void analyzeScoresTest4() {
        //arrange
        List<SubjectDTO> subjects = List.of(
                new SubjectDTO("Matematica", 0D),
                new SubjectDTO("Lengua", 0D),
                new SubjectDTO("Historia", 0D),
                new SubjectDTO("Geografia", 0D),
                new SubjectDTO("Fisica", 0D)
        );

        Double average = 0D;

        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, subjects);
        StudentDTO studenExpected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de " + 0 + ". Puedes mejorar.", average, subjects);

        when(studentDAO.findById(1L)).thenReturn(studentMock);
        //act
        StudentDTO studentActual = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(studenExpected, studentActual);
    }

    @Test
    @DisplayName("Analizar notas usuario sin materias")
    void analyzeScoresTest5() {
        //arrange
        List<SubjectDTO> subjects = List.of();

        Double average = 0D;

        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, subjects);
        StudentDTO studenExpected = new StudentDTO(1L, "Juan", "El alumno Juan ha obtenido un promedio de " + 0 + ". Puedes mejorar.", average, subjects);

        when(studentDAO.findById(1L)).thenReturn(studentMock);
        //act
        StudentDTO studentActual = obtenerDiplomaService.analyzeScores(1L);

        //assert
        assertEquals(studenExpected, studentActual);
    }
}
