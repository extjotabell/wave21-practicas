package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {
    IStudentDAO repository;

    @BeforeEach
    void setup(){
        repository = new StudentDAO();
    }

    @Test
    @DisplayName("Save Test")
    void saveTestOk() {
        //Arrange
        StudentDTO expected = new StudentDTO(0L, "Javier", "", 8.0, new ArrayList<>());
        //Act
        repository.save(expected);
        StudentDTO result = repository.findById(expected.getId());
        //Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Find By ID Test")
    void findByIdestOk() {
        //Arrange
        StudentDTO expected = new StudentDTO(0L, "Javier", "", 8.0, new ArrayList<>());
        //Act
        repository.save(expected);
        StudentDTO result = repository.findById(expected.getId());
        //Assert
        assertNotNull(result);
    }

    @Test
    @DisplayName("Delete Test")
    void deleteTestOk() {
        //Arrange
        StudentDTO expected = new StudentDTO(0L, "Javier", "", 8.0, new ArrayList<>());
        //Act
        repository.save(expected);
        boolean rep = repository.delete(expected.getId());
        //Assert
        assertTrue(rep);
    }

    @Test
    @DisplayName("Exists Test")
    void existsTestOk() {
        //Arrange
        StudentDTO expected = new StudentDTO(23L, "Javier", "", 8.0, new ArrayList<>());
        //Act
        repository.save(expected);
        boolean ret = repository.exists(expected);
        //Assert
        assertTrue(ret);

    }
}
