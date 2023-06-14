package com.otenerdiploma.OtenerDiploma.Unit.Repository;

import com.otenerdiploma.OtenerDiploma.model.StudentDTO;
import com.otenerdiploma.OtenerDiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class StudentRepositoryTest {
    @Autowired
    private IStudentRepository repository;

    @Test
    public void testFinAll() throws Exception {
        Set<StudentDTO> students = repository.findAll();

        assertEquals(3, students.size());
        assertFalse(students.isEmpty());
        assertNotNull(students);
    }
}
