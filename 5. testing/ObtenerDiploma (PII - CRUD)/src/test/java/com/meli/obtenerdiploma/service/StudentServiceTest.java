package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;

    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        StudentDAO studentDAO = new StudentDAO();
    }

    @Test
    void createTest() {
        //Arrange
        StudentDTO mockeado = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        //Act
        doNothing().when(studentDAO).save(mockeado);
        studentService.create(mockeado);

        // Assert
        verify(studentDAO, Mockito.times(1)).save(mockeado);
    }

    @Test
    void readTest() {
        //Arrange
        StudentDTO mockeado = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        StudentDTO expected = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        //Act
        Mockito.when(studentDAO.findById(1L)).thenReturn(mockeado);
        //Assert
        assertEquals(expected, studentService.read(1L));
    }

    @Test
    void updateTest() {
        //Arrange
        StudentDTO mockeado = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        //Act
        doNothing().when(studentDAO).save(mockeado);
        studentService.update(mockeado);

        // Assert
        verify(studentDAO, Mockito.times(1)).save(mockeado);
    }

    @Test
    void deleteTest() {
        //Arrange
        Long id = 1L;

        //Act
        Mockito.when(studentDAO.delete(1L)).thenReturn(true);
        studentService.delete(id);

        // Assert
        verify(studentDAO, Mockito.times(1)).delete(id);
    }

    @Test
    void getAllTest() {
        //Arrange
        Set<StudentDTO> mockStudents = new HashSet<>();
        StudentDTO mockeado1 = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        StudentDTO mockeado2 = new StudentDTO(1L, "Pedro", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        mockStudents.add(mockeado1);
        mockStudents.add(mockeado2);
        StudentDTO expected1 = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        StudentDTO expected2 = new StudentDTO(1L, "Pedro", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        Set<StudentDTO> expectedStudents = new HashSet<>();
        expectedStudents.add(expected1);
        expectedStudents.add(expected2);
        //Act
        Mockito.when(studentRepository.findAll()).thenReturn(mockStudents);
        //Assert
        assertEquals(expectedStudents, studentService.getAll());
    }
}