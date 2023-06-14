package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO _studentDao;

    @InjectMocks
    ObtenerDiplomaService _obtenerDiplomaService;

    @Test
    @DisplayName("US0001-Camino OK analyzeScoresTest")
    void analyzeScoresTestOk(){

        //arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(23L, "Marielena", "", 8.3, new ArrayList<>());

        when(_studentDao.findById(studentId)).thenReturn(expected);
        //act
        StudentDTO result = _obtenerDiplomaService.analyzeScores(studentId);
        //assert
        assertEquals(expected, result);

    }

}
