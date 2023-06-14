package com.meli.obtenerdiploma.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    @Autowired
    StudentDAO studentDAO;
    @Test
    void findById() {
        studentDAO.findById();
    }
}