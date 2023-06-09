package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentDAO IStudentDAO;
    @Mock
    StudentRepository IStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Create Test HappyPath")
    void createTestOk(){
        //Arrange
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));
        //Act
        studentService.create(expected);
        //Assert
        verify(IStudentDAO, times(1)).save(expected);
    }

    @Test
    @DisplayName("Read Test HappyPath")
    void readTestOk(){
        //Arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));
        when(IStudentDAO.findById( any() )).thenReturn(expected);
        //Act
        StudentDTO result = studentService.read(studentId);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Update Test HappyPath")
    void updateTestOk(){
        //Arrange
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));
        //Act
        studentService.update(expected);
        //Assert
        verify(IStudentDAO, times(1)).save(expected);

    }

    @Test
    @DisplayName("Delete Test HappyPath")
    void deleteTestOk(){
        //Arrange
        long idExpected = 1;
        //Act
        studentService.delete(idExpected);
        //Assert
        verify(IStudentDAO, times(1)).delete(idExpected);
    }

    @Test
    @DisplayName("Get All Test HappyPath")
    void getAllTestOk(){
        //Arrange
        Set<StudentDTO> expected = new HashSet<>();
        when(IStudentRepository.findAll()).thenReturn(expected);
        //Act
        Set<StudentDTO> result = studentService.getAll();
        //Assert
        assertEquals(expected, result);
    }
}
