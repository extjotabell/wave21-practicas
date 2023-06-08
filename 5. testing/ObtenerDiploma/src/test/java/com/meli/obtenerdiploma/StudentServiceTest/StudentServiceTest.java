package com.meli.obtenerdiploma.StudentServiceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
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
    StudentRepository IStudentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Read Test")
    void readTest(){
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
    @DisplayName("Get All Test")
    void getAllTest(){      //El test está fallando :(
        //Arrange
        Set<StudentDTO> expected = new HashSet<>();
        when(IStudentRepository.findAll()).thenReturn(expected);
        //Act
        Set<StudentDTO> result = studentService.getAll();
        //Assert
        assertEquals(expected, result);
    }
}
