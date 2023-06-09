package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

class StudentRepositoryTest {

    IStudentRepository underTest;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        underTest= new StudentRepository();
    }

    @Test
    void findAll() {

        Set<StudentDTO> setResponse = underTest.findAll();

        assertTrue(setResponse.isEmpty());
        assertTrue(setResponse!=null);
    }
}