package com.meli.obtenerdiploma.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.exception.ObtenerDiplomaException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.util.ResourceUtils;

import javax.xml.transform.Result;

import java.io.File;
import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class StudentRepositoryTest {
    IStudentRepository studentRepository;
    StudentDAO studentDAO;

    @Mock
    File file;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        studentRepository = new StudentRepository();
    }

    @Test
    @DisplayName("empty list")
    void findAll() throws IOException {
        // arrange
        try (MockedStatic<ResourceUtils> utilities = Mockito.mockStatic(ResourceUtils.class)) {
            utilities.when(() -> ResourceUtils.getFile(""))
                    .thenReturn(new File(""));
        }

        Set<StudentDTO> expected = new HashSet<>();
        // act
        Set<StudentDTO> actual = studentRepository.findAll();
        // assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Find all happt path")
    void findAllOK() throws IOException {
        // arrange

        Set<StudentDTO> expected = new HashSet<>();

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
        expected.add(student1);
        expected.add(student2);

        // act
        Set<StudentDTO> actual = studentRepository.findAll();
        // assert
        assertEquals(expected, actual);
    }
}