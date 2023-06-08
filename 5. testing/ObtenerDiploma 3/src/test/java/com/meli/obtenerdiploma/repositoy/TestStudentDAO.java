package com.meli.obtenerdiploma.repositoy;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class TestStudentDAO {
    @Autowired
    IStudentDAO studentDAO;
    @Autowired
    IStudentRepository studentRepository;
    @Autowired
    IStudentService studentService;

    @Test
    @DisplayName("Camino Feliz crear estudiante...")
    void readStudentByID(){
        Long id = 1L;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Quimica", 7.0));
        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 9.0));
        subjects.add(new SubjectDTO("Fisica", 9.0));
        subjects.add(new SubjectDTO("Artistica", 7.0));
        StudentDTO user = new StudentDTO(1L, "juan","soy juan",0.0, subjects);
        studentService.create(user);
        StudentDTO espected = new StudentDTO(id, "juan","soy juan",0.0, subjects);

        assertEquals(espected,studentService.read(id));



    }
    @Test
    @DisplayName("Modifico info del estudiante")
    void modifyDataFromStudent(){
        Long id = 1L;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Quimica", 7.0));
        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 9.0));
        subjects.add(new SubjectDTO("Fisica", 9.0));
        subjects.add(new SubjectDTO("Artistica", 7.0));
        StudentDTO user = new StudentDTO(1L, "juan","soy juan",0.0, subjects);
        studentService.create(user);
        user.setStudentName("Rogelio");
        studentService.update(user);
        StudentDTO espected = new StudentDTO(id, "Rogelio","soy juan",0.0, subjects);

        assertEquals(espected,studentService.read(id));



    }
}
