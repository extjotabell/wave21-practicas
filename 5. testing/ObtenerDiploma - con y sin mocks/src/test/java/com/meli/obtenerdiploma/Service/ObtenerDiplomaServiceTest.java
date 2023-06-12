package com.meli.obtenerdiploma.Service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.*;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTest {
    @Mock
    IStudentDAO _studentDao;
    @InjectMocks
    ObtenerDiplomaService _obtenerDiplomaService;
    @Test
    @DisplayName("Testing Analyze Score under 9")
    void analyzeScoreUnderBorderValueTest(){
        // Arrange
        SubjectDTO subject = new SubjectDTO("Matematicas", 8D);
        SubjectDTO subject1 = new SubjectDTO("Lengua", 4D);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Flavio",null,null, subjectDTOList);

        when(_studentDao.findById(1L)).thenReturn(student);
        Double expectedAverage = 6D;
        // Act

        StudentDTO studentService = _obtenerDiplomaService.analyzeScores(1L);


        // Assert
        assertEquals(student, studentService);
        assertEquals(expectedAverage, studentService.getAverageScore());
        assertEquals(student.getMessage(), studentService.getMessage());
    }

    @Test
    @DisplayName("Testing Analyze Score above 9")
    void analyzeScoreAboveBorderValueTest(){
        // Arrange
        SubjectDTO subject = new SubjectDTO("Matematicas", 10D);
        SubjectDTO subject1 = new SubjectDTO("Lengua", 9D);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject);

        StudentDTO student = new StudentDTO(1L,"Flavio",null,9.50D, subjectDTOList);
        String expectedMessage = "El alumno " + student.getStudentName() +
                " ha obtenido un promedio de " + new DecimalFormat("#.##").format(student.getAverageScore()) +
                ". Felicitaciones!";
        student.setMessage(expectedMessage);
        when(_studentDao.findById(1L)).thenReturn(student);

        // Act
        StudentDTO studentService = _obtenerDiplomaService.analyzeScores(1L);

        // Asserts
        assertEquals(student, studentService);
        assertEquals(student.getAverageScore(), studentService.getAverageScore());
        assertEquals(student.getMessage(), studentService.getMessage());
    }
}