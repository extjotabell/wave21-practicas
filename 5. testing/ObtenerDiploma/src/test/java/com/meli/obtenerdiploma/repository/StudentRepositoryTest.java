package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentRepositoryTest {
    StudentRepository studentRepository;

    public StudentRepositoryTest() {
        studentRepository = new StudentRepository();
    }

    @Test
    public void findAllTest() {
        System.out.println(studentRepository.findAll());
        assertTrue(studentRepository.findAll().size() > 0);
    }
}
