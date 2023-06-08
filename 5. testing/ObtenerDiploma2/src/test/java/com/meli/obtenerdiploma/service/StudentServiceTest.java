package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    StudentDAO IStudentDAO;
    @Mock
    StudentRepository IStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Create Test")
    void createTestOk(){
        //Arrange
        StudentDTO expected = new StudentDTO(23L, "Javier", "", 8.0, new ArrayList<>());
        //Act
        studentService.create(expected);
        //Assert
        verify(IStudentDAO, times(1)).save(expected);
    }

    @Test
    @DisplayName("Update Test")
    void updateTestOk(){
        //Arrange
        StudentDTO expected = new StudentDTO(23L, "Javier", "", 8.0, new ArrayList<>());
        //Act
        studentService.update(expected);
        //Assert
        verify(IStudentDAO, times(1)).save(expected);
    }

    @Test
    @DisplayName("Read Test")
    void readTestOk(){
        //Arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(23L, "Javier", "", 8.0, new ArrayList<>());
        when(IStudentDAO.findById( any() )).thenReturn(expected);
        //Act
        StudentDTO result = studentService.read(studentId);
        //Assert
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Delete Test")
    void deleteTestOk(){
        //Arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(23L, "Javier", "", 8.0, new ArrayList<>());
        //Act
        studentService.delete(studentId);
        //Assert
        verify(IStudentDAO).delete(studentId);
    }

    @Test
    @DisplayName("Get All Test")
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
