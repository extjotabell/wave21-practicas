package com.meli.obtenerdiploma.service;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    IStudentDAO iStudentDAOMock;

    @Mock
    IStudentRepository iStudentRepositoryMock;

    @InjectMocks
    @Spy
    StudentService underTest;

    StudentDTO studentDTOMock;

    Set<StudentDTO> studentDTOSMock;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        studentDTOMock=mockStudentDTO();
        studentDTOSMock= studentDTOSMock();
    }

    @Test
    void create() {
        underTest.create(studentDTOMock);

        Mockito.verify(underTest).create(studentDTOMock);
    }

    @Test
    void read() {
        Mockito.when(iStudentDAOMock.findById(1l))
                .thenReturn(studentDTOMock);

        StudentDTO studentResponse = underTest.read(1l);

        assertEquals(studentResponse,studentDTOMock);
    }

    @Test
    void readThrowsException() {
        Long id= 2l;

        Mockito.when(iStudentDAOMock.findById(id))
                .thenThrow(new StudentNotFoundException(id));

        assertThrows(StudentNotFoundException.class,
                ()-> underTest.read(id));
    }

    @Test
    void update() {
        underTest.update(studentDTOMock);

        Mockito.verify(underTest).update(studentDTOMock);
    }

    @Test
    void delete() {
        underTest.delete(1l);

        Mockito.verify(underTest).delete(studentDTOMock.getId());
    }

    @Test
    void deleteIsFalse() {
        Mockito.when(iStudentDAOMock.delete(2l))
                .thenReturn(false);

        underTest.delete(2l);

        Mockito.verify(underTest).delete(2l);
    }

    @Test
    void getAll() {
        Mockito.when(iStudentRepositoryMock.findAll())
                        .thenReturn(studentDTOSMock);

        Set<StudentDTO> studentDTOSResponse = underTest.getAll();

        assertEquals(studentDTOSResponse,studentDTOSMock);
    }

    @Test
    void getAllFailsToRead(){
        Mockito.when(iStudentRepositoryMock.findAll())
                .thenReturn(new HashSet<>());

        Set<StudentDTO> studentDTOSResponse = underTest.getAll();

        assertNotEquals(studentDTOSResponse,studentDTOSMock);
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

    private Set<StudentDTO> studentDTOSMock(){
        Set<StudentDTO> studentDTOSMock = new HashSet<>();

        StudentDTO student1= mockStudentDTO();

        List<SubjectDTO> subjects= new ArrayList<>();
        SubjectDTO subject1= new SubjectDTO("Historia",2d);
        SubjectDTO subject2= new SubjectDTO("Agronomia",5d);
        subjects.add(subject1);
        subjects.add(subject2);
        StudentDTO student2= new StudentDTO(1l,"Juan","No se",subjects.stream().collect(Collectors.averagingDouble(SubjectDTO::getScore)),subjects);

        studentDTOSMock.add(student1);
        studentDTOSMock.add(student2);
        return studentDTOSMock;
    }
}