package com.meli.obtenerdiploma.unittest.service;


import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.security.auth.Subject;
import static org.junit.jupiter.api.Assertions.assertEquals ;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    @DisplayName("Guardado de usuario satisfactorio")
    public void createOK() {
        //arrange
        SubjectDTO s1 = new SubjectDTO("Matematica", 8.2);
        SubjectDTO s2 = new SubjectDTO("Quimica", 7.2);
        StudentDTO stu = new StudentDTO("Gabriel", "", 0.0,List.of(s1,s2));

        //act
        studentService.create(stu);

        //assert
        //verifico que se llame por lo menos una vez, al metodo save
        // con el argumento stu del servicio studenDAO
        verify(studentDAO, times(1)).save(stu);

    }

    @Test
    @DisplayName("Lectura Estudiante OK")
    public void readOK() {
        SubjectDTO s1 = new SubjectDTO("Matematica", 8.2);
        SubjectDTO s2 = new SubjectDTO("Quimica", 7.2);
        StudentDTO stu = new StudentDTO("Gabriel", "", 0.0,List.of(s1,s2));
        Long id = 1L;

        when(studentDAO.findById(id)).thenReturn(stu);


        StudentDTO retorno = studentService.read(id);

        assertEquals(stu, retorno);

    }


    @Test
    @DisplayName("update estudiandte OK")
    public void updateTest(){
        SubjectDTO s1 = new SubjectDTO("Matematica", 8.2);
        SubjectDTO s2 = new SubjectDTO("Quimica", 7.2);
        StudentDTO stu = new StudentDTO("Gabriel", "", 0.0,List.of(s1,s2));

        studentService.update(stu);

        verify(studentDAO, times(1)).save(stu);


    }

    @Test
    @DisplayName("Delete estudiante OK")
    public void deleteTest(){

        Long id = 1L;
        studentService.delete(id);

        verify(studentDAO, times(1)).delete(id);
    }

    @Test
    @DisplayName("Lectura Estudiante NO OK")
    public void readWithNullID() {
        Long id = null;

        when(studentDAO.findById(id)).thenThrow(StudentNotFoundException.class);

        Assertions.assertThrows(StudentNotFoundException.class, ()-> {
            studentService.read(null);
        });
    }

    @Test
    @DisplayName("getAllOK")
    public void getAllTest(){
        SubjectDTO s1 = new SubjectDTO("Matematica", 8.2);
        SubjectDTO s2 = new SubjectDTO("Quimica", 7.2);
        StudentDTO stu1 = new StudentDTO("Gabriel", "", 0.0,List.of(s1,s2));

        SubjectDTO ss1 = new SubjectDTO("Matematica", 5.2);
        SubjectDTO ss2 = new SubjectDTO("Quimica", 6.2);
        StudentDTO stu2 = new StudentDTO("Pedro", "", 0.0,List.of(ss1,ss2));
        Set<StudentDTO> expected = new HashSet<>();
        expected.add(stu1);
        expected.add(stu2);

        when(studentRepository.findAll()).thenReturn(Set.of(stu1,stu2));

        Set<StudentDTO> response = studentService.getAll();

        Assertions.assertEquals(expected, response);

    }





}
