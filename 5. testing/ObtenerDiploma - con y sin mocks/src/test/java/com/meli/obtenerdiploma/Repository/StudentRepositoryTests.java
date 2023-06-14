package com.meli.obtenerdiploma.Repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.*;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class StudentRepositoryTests {
     StudentRepository repository;

    @BeforeEach
    public void beforeAll() {
        repository = new StudentRepository();
    }

    @Test
    //esto esta correctamente testeado?
    public void allStudentsAreOk() {
       //Arrange
        Set<StudentDTO> actual = repository.findAll();

        //Act -> no tiene ninguna
        Set<StudentDTO> expected = new HashSet<>();
        //Assert

        //assert
        Assertions.assertEquals(expected, actual);


    }

    //no sé como testear esto
    @Test
    public void fileIsNotFound() {


        //Act -> no tiene ninguna

        //Assert

        //assert
        Assertions.assertThrows(FileNotFoundException.class,() -> repository.findAll());
    }

    //me falta probar la otra excepcion pero no sé como generarla

}
