package com.meli.obtenerdiploma.RepositoryTest;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class StudentDAOTest {
    @Autowired
    IStudentDAO studentDAO;
    @Test
    @DisplayName("DELETE - Test para probar camino correcto")
    void deleteTestOk()
    {
        Long id = 0L;
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        StudentDTO dto = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);
        studentDAO.save(dto);
        StudentDTO encontrado = studentDAO.findById(dto.getId());
        boolean expected = studentDAO.delete(encontrado.getId());

        Assert.isTrue(expected);
    }

    @Test
    @DisplayName("DELETE - Test para probar camino que lanza excepción")
    void deleteTestNotFound()
    {
        Long id = 0L;
        Assert.isTrue(!studentDAO.delete(id));
    }

    @Test
    @DisplayName("EXISTS - Test para probar camino correcto")
    void existsOk()
    {
        Long id = 0L;
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        StudentDTO dto = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);
        studentDAO.save(dto);
        boolean expected = studentDAO.exists(dto);

        Assert.isTrue(expected);
    }

    @Test
    @DisplayName("EXISTS - Test para no existencia del elemento")
    void existsNotFound()
    {
        Long id = 0L;
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        StudentDTO dto = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);

        boolean expected = studentDAO.exists(dto);

        Assert.isTrue(!expected);
    }

    @Test
    @DisplayName("FIND BY ID - Test para probar camino correcto")
    void findByIdOk()
    {
        Long id = 0L;
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        StudentDTO dto = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);
        studentDAO.save(dto);

        StudentDTO expected = studentDAO.findById(dto.getId());

        assertEquals(expected, dto);
    }

    @Test
    @DisplayName("FIND BY ID - Test para probar camino correcto")
    void findByIdNotFound()
    {
        Long id = 0L;
        assertThrows(StudentNotFoundException.class,()->{
            studentDAO.findById(id);
        });
    }

    @Test
    @DisplayName("LOAD DATA - Test para probar camino correcto")
    void loadDataOk()
    {
        Long id = 0L;
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        StudentDTO dto = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);
        studentDAO.save(dto);

        StudentDTO expected = studentDAO.findById(dto.getId());

        assertEquals(expected, dto);
    }

    @Test
    @DisplayName("SAVE - Test para probar camino correcto")
    void saveOk()
    {
        Long id = 0L;
        SubjectDTO subject = new SubjectDTO("SubjectName", 0.0);
        List<SubjectDTO> subjects = Arrays.asList(subject);
        StudentDTO dto = new StudentDTO(id, "Anto", "UnMensaje", 7.5, subjects);
        studentDAO.save(dto);

        StudentDTO expected = studentDAO.findById(dto.getId());

        assertEquals(expected, dto);
    }
}
