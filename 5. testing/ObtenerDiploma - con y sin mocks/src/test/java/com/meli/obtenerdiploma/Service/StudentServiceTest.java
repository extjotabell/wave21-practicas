package com.meli.obtenerdiploma.Service;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.ObtenerDiplomaService;
import com.meli.obtenerdiploma.service.StudentService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentServiceTest {
    @Mock
    static
    IStudentDAO _studentDao;
    @Mock
    IStudentRepository _studentRepository;
    @InjectMocks
    StudentService _studentService;

    static StudentDTO student1;

    @BeforeAll
    public static void beforeEach() {
        _studentDao = new StudentDAO();
       student1 = new StudentDTO(1L, "Nombre1", null, null, null);
        _studentDao.save(student1);

    }


    @Test
    void createStudentTest(){
        // Arrange
        SubjectDTO subject = new SubjectDTO("Matematicas", 8D);
        SubjectDTO subject1 = new SubjectDTO("Lengua", 4D);
        List<SubjectDTO> subjectDTOList = new ArrayList<>();
        subjectDTOList.add(subject1);
        subjectDTOList.add(subject);

        StudentDTO expectedStudent = new StudentDTO(1L, "Nombre", null, null, subjectDTOList);
        Mockito.doNothing().when(_studentDao).save(expectedStudent);
        // Act

        _studentService.create(expectedStudent);
        // Asserts
        verify(_studentDao, Mockito.times(1)).save(expectedStudent);
    }

    //camino feliz
    @Test
    void deleteExistingStudentTest(){
        // Arrange
        Long idToDelete = 1L;
        // Act
      //  Mockito.doNothing().when(_studentDao).delete(idToDelete);

        _studentService.delete(idToDelete);
        // Asserts

        verify(_studentDao, Mockito.times(1)).delete(idToDelete);

    }

    //camino triste

    //camino feliz
    @Test
    public void readStudentTest() {

        //Arrange
        Long expectedId = 1L;

        //Act
        StudentDTO expected = student1;
        Mockito.when(_studentDao.findById(expectedId)).thenReturn(student1);
        StudentDTO actual = _studentService.read(1L);

        //Assertions
       Assertions.assertEquals(expected, actual);

    }

    @Test
    public void updateStudentTest() {


        Mockito.doNothing().when(_studentDao).save(student1);
        // Act
        _studentService.update(student1);
        // Asserts
        verify(_studentDao, Mockito.times(1)).save(student1);
    }

    @Test
    public void getAllStudentsTest() {
        
    }


}