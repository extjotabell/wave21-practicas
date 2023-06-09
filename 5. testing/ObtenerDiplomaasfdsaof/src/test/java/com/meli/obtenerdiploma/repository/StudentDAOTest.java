package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class StudentDAOTest {

    IStudentDAO underTest;

    StudentDTO studentDTOMocked;

    @BeforeEach
    void setUp(){
        underTest= new StudentDAO();
        studentDTOMocked= mockStudentDTO();
    }

    @Test
    void save() {
        assertDoesNotThrow(()->underTest.save(studentDTOMocked));
    }

    @Test
    @Disabled
    void delete() {
        assertTrue(underTest.delete(1l));
    }

    @Test
    void deleteFalse() {
        assertFalse(underTest.delete(324324l));
    }

    @Test
    void exists() {
        assertTrue(underTest.exists(studentDTOMocked));
    }

    @Test
    void existsErrorCase(){
        studentDTOMocked.setId(213412421l);
        assertFalse(underTest.exists(studentDTOMocked));
    }

    @Test
    void findById() {
        assertTrue(underTest.findById(2l)!=null);
    }

    @Test
    void findByIdNullCase(){
        assertThrows(StudentNotFoundException.class,
                ()->underTest.findById(null));
    }

    private StudentDTO mockStudentDTO(){
        List<SubjectDTO> subjects= new ArrayList<>();
        SubjectDTO subject1= new SubjectDTO("Matematicas",6.5);
        SubjectDTO subject2= new SubjectDTO("Lengua",10d);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO student= new StudentDTO(1l,"Juan","No se",subjects.stream().collect(Collectors.averagingDouble(SubjectDTO::getScore)),subjects);
        return student;
    }
}