package com.meli.obtenerdiploma.RepositoryTest;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RepositoryStudentTest {
    @Autowired
    IStudentRepository repo;

    @Test
    void findAllOk()
    {
        assertThrows(IOException.class,()->{
            repo.findAll();
        });
    }

    @Test
    void findAllFileNotFound()
    {
        assertThrows(FileNotFoundException.class,()->{
            repo.findAll();
        });
    }

    @Test
    void findAllIOException()
    {

    }
}
