package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentControllerTest {
    @Mock
    IStudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    @DisplayName("Registrar alumno")
    void registerStudentTest() {
        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, null);

        studentController.registerStudent(studentMock);
        Mockito.verify(studentService, Mockito.times(1)).create(studentMock);
    }

    @Test
    @DisplayName("Get student by id")
    void getStudentByIdTest() {
        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, null);

        when(studentService.read(1L)).thenReturn(studentMock);

        Assertions.assertEquals(studentMock, studentController.getStudent(1L));
    }

    @Test
    @DisplayName("Modify student")
    void modifyStudentTest() {
        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, null);

        studentController.modifyStudent(studentMock);

        Mockito.verify(studentService, Mockito.times(1)).update(studentMock);
    }

    @Test
    @DisplayName("Remove student")
    void removeStudentTest() {
        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, null);

        studentController.removeStudent(1L);

        Mockito.verify(studentService, Mockito.times(1)).delete(1L);
    }

    @Test
    @DisplayName("List students")
    void listStudentsTest() {
        Set<StudentDTO> studentMock = Set.of(new StudentDTO(1L, "Juan", "", 0D, null));

        when(studentService.getAll()).thenReturn(studentMock);

        Assertions.assertEquals(studentMock, studentController.listStudents());

    }
}
