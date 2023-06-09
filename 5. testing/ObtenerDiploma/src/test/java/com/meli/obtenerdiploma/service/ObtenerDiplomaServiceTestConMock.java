package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ObtenerDiplomaServiceTestConMock {
    @InjectMocks
    ObtenerDiplomaService diplomaService;

    @Mock
    IStudentDAO studentDAO;

    @Test
    public void obtenerEstudianteOk(){
        //arrange
        List<SubjectDTO> listMock = new ArrayList<>();
        listMock.add(new SubjectDTO("Matemática",9.0));
        listMock.add(new SubjectDTO("Fisica",10.0));
        StudentDTO studenMock = new StudentDTO(1L,"Pedro", null, null, listMock);

        StudentDTO studenExpected = studenMock;
        when(studentDAO.findById(1L)).thenReturn(studenMock);
        //act
        StudentDTO result = diplomaService.analyzeScores(1L);
        //assert
        assertEquals(studenExpected, result);
    }

    @Test
    public void obtenerEstudianteNoOk(){
        //arrange
        List<SubjectDTO> listMock = new ArrayList<>();
        listMock.add(new SubjectDTO("Matemática",9.0));
        listMock.add(new SubjectDTO("Fisica",10.0));
        StudentDTO studenMock = new StudentDTO(2L,"Pedro", null, null, listMock);

        //act
        when(studentDAO.findById(1L)).thenThrow(StudentNotFoundException.class);
        //assert
        assertThrows(StudentNotFoundException.class,()-> diplomaService.analyzeScores(1L)); //Se comprueba con un id desconocido
    }
}
