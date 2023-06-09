package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaServiceTest {

    @Mock
    private IStudentDAO studentDAO;

    @InjectMocks
    private ObtenerDiplomaService service;

    @Test
    void analyzeScoresTest(){
        long studentId = 100;
        StudentDTO expected = new StudentDTO(10L,"Juan","HOla soy Juan", 7.6,
                List.of(new SubjectDTO("Matematicas",7.8),new SubjectDTO("Historia",9.0)));

        when(studentDAO.findById(studentId)).thenReturn(expected);
        //ACT
        StudentDTO result = service.analyzeScores(studentId);
        //ASSERT
        assertEquals(expected,result);
    }
}
