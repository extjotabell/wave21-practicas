package com.otenerdiploma.OtenerDiploma.Service;

import com.otenerdiploma.OtenerDiploma.model.StudentDTO;
import com.otenerdiploma.OtenerDiploma.model.SubjectDTO;
import com.otenerdiploma.OtenerDiploma.repository.IStudentDAO;
import com.otenerdiploma.OtenerDiploma.repository.IStudentRepository;
import com.otenerdiploma.OtenerDiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
    @Mock
    private IStudentDAO studentDAO;
    @Mock
    private IStudentRepository studentRepository;
    @InjectMocks
    private StudentService studentService;
    @Test
    public void testCreate(){
        StudentDTO studentDTO = new StudentDTO();
        doNothing().when(studentDAO).save(studentDTO);
        studentService.create(studentDTO);
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    public void testRead(){
        Long studentId = 1L;
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Matematicas", 9.5));
        subjects.add(new SubjectDTO("Historia", 8.0));
        StudentDTO student = new StudentDTO(studentId, "Karla", null, null, subjects);

        when(studentDAO.findById(studentId)).thenReturn(student);

        StudentDTO result = studentService.read(studentId);

        assertEquals(student, result);
        verify(studentDAO, times(1)).findById(studentId);
    }

    @Test
    public void testUpdate(){
        StudentDTO studentDTO = new StudentDTO();
        doNothing().when(studentDAO).save(studentDTO);
        studentService.update(studentDTO);
        verify(studentDAO, times(1)).save(studentDTO);
    }

    @Test
    public void testDelete(){
        Long studentId = 1L;
        doNothing().when(studentDAO).delete(studentId);
        studentService.delete(studentId);
        verify(studentDAO, times(1)).delete(studentId);
    }

    @Test
    public void testGetAll(){
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

        when(studentRepository.findAll()).thenReturn(listaMock);

        Set<StudentDTO> result = studentService.getAll();

        assertEquals(expected, result);
        verify(studentRepository, times(1)).findAll();
    }

}
