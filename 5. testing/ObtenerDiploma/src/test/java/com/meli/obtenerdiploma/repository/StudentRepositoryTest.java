package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StudentRepositoryTest {
    @Autowired
    StudentRepository repoStudent;

    @Test
    @DisplayName("Camino triste find all")
    void findAll() {
        assertThrows(NullPointerException.class , () -> repoStudent.findAll());
    }
}