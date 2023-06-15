package com.meli.obtenerdiploma.unit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.unit.repository.IStudentDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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


    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();


    @Test
    public void analyzeScoresOk() throws JsonProcessingException {
        //arrange
        List<SubjectDTO> listMock = new ArrayList<>();
        listMock.add(new SubjectDTO("Matemática",9.0));
        listMock.add(new SubjectDTO("Fisica",10.0));
        StudentDTO studenMock = new StudentDTO(1L,"Pedro", null, null, listMock);

        StudentDTO studenExpected = new StudentDTO(1L,"Pedro", null, null, listMock);
        studenExpected.setAverageScore(9.5);
        studenExpected.setMessage("El alumno Pedro ha obtenido un promedio de 9.5. Felicitaciones!");

        // Mock Data Repo
        when(studentDAO.findById(1L)).thenReturn(studenMock);

        //act
        StudentDTO result = diplomaService.analyzeScores(1L);

        //assert
        assertEquals(writer.writeValueAsString(studenExpected), writer.writeValueAsString(result));
        assertEquals(studenExpected.getMessage(), result.getMessage());
        assertEquals(studenExpected.getAverageScore(), result.getAverageScore());

    }

    @Test
    public void analyzeScoresNoOk() throws JsonProcessingException {
        //arrange
        List<SubjectDTO> listMock = new ArrayList<>();
        listMock.add(new SubjectDTO("Matemática",2.0));
        listMock.add(new SubjectDTO("Fisica",3.0));
        StudentDTO studenMock = new StudentDTO(1L,"Pedro", null, null, listMock);


        StudentDTO studenExpected = new StudentDTO(1L,"Pedro", null, null, listMock);
        studenExpected.setAverageScore(2.5);
        studenExpected.setMessage("El alumno Pedro ha obtenido un promedio de 2.5. Puedes mejorar.");

        // Mock Data Repo
        when(studentDAO.findById(1L)).thenReturn(studenMock);

        //act
        StudentDTO result = diplomaService.analyzeScores(1L);

        //assert
        assertEquals(writer.writeValueAsString(studenExpected), writer.writeValueAsString(result));
        assertEquals(studenExpected.getMessage(), result.getMessage());
        assertEquals(studenExpected.getAverageScore(), result.getAverageScore());
    }

    @Test
    public void analyzeScoresNoOkThrowException(){
        //arrange
        Long idStudent = 21L;

        //act
        when(studentDAO.findById(idStudent)).thenThrow(StudentNotFoundException.class);

        //assert
        assertThrows(StudentNotFoundException.class,()-> diplomaService.analyzeScores(idStudent)); //Se comprueba con un id desconocido

    }

}
