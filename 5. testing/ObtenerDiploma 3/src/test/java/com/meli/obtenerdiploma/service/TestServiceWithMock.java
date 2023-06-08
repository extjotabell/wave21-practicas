package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import org.junit.jupiter.api.Assertions;
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
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestServiceWithMock {

@Mock
IStudentDAO studentDAO;

@InjectMocks
ObtenerDiplomaService diplomaService;

@Test
@DisplayName("Calcular el promedio de un estudiante")
void getAverage(){
    List<SubjectDTO> subjects = new ArrayList<>();
    subjects.add(new SubjectDTO("Quimica", 7.0));
    subjects.add(new SubjectDTO("Matematica", 8.0));
    subjects.add(new SubjectDTO("Lengua", 9.0));
    subjects.add(new SubjectDTO("Fisica", 9.0));
    subjects.add(new SubjectDTO("Artistica", 7.0));
    Long id = 1L;
    StudentDTO student = new StudentDTO(id, "juan","soy juan",0.0, subjects);
    when(studentDAO.findById(id)).thenReturn(student);
    StudentDTO expected = new StudentDTO(id, "juan","El alumno juan ha obtenido un promedio de 8. Puedes mejorar.",8.0, subjects);
    assertEquals(expected,diplomaService.analyzeScores(id));
}

@Test
@DisplayName("    Mensaje de Diploma con Honores.")
void getMessageWithHonors(){

    List<SubjectDTO> subjects = new ArrayList<>();
    subjects.add(new SubjectDTO("Quimica", 10.0));
    subjects.add(new SubjectDTO("Matematica", 10.0));
    subjects.add(new SubjectDTO("Lengua", 10.0));
    subjects.add(new SubjectDTO("Fisica", 10.0));
    subjects.add(new SubjectDTO("Artistica", 10.0));
    Long id = 1L;
    StudentDTO student = new StudentDTO(id, "juan","soy juan",0.0, subjects);
    when(studentDAO.findById(id)).thenReturn(student);
    StudentDTO expected = new StudentDTO(id, "juan","El alumno juan ha obtenido un promedio de 10. Felicitaciones!",10.0, subjects);
    assertEquals(expected,diplomaService.analyzeScores(id));
}

    @Test
    @DisplayName(" Lista Vacia.")
    void getEmptyList(){

        List<SubjectDTO> subjects = new ArrayList<>();
        Long id = 1L;
        StudentDTO student = new StudentDTO(id, "juan","soy juan",0.0, subjects);
        when(studentDAO.findById(id)).thenReturn(student);
        StudentDTO expected = new StudentDTO(id, "juan","El alumno juan ha obtenido un promedio de 0. Puedes mejorar.",0.0, subjects);
        assertEquals(expected,diplomaService.analyzeScores(id));
    }

}