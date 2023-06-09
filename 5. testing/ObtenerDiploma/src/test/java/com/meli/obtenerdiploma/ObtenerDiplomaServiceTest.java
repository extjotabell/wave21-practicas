package com.meli.obtenerdiploma;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ObtenerDiplomaServiceTest {
  @Mock
  IStudentDAO student;

  @InjectMocks
  ObtenerDiplomaService obtenerDiplomaService;

  @Test
  @DisplayName("Valido el promedio de numeros positivos y es desaprobado")
  void analyzeScoresOkDesaprobado() {
    long studentId = 5l;

    StudentDTO studentResult = new StudentDTO();
    studentResult.setAverageScore(4.7);
    studentResult.setMessage("El alumno Nahuel ha obtenido un promedio de 4.70. Puedes mejorar.");


    StudentDTO studentMock = new StudentDTO();
    studentMock.setStudentName("Nahuel");
    studentMock.setSubjects(Arrays.asList(
      new SubjectDTO("Matematica", 1.0),
      new SubjectDTO("Literatura", 8.5),
      new SubjectDTO("Quimica", 4.6)
    ));

    when(student.findById(studentId)).thenReturn(studentMock);

    StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

    assertAll(
      () ->  assertEquals(result.getAverageScore(), studentResult.getAverageScore()),
      () -> assertNotEquals(result.getMessage(), studentResult.getMessage())
    );
  }

  @Test
  @DisplayName("Valido el promedio de numeros positivos y es aprobado")
  void analyzeScoresOkAprobado() {
    long studentId = 5l;

    StudentDTO studentResult = new StudentDTO();
    studentResult.setAverageScore(27.1/3);
    studentResult.setMessage("El alumno Nahuel ha obtenido un promedio de 9.03. Feliciataciones!");


    StudentDTO studentMock = new StudentDTO();
    studentMock.setStudentName("Nahuel");
    studentMock.setSubjects(Arrays.asList(
      new SubjectDTO("Matematica", 10.0),
      new SubjectDTO("Literatura", 9.5),
      new SubjectDTO("Quimica", 7.6)
    ));

    when(student.findById(studentId)).thenReturn(studentMock);

    StudentDTO result = obtenerDiplomaService.analyzeScores(studentId);

    assertAll(
      () ->  assertEquals(result.getAverageScore(), studentResult.getAverageScore()),
      () -> assertNotEquals(result.getMessage(), studentResult.getMessage())
    );
  }

}
