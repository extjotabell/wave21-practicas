package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTestConMock {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    public void calculateAverageTest() {

        List<SubjectDTO> scores = new ArrayList<>();
        scores.add(new SubjectDTO("Matemática", 9D));
        scores.add(new SubjectDTO("Física", 7D));
        scores.add(new SubjectDTO("Química", 6D));

        StudentDTO studentServiceMock = new StudentDTO(1L,"Juan","",0.0,scores);
        when(studentDAO.findById(1L)).thenReturn(studentServiceMock);

        StudentDTO studentCurrent = diplomaService.analyzeScores(1L);

        StudentDTO studentServiceExpected = new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",7.333333333333333,scores);

        assertEquals(studentServiceExpected.getAverageScore(), studentCurrent.getAverageScore());
        assertEquals(studentServiceExpected.getMessage(), studentCurrent.getMessage());

    }

}
