package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {
    IStudentDAO repository;

    @BeforeEach
    void setup(){
        repository = new StudentDAO();
    }

    @Test
    @Disabled
    @DisplayName("StudentDAO Test BadPath")
    void studentDAOTestOk() {
        //Arrange
        Set<StudentDAO> studentDAOSet = new HashSet<>();
        //Act
        //Assert
        assertThrows(IOException.class, () -> {
            studentDAOSet.size();
        });
    }

    @Test
    @DisplayName("Save Test HappyPath")
    void saveTestOk() {
        //Arrange
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));
        //Act
        repository.save(expected);
        StudentDTO result = repository.findById(expected.getId());
        //Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Find By ID Test HappyPath")
    void findByIdestOk() {
        //Arrange
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));
        //Act
        repository.save(expected);
        StudentDTO result = repository.findById(expected.getId());
        //Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Delete Test HappyPath")
    void deleteTestOk() {
        //Arrange
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));
        //Act
        repository.save(expected);
        boolean rep = repository.delete(expected.getId());
        //Assert
        assertTrue(rep);
    }

    @Test
    @DisplayName("Exists Test HappyPath")
    void existsTestOk() {
        //Arrange
        StudentDTO expected = new StudentDTO(1L, "Juan", "", 0.00, List.of(new SubjectDTO("Matematica", 9.50)));
        //Act
        repository.save(expected);
        boolean ret = repository.exists(expected);
        //Assert
        assertTrue(ret);

    }
}
