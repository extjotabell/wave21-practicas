package com.meli.obtenerdiploma.service;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TestStudentServiceWithMoch {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepo;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Leer un estudiante")
    void readStudent() {

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Quimica", 7.0));
        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 9.0));
        subjects.add(new SubjectDTO("Fisica", 9.0));
        subjects.add(new SubjectDTO("Artistica", 7.0));
        Long id = 1L;
        StudentDTO student = new StudentDTO(id, "juan", "soy juan", 0.0, subjects);
        when(studentService.read(id)).thenReturn(student);

        Assertions.assertEquals(student, studentDAO.findById(id));

    }

}
