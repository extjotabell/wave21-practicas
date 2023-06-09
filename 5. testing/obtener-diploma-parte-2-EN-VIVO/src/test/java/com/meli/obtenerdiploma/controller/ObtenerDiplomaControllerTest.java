package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTest {

    // Ejercicio #4

    @Mock
    ObtenerDiplomaService obtenerDiplomaService;

    @InjectMocks
    ObtenerDiplomaController obtenerDiplomaController;

    @Test
    @DisplayName("Controller")
    public void obtenerDiplomaControllerTest(){
        StudentDTO studentMock = getStudentDTOMock();
        when(obtenerDiplomaService.analyzeScores(studentMock.getId())).thenReturn(studentMock);
        StudentDTO response = obtenerDiplomaController.analyzeScores(studentMock.getId());
        assertSame(studentMock,response);
    }

    private StudentDTO getStudentDTOMock(){
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Jose");
        student.setMessage("El alumno Pepito ha obtenido un promedio de 10.00. Felicitaciones!"); //llenar las 2
        student.setAverageScore(10D);
        student.setSubjects(Arrays.asList(new SubjectDTO("Fisica",10D), new SubjectDTO("Quimica", 10D)));
        return student;
    }
}
