package com.meli.obtenerdiploma.unit.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class StudentRepositoryTest {

    @Autowired
    IStudentRepository studentRepository = new StudentRepository();

    @Test
    @DisplayName("Obtener todos los estudiantes")
    public void findAllOk() {
        //ARRANGE
        Set<StudentDTO> allStudent;

        //ACT
        allStudent = studentRepository.findAll();

        //ASSERT
        Assertions.assertNotNull(allStudent);
        Assertions.assertNotEquals(0, allStudent.size());
    }

    @Test
    @DisplayName("Obtener lista vacia de estudiantes")
    public void findAllNoOk() {
        //ARRANGE
        Set<StudentDTO> allStudent;

        //ACT
        allStudent = studentRepository.findAll();

        //ASSERT
        Assertions.assertNotNull(allStudent);
        Assertions.assertEquals(0, allStudent.size());
    }
}
