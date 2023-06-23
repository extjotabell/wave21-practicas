package com.meli.obtenerdiploma.service;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepo;

    @InjectMocks
    StudentService studentService;

    StudentDTO student;

    @BeforeEach
    void setup(){
        init();
    }



    @Test
    @DisplayName("Leer un estudiante")
    void readStudentTest() {
        Long id = 1L;

        when(studentDAO.findById(id)).thenReturn(student);

        Assertions.assertEquals(student, studentDAO.findById(id));

    }

    @Test
    @DisplayName("Consultar todos los estudiantes estudiantes")
    void getAllStudentTest(){
    Set<StudentDTO> estudiantes = new HashSet<>();
    estudiantes.add(student);
    StudentDTO stu2 = student;
    stu2.setId(3l);
    estudiantes.add(stu2);

        when(studentRepo.findAll()).thenReturn(estudiantes);
        assertEquals(studentService.getAll(),estudiantes);
    }

    public void init(){

        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Quimica", 7.0));
        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 9.0));
        subjects.add(new SubjectDTO("Fisica", 9.0));
        subjects.add(new SubjectDTO("Artistica", 7.0));
        Long id = 1L;
        student = new StudentDTO(id, "juan", "soy juan", 0.0, subjects);
    }

}
