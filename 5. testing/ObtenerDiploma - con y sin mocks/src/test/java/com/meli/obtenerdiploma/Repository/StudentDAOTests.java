package com.meli.obtenerdiploma.Repository;



import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.utils.UtilsGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class StudentDAOTests {

    StudentDAO studentDAO;
    @BeforeEach
    public void beforeEach() {
        studentDAO = new StudentDAO();
        //pensar otra solucion
        studentDAO.save(new StudentDTO(1L, "Nombre2", null, null, null));
    }
    /* @Test
    public void createNonExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void createExistentStudent() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }*/


    @Test
    public void savingANewStudent()  {
        StudentDTO stu = new StudentDTO(3L, "Nombre1", null, null, null);

        // act

        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(2L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);

        //Assert


    }

    @Test
    public void savingAnAlreadyExistingStudent() {
        StudentDTO stu = new StudentDTO(1L, "Nombre1", null, null, null);

        // act

        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(1L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);
    }

    @Test
    public void deletingAnExistingStudent(){
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void deletingANonExistingStudent() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void studentExists() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void studentDoesNotExists() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void studentFoundById() {
        //Arrange

        //Act

        //Assert
    }

    @Test
    public void studentNotFoundById() {
        //Arrange

        //Act

        //Assert
    }





}
