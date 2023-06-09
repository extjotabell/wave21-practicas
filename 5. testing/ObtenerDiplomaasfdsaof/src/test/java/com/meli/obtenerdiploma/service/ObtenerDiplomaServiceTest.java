package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class ObtenerDiplomaServiceTest {

    @Mock
    IStudentDAO iStudentDAO;

    @InjectMocks
    ObtenerDiplomaService underTest;

    StudentDTO studentDTOMock;

    @BeforeEach
    void setUp() {
        studentDTOMock=mockStudentDTO();
    }

    @Test
    void analyzeScores() {
        Mockito.when(iStudentDAO.findById(1l))
                .thenReturn(studentDTOMock);

        StudentDTO studentDTOResponse = underTest.analyzeScores(1l);

        double expected= 8.25;
        String messageExpected= "El alumno Juan ha obtenido un promedio de 8.25. Puedes mejorar.";

        assertEquals(studentDTOResponse.getAverageScore(),expected);
        assertEquals(studentDTOResponse.getMessage(),messageExpected);
    }

    private StudentDTO mockStudentDTO(){
        List<SubjectDTO> subjects= new ArrayList<>();
        SubjectDTO subject1= new SubjectDTO("Matematicas",6.5);
        SubjectDTO subject2= new SubjectDTO("Lengua",10d);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO student= new StudentDTO(1l,"Juan","No se",subjects.stream().collect(Collectors.averagingDouble(SubjectDTO::getScore)),subjects);
        return student;
    }
}