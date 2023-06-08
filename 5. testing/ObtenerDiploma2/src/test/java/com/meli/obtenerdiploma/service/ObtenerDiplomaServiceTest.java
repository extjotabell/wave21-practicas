package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {
    @Mock
    StudentDAO studentDAO;

    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Test
    @DisplayName("US- AnalizeScores Caso feliz!!!!")
    void analyzeScoresTestOk() {
        //Arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(23L, "Javier", "", 8.0, new ArrayList<>());
        when(studentDAO.findById( any() )).thenReturn(expected);
        //Act
        StudentDTO result = diplomaService.analyzeScores(studentId);
        //Assert
        assertEquals(expected, result);
    }




}

