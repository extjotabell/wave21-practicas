package com.meli.obtenerdiploma.services;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    IStudentDAO _studentDao;
    @Mock
    IStudentRepository _studentRepository;
    @InjectMocks
    StudentService _studentService;

    @Test
    @DisplayName("Testing Student Creation")
    void createStudentTest(){
        // Arrange
        SubjectDTO subject = new SubjectDTO("Matematicas", 8D);
        SubjectDTO subject1 = new SubjectDTO("Lengua", 4D);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject);

        StudentDTO expectedStudent = new StudentDTO(1L, "Flavio", null, null, subjectDTOList);
        // Act
        _studentService.create(expectedStudent);
        // Asserts
        verify(_studentDao, Mockito.times(1)).save(expectedStudent);
    }
    @Test
    @DisplayName("Testing Student Removing")
    void deleteStudentTest(){
        /*public void delete(Long id) {
            studentDAO.delete(id);
        }*/
        // Arrange
        /*SubjectDTO subject = new SubjectDTO("Matematicas", 8D);
        SubjectDTO subject1 = new SubjectDTO("Lengua", 4D);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject);

        StudentDTO expectedStudent = new StudentDTO(1L, "Flavio", null, null, subjectDTOList);

        Long idToDelete = 1L;
        boolean expectedBool = true;
        // Act
        _studentDao.save(expectedStudent);
        boolean result = _studentDao.delete(idToDelete);

        // Asserts
        assertEquals(expectedBool, result);*/
    }
}