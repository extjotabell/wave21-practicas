package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.ApplicationContextTestUtils;

import javax.security.auth.Subject;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Create-Camino Feliz :D")
    public void createTestOK(){
        //ARRANGE
        StudentDTO expected = new StudentDTO(10L,"Juan","HOla soy Juan", 7.6,
                List.of(new SubjectDTO("Matemtaticas",7.8),new SubjectDTO("Historia",9.0)));

        //ACT
        studentService.create(expected);
        //ASSERT
        verify(studentDAO).save(expected);
    }

    @Test
    @DisplayName("Read-Camino Feliz :D")
    public void readTestOK(){

        //ARRANGE
        long studentId = 10;
        StudentDTO expected = new StudentDTO(studentId,"Juan","HOla soy Juan", 7.6,
                                List.of(new SubjectDTO("Matemtaticas",7.8),new SubjectDTO("Historia",9.0)));
        when(studentDAO.findById(studentId)).thenReturn(expected);

        //ACT
        StudentDTO result = studentService.read(studentId);

        //ASSERT
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("GetAll-Camino Feliz :D")
    public void getAllTestOK(){
        //ARRANGE
        Set<StudentDTO> setsStudentDTOMock = new HashSet<>();

        setsStudentDTOMock.add(new StudentDTO( 10L,"Jose","Hola soy Jose", 3.2,
                List.of(new SubjectDTO("Matemtaticas",7.8),
                    new SubjectDTO("Historia",9.0))));

        setsStudentDTOMock.add(new StudentDTO(12L,"Paz", "Hola soy Paz", 2.5,
                List.of(new SubjectDTO("Matemtaticas",7.8),
                new SubjectDTO("Historia",9.0))));

        setsStudentDTOMock.add(new StudentDTO(23L,"Emilio", "Hola soy Emilio", 3.0,
                List.of(new SubjectDTO("Matemtaticas",7.8),
                new SubjectDTO("Historia",9.0))));

        Set<StudentDTO> expected = new HashSet<>();

        expected.add(new StudentDTO( 10L,"Jose","Hola soy Jose", 3.2,
                List.of(new SubjectDTO("Matemtaticas",7.8),
                        new SubjectDTO("Historia",9.0))));

        expected.add(new StudentDTO(12L,"Paz", "Hola soy Paz", 2.5,
                List.of(new SubjectDTO("Matemtaticas",7.8),
                        new SubjectDTO("Historia",9.0))));

        expected.add(new StudentDTO(23L,"Emilio", "Hola soy Emilio", 3.0,
                List.of(new SubjectDTO("Matemtaticas",7.8),
                        new SubjectDTO("Historia",9.0))));

        when(studentRepository.findAll()).thenReturn(setsStudentDTOMock);
        //ACT
        Set<StudentDTO> result = studentService.getAll();
        //ASSERT

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Update-Camino Feliz :D")
    public void updateTestOK(){
        StudentDTO expected = new StudentDTO(10L,"Juan","HOla soy Juan", 7.6,
                List.of(new SubjectDTO("Matemtaticas",7.8),new SubjectDTO("Historia",9.0)));

        //ACT
        studentService.update(expected);
        //ASSERT
        verify(studentDAO).save(expected);
    }

    @Test
    @DisplayName("Delete-Camino Feliz :D")
    public void deleteTestOK(){
        Long id = 10L;
        //ACT
        studentService.delete(id);
        //ASSERT
        verify(studentDAO).delete(id);
    }
}
