package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

   @InjectMocks
   StudentDAO studentDAO;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        StudentDAO studentDAO = new StudentDAO();
    }

    @Test
    @DisplayName("save happy path")
    void saveTest() {
        Set<StudentDTO> mockeado = new HashSet<>();

        StudentDTO student1 = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));

        studentDAO.save(student1);
        assertTrue(studentDAO.getStudents().contains(student1));
    }

    @Test
    @DisplayName("Delete happy path")
    void deleteTest() {

        Set<StudentDTO> mockeado = new HashSet<>();

        StudentDTO student1 = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        StudentDTO student2 = new StudentDTO(2L, "Pedro", Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));
    mockeado.add(student1);
    mockeado.add(student2);
        //Mockito.when(studentDAO.findById(1L)).thenReturn();
        studentDAO.setStudents(mockeado);
        assertTrue(studentDAO.delete(1L));
    }

    @Test
    @DisplayName("Exist happy path")
    void existsTest() {
        //Arrange
        Set<StudentDTO> mockeado = new HashSet<>();

        StudentDTO student1 = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        StudentDTO student2 = new StudentDTO(2L, "Pedro", Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));
        mockeado.add(student1);
        mockeado.add(student2);
        studentDAO.setStudents(mockeado);
        StudentDTO studentExpected = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        //Act y Assert
        assertTrue(studentDAO.exists(studentExpected));
    }

    @Test
    @DisplayName("Find By ID happy path")
    void findByIdTest() {
        Set<StudentDTO> mockeado = new HashSet<>();

        StudentDTO student1 = new StudentDTO(1L, "Juan", Arrays.asList(
                new SubjectDTO("Matemática", 9.0),
                new SubjectDTO("Física", 7.0),
                new SubjectDTO("Química", 6.0)
        ));
        StudentDTO student2 = new StudentDTO(2L, "Pedro", Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));
        mockeado.add(student1);
        mockeado.add(student2);
        studentDAO.setStudents(mockeado);
        //Arrange
        StudentDTO expected = new StudentDTO(2L, "Pedro", Arrays.asList(
                new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0),
                new SubjectDTO("Química", 4.0)
        ));
        //Act
        StudentDTO result = studentDAO.findById(2L);
        //Assert
        assertEquals(expected, result);
    }
}