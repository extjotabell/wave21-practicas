package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    // Ejercicio #5

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("registerStudent Controller")
    public void registerStudentControllerTest(){
        StudentDTO studentMock = getStudentDTOMock();
        studentController.registerStudent(studentMock);
        when(studentService.getAll()).thenReturn(new HashSet<>(List.of(studentMock)));
        Set<StudentDTO> response = studentService.getAll();
        boolean contains = response.contains(studentMock);
        assertTrue(contains);
    }

    @Test
    @DisplayName("getStudent - Controller")
    public void getStudentControllerTest(){
        StudentDTO studentMock = getStudentDTOMock();
        when(studentService.read(studentMock.getId())).thenReturn(studentMock);
        StudentDTO response = studentController.getStudent(studentMock.getId());
        assertSame(studentMock,response);
    }

    @Test
    @DisplayName("modifyStudent Controller")
    public void modifyStudentControllerTest(){
        StudentDTO studentMock = getStudentDTOMock();
        studentController.modifyStudent(studentMock);
        when(studentService.getAll()).thenReturn(new HashSet<>(List.of(studentMock)));
        Set<StudentDTO> response = studentService.getAll();
        boolean contains = response.contains(studentMock);
        assertTrue(contains);
    }

    @Test
    @DisplayName("removeStudent Controller")
    public void removeStudentControllerTest(){
        StudentDTO studentMock = getStudentDTOMock();
        studentController.modifyStudent(studentMock);
        studentController.removeStudent(studentMock.getId());
        Set<StudentDTO> response = studentService.getAll();
        assertTrue(response.isEmpty());
    }

    @Test
    @DisplayName("listStudents Controller")
    public void listStudentsControllerTest() {
        StudentDTO studentMock = getStudentDTOMock();
        when(studentService.getAll()).thenReturn(new HashSet<>(List.of(studentMock)));
        Set<StudentDTO> response = studentController.listStudents();
        Object[] responseArray = response.toArray();
        assertSame(responseArray[0], studentMock);
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