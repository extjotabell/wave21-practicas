package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    //Ejercicio #3

    @Mock
    StudentDAO studentDAO;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Create")
    public void createTest(){
        StudentDTO student = getStudentDTOMock();
        studentService.create(student);
        when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO studentDTO = studentDAO.findById(student.getId());
        assertSame(studentDTO, student);
    }

    @Test
    @DisplayName("Read")
    public void readTest(){
        StudentDTO student = getStudentDTOMock();
        studentService.create(student);
        when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO studentDTO = studentService.read(student.getId());
        assertSame(student, studentDTO);
    }

    @Test
    @DisplayName("Update")
    public void updateTest(){
        StudentDTO student = getStudentDTOMock();
        studentService.update(student);
        when(studentDAO.findById(student.getId())).thenReturn(student);
        StudentDTO studentDTO = studentDAO.findById(student.getId());
        assertSame(studentDTO, student);
    }

    @Test
    @DisplayName("Delete")
    public void deleteTest(){
        StudentDTO student = getStudentDTOMock();
        when(studentDAO.delete(student.getId())).thenReturn(false);
        studentService.delete(student.getId());
    }

    @Test
    @DisplayName("GetAll")
    public void getAllTest(){
        when(studentRepository.findAll()).thenReturn(Collections.emptySet());
        Set<StudentDTO> response = studentService.getAll();
        assertTrue(response.isEmpty());
    }

    private StudentDTO getStudentDTOMock(){
        StudentDTO student = new StudentDTO();
        student.setId(1L);
        student.setStudentName("Jose");
        student.setMessage("El alumno Pepito ha obtenido un promedio de 10.00. Felicitaciones!"); //llenar las 2
        student.setAverageScore(10D);
        student.setSubjects(Arrays.asList(new SubjectDTO("Fisica",10D), new SubjectDTO("Quimica", 10D)));
        return student;
    }
}
