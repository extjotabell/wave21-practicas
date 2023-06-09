package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
public class StudentDAOTest {

    //EJERCICIO #1

    @InjectMocks
    StudentDAO studentDAO;

    @Test
    @DisplayName("Save")
    public void saveTest(){
        StudentDTO student = getStudentDTOMock();
        studentDAO.save(student);
        StudentDTO responseStudent = studentDAO.findById(student.getId());
        assertEquals(student, responseStudent);
    }


    @Test
    @DisplayName("Delete - NOK")
    public void deleteNOKTest(){
        boolean obtainValue = studentDAO.delete(23L);
        assertFalse(obtainValue);
    }

    @Test
    @DisplayName("Delete - OK")
    public void deleteOKTest(){
        StudentDTO student = getStudentDTOMock();
        studentDAO.save(student);
        boolean obtainValue = studentDAO.delete(student.getId());
        assertTrue(obtainValue);
    }

    @Test
    @DisplayName("Exist - NOK")
    public void existNOKTest(){
        StudentDTO student = new StudentDTO();
        boolean obtainValue = studentDAO.exists(student);
        assertFalse(obtainValue);
    }

    @Test
    @DisplayName("FindById - NOK")
    public void findByIdNOKTest(){
        StudentDTO student = getStudentDTOMock();
        assertThrows(StudentNotFoundException.class, () -> {
            studentDAO.findById(100L);
        });

    }

    @Test
    @DisplayName("FindById - OK")
    public void findByIdOKTest(){
        StudentDTO student = getStudentDTOMock();
        studentDAO.save(student);
        StudentDTO obtainValue = studentDAO.findById(student.getId());
        assertSame(student, obtainValue);
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
