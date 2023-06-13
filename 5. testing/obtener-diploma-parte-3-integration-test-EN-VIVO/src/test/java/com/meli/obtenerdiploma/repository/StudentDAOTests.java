package com.meli.obtenerdiploma.repository;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StudentDAOTests {

    IStudentDAO studentDAO;

    @BeforeEach @AfterEach
    private void setUp() {
//       TestUtilsGenerator.emptyUsersFile();
       this.studentDAO = new StudentDAO();
    }

    @Test
    public void createNonExistentStudent() {
        // arrange
        StudentDTO stu = new StudentDTO();
        stu.setStudentName("Jolu");
        stu.setSubjects(Arrays.asList(new SubjectDTO("Lengua", 10D)));

        // act
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void createExistentStudent() {
        // arrange
        StudentDTO stu = new StudentDTO();
        stu.setStudentName("Jose");
        stu.setSubjects(Arrays.asList(new SubjectDTO("Inglés", 10D)));

        // act
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void modifyNonExistentStudent() {
        // arrange
        StudentDTO stu1 = new StudentDTO();
        stu1.setStudentName("Pedro");
        stu1.setSubjects(Arrays.asList(new SubjectDTO("Quimica", 10D)));

        StudentDTO stu2 = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        stu2.setId(999L);
        stu2.setStudentName("Marco Polo");

        studentDAO.save(stu1);

        // act
        studentDAO.save(stu2);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu1));
        Assertions.assertEquals(studentDAO.findById(stu1.getId()), stu1);

        Assertions.assertTrue(studentDAO.exists(stu2));
        Assertions.assertEquals(studentDAO.findById(stu2.getId()), stu2);

    }

    @Test
    public void modifyExistentStudent() {
        // arrange
        StudentDTO stu = new StudentDTO();
        stu.setStudentName("Pedro");
        stu.setSubjects(Arrays.asList(new SubjectDTO("Biología", 10D)));

        // act
        stu.setStudentName("Marco Polo");
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void findExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        StudentDTO found = studentDAO.findById(stu.getId());

        // assert
        Assertions.assertEquals(found, stu);
    }

    @Test
    public void findNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act & assert
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");
        studentDAO.save(stu);

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu));
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void deleteNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu));
        assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }



}
