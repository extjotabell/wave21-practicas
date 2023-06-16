package com.meli.obtenerdiploma.Repository;



import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class StudentDAOTests {

    StudentDAO studentDAO;
    StudentDTO stud0;
    @BeforeEach
    public void beforeEach() {
        studentDAO = new StudentDAO();
        //pensar otra solucion
        stud0 = new StudentDTO(1L, "Nombre2", null, null, null);
        studentDAO.save(stud0);

    }

    @Test
    public void savingANewStudent()  {
        StudentDTO stu = new StudentDTO(3L, "Nombre1", null, null, null);

        // act

        studentDAO.save(stu);

        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
        Assertions.assertEquals(2L, stu.getId());
        Assertions.assertEquals(studentDAO.findById(stu.getId()), stu);

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
        StudentDTO stu = new StudentDTO(1L, "Nombre1", null, null, null);

        studentDAO.save(stu);

        // act
        boolean expected = studentDAO.delete(stu.getId());

        // assert
        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertTrue(expected);
    }

    @Test
    public void deletingANonExistingStudent() {
        //Arrange
        Long nonExistingId = 99L;
        StudentDTO nonExistingStudent = new StudentDTO(nonExistingId, "Nombre99", null, null, null);
        // act
        boolean actual = studentDAO.delete(nonExistingId);

        // assert

        //comprobación de return
        Assertions.assertFalse(actual);

        // efecto secundario
        Assertions.assertFalse(studentDAO.exists(nonExistingStudent));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(nonExistingId));

    }

    @Test
    public void studentExists() {

        //Arrange
        StudentDTO stu = new StudentDTO(1L, "Nombre1", null, null, null);
        // act
        studentDAO.save(stu);
        // assert
        Assertions.assertTrue(studentDAO.exists(stu));
    }

    @Test
    public void studentDoesNotExists() {
        //Arrange
        StudentDTO stu = new StudentDTO(99L, "Nombre1", null, null, null);

        // Act & assert
        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }

    @Test
    public void studentFoundById() {

        StudentDTO stuExpected = studentDAO.findById(stud0.getId());
        // act & assert
        Assertions.assertEquals(stud0, stuExpected);
    }

    @Test
    public void studentNotFoundById() {
        StudentDTO stu = new StudentDTO(99L, "Nombre1", null, null, null);

        // Act & assert
        Assertions.assertFalse(studentDAO.exists(stu));
        Assertions.assertThrows(StudentNotFoundException.class,() -> studentDAO.findById(stu.getId()));
    }





}
