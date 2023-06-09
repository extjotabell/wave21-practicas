package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class StudentRepositoryTest {
    IStudentRepository repository;

    @BeforeEach
    void setup(){
        repository = new StudentRepository();
    }

    @Test
    @Disabled
    @DisplayName("Find All Test BadPath")
    void findAllTestBadPath() {
        //Arrange
        Set<StudentDTO> loadedData = new HashSet<>();
        //Act
        //Assert
        assertThrows(FileNotFoundException.class, () -> repository.findAll());

    }
}
