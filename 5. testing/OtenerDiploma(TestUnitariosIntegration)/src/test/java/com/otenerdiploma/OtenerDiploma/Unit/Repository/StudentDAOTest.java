package com.otenerdiploma.OtenerDiploma.Unit.Repository;

import com.otenerdiploma.OtenerDiploma.exception.StudentNotFoundException;
import com.otenerdiploma.OtenerDiploma.model.StudentDTO;
import com.otenerdiploma.OtenerDiploma.model.SubjectDTO;
import com.otenerdiploma.OtenerDiploma.repository.StudentDAO;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    @Test
    public void testSave(){
        Long studentId = 4L;
        String studentName = "Lola";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 8.0));
        StudentDTO student = new StudentDTO(studentId, studentName, null, null, subjects);

        StudentDAO studentDAO = new StudentDAO();
        studentDAO.save(student);

        assertTrue(studentDAO.exists(student));
        assertNotNull(student.getId());
    }

    @Test
    public void testDelete(){
        StudentDAO studentDAO = new StudentDAO();
        Long studentId = 3L;
        boolean deleted = studentDAO.delete(studentId);

        assertTrue(deleted);
    }

    @Test
    public void testDeleteNotExist(){
        StudentDAO studentDAO = new StudentDAO();
        Long studentId = 1000L;
        boolean deleted = studentDAO.delete(studentId);

        assertFalse(deleted);
    }

    @Test
    public void testExist(){
        StudentDAO studentDAO = new StudentDAO();
        Long studentId = 2L;
        String studentName = "Juan";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 8.0));
        StudentDTO student = new StudentDTO(studentId, studentName, null, null, subjects);

        boolean exists = studentDAO.exists(student);

        assertTrue(exists);
    }

    @Test
    public void testNotExist(){
        StudentDAO studentDAO = new StudentDAO();
        Long studentId = 1000L;
        String studentName = "Lucas";
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 8.0));
        StudentDTO student = new StudentDTO(studentId, studentName, null, null, subjects);

        boolean exists = studentDAO.exists(student);

        assertFalse(exists);
    }

    @Test
    public void testFindById(){
        StudentDAO studentDAO = new StudentDAO();
        Long studentId = 2L;

        StudentDTO existStudent = studentDAO.findById(studentId);

        assertNotNull(existStudent);
        assertEquals(studentId, existStudent.getId());
    }

    @Test
    public void testFindByIdNotExist(){
        StudentDAO studentDAO = new StudentDAO();
        Long studentId = 10000L;

        assertThrows(StudentNotFoundException.class, ()-> studentDAO.findById(studentId));
    }
}
