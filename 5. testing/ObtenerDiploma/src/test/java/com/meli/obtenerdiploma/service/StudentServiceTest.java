package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.Assertions;
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
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

//    public StudentServiceTest(StudentService studentService) {
//        this.studentService = studentService;
//    }

    @Test
    @DisplayName("Crear usuario")
    void createTest() {
        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, null);

        studentService.create(studentMock);

        Mockito.verify(studentDAO, Mockito.times(1)).save(studentMock);
    }

    @Test
    @DisplayName("Leer usuario")
    void readTest() {
        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, null);

        when(studentDAO.findById(1L)).thenReturn(studentMock);

        Assertions.assertEquals(studentMock, studentService.read(1L));
    }

    @Test
    @DisplayName("Actualizar usuario")
    void updateTest() {
        StudentDTO studentMock = new StudentDTO(1L, "Juan", "", 0D, null);

        studentService.update(studentMock);

        Mockito.verify(studentDAO, Mockito.times(1)).save(studentMock);
    }

    @Test
    @DisplayName("Eliminar usuario")
    void deleteTest() {
        studentService.delete(1L);

        Mockito.verify(studentDAO, Mockito.times(1)).delete(1L);
    }

    @Test
    @DisplayName("Buscar todos")
    void findAllTest() {
        Set<StudentDTO> studentMock = Set.of(new StudentDTO(1L, "Juan", "", 0D, null));

        when(studentRepository.findAll()).thenReturn(studentMock);

        Assertions.assertEquals(studentMock, studentService.getAll());
    }
}
