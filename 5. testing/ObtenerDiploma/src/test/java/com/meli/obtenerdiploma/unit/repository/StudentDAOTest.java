package com.meli.obtenerdiploma.unit.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class StudentDAOTest {

    @Autowired
    IStudentDAO studentRepository = new StudentDAO();

    ObjectWriter writer = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(SerializationFeature.WRAP_ROOT_VALUE, false)
            .writer();
    @Test
    @DisplayName("Guardar estudiante")
    public void saveOk() {
        //ARRANGE
        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(new SubjectDTO("Matemática", 9.0));
        listSubject.add(new SubjectDTO("Lengua", 10.0));
        StudentDTO student = new StudentDTO(null, "Pedro", null, null, listSubject);
        StudentDTO studentSaved;

        //ACT
        studentRepository.save(student);
        studentSaved = studentRepository.findById(student.getId());
        //ASSERT
        Assertions.assertNotNull(studentSaved);
    }

    @Test
    @DisplayName("Eliminar estudiante exitosa.")
    public void deleteOK() {
        //ARRANGE
        Long idStudent = 7L;

        //ACT
        boolean result = studentRepository.delete(idStudent);

        //ASSERT
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Eliminar estudiante fallida.")
    public void deleteNoOK() {
        //ARRANGE
        Long idStudent = 7L;

        //ACT
        boolean result = studentRepository.delete(idStudent);

        //ASSERT
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Buscar estudiante por id exitoso.")
    public void findByIdOK() {
        //ARRANGE
        Long idStudent = 7L;

        //ACT
        StudentDTO result = studentRepository.findById(idStudent);

        //ASSERT
        Assertions.assertNotNull(result);
    }

    @Test
    @DisplayName("Buscar estudiante por id Fallido.")
    public void findByIdNoOK() {
        //ARRANGE
        Long idStudent = 7L;

        //ACT

        //ASSERT
        Assertions.assertThrows(StudentNotFoundException.class, () -> studentRepository.findById(idStudent));
    }

    @Test
    @DisplayName("Comprobar si existe un estudiante.")
    public void existOK() {
        //ARRANGE
        Long idStudent = 2L;
        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(new SubjectDTO("Matemática", 9.0));
        listSubject.add(new SubjectDTO("Lengua", 10.0));
        StudentDTO student = new StudentDTO(idStudent, "Pedro", null, null, listSubject);


        //ACT
        boolean result = studentRepository.exists(student);

        //ASSERT
        Assertions.assertTrue(result);
    }

    @Test
    @DisplayName("Comprobar si no existe un estudiante.")
    public void existNoOK() {
        //ARRANGE
        Long idStudent = 22L;
        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(new SubjectDTO("Matemática", 9.0));
        listSubject.add(new SubjectDTO("Lengua", 10.0));
        StudentDTO student = new StudentDTO(idStudent, "Pedro", null, null, listSubject);


        //ACT
        boolean result = studentRepository.exists(student);

        //ASSERT
        Assertions.assertFalse(result);
    }

    @Test
    @DisplayName("Actualizar un estudiante.")
    public void updateOK() throws JsonProcessingException {

        //ARRANGE
        Long idStudent = 2L;
        List<SubjectDTO> listSubject = new ArrayList<>();
        listSubject.add(new SubjectDTO("Programacion", 2.0));
        listSubject.add(new SubjectDTO("Lengua", 0.0));
        StudentDTO student = new StudentDTO(idStudent, "Jorge", null, null, listSubject);

        //ACT
        Optional<StudentDTO> result = studentRepository.update(student);

        //ASSERT
        Assertions.assertEquals(writer.writeValueAsString(student), writer.writeValueAsString(result.get()));
    }
}
