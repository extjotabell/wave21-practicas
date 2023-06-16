package com.meli.obtenerdiploma.unittest.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class StudentRepositoryTest {

    @Mock
    IStudentDAO studentDAO;

    @InjectMocks
    StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSaveWithNullStudent() {
        assertThrows(IllegalArgumentException.class, () -> studentRepository.save(null));
    }

    @Test
    void testSaveWithValidStudent() {
        StudentDTO studentDTO = new StudentDTO(); // Use a valid StudentDTO

        when(studentDAO.save(studentDTO)).thenReturn(studentDTO);

        StudentDTO savedStudent = studentRepository.save(studentDTO);

        assertEquals(studentDTO, savedStudent);
    }

    @Test
    void testFindByIdWithInvalidId() {
        Long invalidId = -1L;

        when(studentDAO.findById(invalidId)).thenReturn(Optional.empty());

        Optional<StudentDTO> student = studentRepository.findById(invalidId);

        assertFalse(student.isPresent());
    }

    @Test
    void testFindByIdWithValidId() {
        Long validId = 1L;
        StudentDTO studentDTO = new StudentDTO(); // Use a valid StudentDTO

        when(studentDAO.findById(validId)).thenReturn(Optional.of(studentDTO));

        Optional<StudentDTO> student = studentRepository.findById(validId);

        assertTrue(student.isPresent());
        assertEquals(studentDTO, student.get());
    }

    @Test
    void testDeleteWithValidId() {
        Long validId = 1L;

        when(studentDAO.delete(validId)).thenReturn(true);

        boolean result = studentRepository.delete(validId);

        assertTrue(result);
    }

    @Test
    void testDeleteWithInvalidId() {
        Long invalidId = -1L;

        when(studentDAO.delete(invalidId)).thenReturn(false);

        boolean result = studentRepository.delete(invalidId);

        assertFalse(result);
    }

    @Test
    void testFindAllWhenNoStudents() {
        when(studentDAO.findAll()).thenReturn(new HashSet<>());

        Set<StudentDTO> students = studentRepository.findAll();

        assertTrue(students.isEmpty());
    }

    @Test
    void testFindAllWithStudents() {
        Set<StudentDTO> studentSet = new HashSet<>();
        studentSet.add(new StudentDTO()); // Add a valid StudentDTO

        when(studentDAO.findAll()).thenReturn(studentSet);

        Set<StudentDTO> students = studentRepository.findAll();

        assertEquals(studentSet, students);
    }
}


