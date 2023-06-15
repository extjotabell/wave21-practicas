package com.meli.obtenerdiploma.unit.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ObtenerDiplomaServiceTestSinMock {

    @Autowired
    IStudentDAO studentDAO = new StudentDAO();

    @Autowired
    ObtenerDiplomaService diplomaService;

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();

    @Test
    @DisplayName("")
    public void analyzeScoresOk() throws JsonProcessingException{
        //arrange
        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(new SubjectDTO("Matemática",9.0));
        listSubjects.add(new SubjectDTO("Fisica",10.0));

        StudentDTO studenExpected = new StudentDTO(8L,"Pedro", null, null, listSubjects);
        studenExpected.setAverageScore(9.5);
        studenExpected.setMessage("El alumno Pedro ha obtenido un promedio de 9.5. Felicitaciones!");


        //act
        StudentDTO result = diplomaService.analyzeScores(2L);

        //assert
        assertEquals(writer.writeValueAsString(studenExpected), writer.writeValueAsString(result));
        assertEquals(studenExpected.getMessage(), result.getMessage());
        assertEquals(studenExpected.getAverageScore(), result.getAverageScore());

    }


    @Test
    public void analyzeScoresNoOk() throws JsonProcessingException {
        //arrange
        List<SubjectDTO> listSubjects = new ArrayList<>();
        listSubjects.add(new SubjectDTO("Matemática",2.0));
        listSubjects.add(new SubjectDTO("Fisica",3.0));



        StudentDTO studenExpected = new StudentDTO(2L,"Pedro", null, null, listSubjects);
        studenExpected.setAverageScore(2.5);
        studenExpected.setMessage("El alumno Pedro ha obtenido un promedio de 2.5. Puedes mejorar.");


        //act
        StudentDTO result = diplomaService.analyzeScores(1L);

        //assert
        assertEquals(writer.writeValueAsString(studenExpected), writer.writeValueAsString(result));
        assertEquals(studenExpected.getMessage(), result.getMessage());
        assertEquals(studenExpected.getAverageScore(), result.getAverageScore());
    }
}
