package com.otenerdiploma.OtenerDiploma.Controller;

import com.otenerdiploma.OtenerDiploma.controller.StudentController;
import com.otenerdiploma.OtenerDiploma.model.StudentDTO;
import com.otenerdiploma.OtenerDiploma.model.SubjectDTO;
import com.otenerdiploma.OtenerDiploma.service.IStudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {
    @Mock
    private IStudentService studentService;
    @InjectMocks
    private StudentController controller;

    @Test
    void getStudentTest(){
        Long studentId = 1L;
        String studentName = "Juan";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 8.0));
        StudentDTO expectedStudent = new StudentDTO(studentId, studentName, null, null, subjects);
        when(studentService.read(studentId)).thenReturn(expectedStudent);

        StudentDTO result = controller.getStudent(studentId);

        assertNotNull(result);
        assertEquals(expectedStudent, result);
    }

    @Test
    void registerTest(){
        Long studentId = 1L;
        String studentName = "Juan";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 8.0));
        StudentDTO expectedStudent = new StudentDTO(studentId, studentName, null, null, subjects);

        ResponseEntity<?> response = controller.registerStudent(expectedStudent);
        assertNotNull(response);
        assertEquals(ResponseEntity.ok(null), response);
        verify(studentService, times(1)).create(expectedStudent);
    }

    @Test
    void modifyTest(){
        Long studentId = 1L;
        String studentName = "Juan";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 8.0));
        StudentDTO expectedStudent = new StudentDTO(studentId, studentName, null, null, subjects);

        ResponseEntity<?> response = controller.modifyStudent(expectedStudent);
        assertNotNull(response);
        assertEquals(ResponseEntity.ok(null), response);
        verify(studentService, times(1)).update(expectedStudent);
    }

    @Test
    void removeTest(){
        Long studentId = 1L;

        ResponseEntity<?> response = controller.removeStudent(studentId);

        assertNotNull(response);
        assertEquals(ResponseEntity.ok(null), response);
        verify(studentService, times(1)).delete(studentId);
    }

    @Test
    void listStudentsTest(){
        Set<StudentDTO> listaMock = new HashSet<>();
        List<SubjectDTO> subjects1 = new ArrayList<>();
        subjects1.add(new SubjectDTO("Matematicas", 9.5));
        subjects1.add(new SubjectDTO("Historia", 8.0));
        StudentDTO student1 = new StudentDTO(1L, "Karla", null, null, subjects1);
        StudentDTO student2 = new StudentDTO(2L, "Andres", null, null, subjects1);
        StudentDTO student3 = new StudentDTO(3L, "Merry", null, null, subjects1);
        listaMock.add(student1);
        listaMock.add(student2);
        listaMock.add(student3);

        Set<StudentDTO> expected = new HashSet<>();
        expected.add(student1);
        expected.add(student2);
        expected.add(student3);

        when(studentService.getAll()).thenReturn(listaMock);

        Set<StudentDTO> result = controller.listStudents();

        assertNotNull(result);
        assertEquals(expected, result);
        verify(studentService, times(1)).getAll();
    }
}
