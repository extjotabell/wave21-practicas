package com.meli.obtenerdiploma.serviceTest;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO studentDAO;
    @Mock
    IStudentRepository studentRepository;

    @InjectMocks
    StudentService studentService;

    @Test
    void createOk() {
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        StudentDTO stu = new StudentDTO(1L, "Anto", "UnMensaje", 7.5, subjects);
        StudentDTO stuExpected = new StudentDTO(1L, "Anto", "UnMensaje", 7.5, subjects);
        studentService.create(stu);
        Mockito.lenient().when(studentService.read(1L)).thenReturn(stuExpected);

        assertThat(stuExpected.getStudentName()).isEqualTo(stu.getStudentName());
        assertThat(stuExpected.getId()).isEqualTo(stu.getId());
    }

    @Test
    void readOk()
    {
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        Long id = 1L;
        StudentDTO stu = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);
        studentService.create(stu);

        StudentDTO stuExpected = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);

        Mockito.lenient().when(studentDAO.findById(id)).thenReturn(stuExpected);

        stuExpected = studentService.read(id);

        assertThat(stuExpected.getId()).isEqualTo(stu.getId());

    }

    @Test
    void updateOk()
    {
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        Long id = 1L;
        StudentDTO stu = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);

        Mockito.doNothing().when(studentDAO).save(stu);

        studentService.update(stu);

        verify(studentDAO, Mockito.times(1)).save(stu);

    }

    @Test
    void deleteOk()
    {

    }

    @Test
    void getAll()
    {

    }
}
