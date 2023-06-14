package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO _iStudentDao;
    @Mock
    IStudentRepository _iStudentRepository;

    @InjectMocks
    StudentService _studetService;

    @Test
    @DisplayName("US0001-Camino OK createTest")
    void createTestOk() {

        //arrange
        StudentDTO expected = new StudentDTO(23L, "Marielena", "", 8.3, new ArrayList<>());

        //Act
        _studetService.create(expected);

        //Assert
        verify(_iStudentDao, times(1)).save(expected);

    }

    @Test
    @DisplayName("US0002-Camino OK Read Test")
    void readTestOk() {

        //Arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(23L, "Marielena", "", 8.3, new ArrayList<>());

        when(_iStudentDao.findById(studentId)).thenReturn(expected);
        //Act
        StudentDTO result = _studetService.read(studentId);
        //Assert
        assertEquals(expected, result);

    }

    @Test
    @DisplayName("US0003-Camino OK Update Test")
    void updateTestOk() {

        //Arrange
        StudentDTO expected = new StudentDTO(23L, "Marielena", "", 8.3, new ArrayList<>());

        //Act
        _studetService.update(expected);

        //Assert
        verify(_iStudentDao, times(1)).save(expected);

    }

    @Test
    @DisplayName("US0004- Camino OK Delete Test")
    void deleteTestOK() {
        //Arrange
        Long studentId = 23L;
        StudentDTO expected = new StudentDTO(23L, "Marielena", "", 8.3, new ArrayList<>());

        //Act
        _studetService.delete(studentId);

        //Assert
        verify(_iStudentDao).delete(studentId);
    }


    @Test
    @DisplayName("US0005 - Camino OK get all Test")
    void getAllTestOk() {

        //Arrange
        Set<StudentDTO> expected = new HashSet<>();

        when(_iStudentRepository.findAll()).thenReturn(expected);
        //Act
        Set<StudentDTO> result = _iStudentRepository.findAll();
        //Assert
        assertEquals(expected, result);
    }


}
