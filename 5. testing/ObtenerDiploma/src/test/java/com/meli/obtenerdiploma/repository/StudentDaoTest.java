package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class StudentDaoTest {

    StudentDAO studentDao = new StudentDAO();
    StudentDAO studentDAOMock = Mockito.mock(StudentDAO.class);

//    @BeforeEach
//    public void setUp() {
//        studentDao.save(new StudentDTO(15L, "Juan", "", 0D, null));
//    }

//    @AfterEach
//    public void tearDown() {
//      studentDao.delete(1L);
//        studentDao = null;
//    }

    @Test
    @DisplayName("Guardar student")
    public void saveTest() {
        //usando mockito.verify
        StudentDTO student = new StudentDTO(10L, "Prueba", "", 0D, null);
        StudentDAO studentDaoMock = Mockito.mock(StudentDAO.class);
        studentDaoMock.save(student);
        Mockito.verify(studentDaoMock, Mockito.times(1)).save(student);
    }

    @Test
    @DisplayName("Eliminar student")
    public void deleteTest() {
        // Tiene que exisitir en la DB para que lo pueda borrar
        boolean response = studentDao.delete(10L);
        assertTrue(response);
    }

    @Test
    @DisplayName("Buscar por ID")
    public void findByIdTest() {
        StudentDTO studentExpected = new StudentDTO(8L, "Juan", "", 0.0, null);
        StudentDTO student = studentDao.findById(8L);
        assertEquals(studentExpected, student);
    }
}
