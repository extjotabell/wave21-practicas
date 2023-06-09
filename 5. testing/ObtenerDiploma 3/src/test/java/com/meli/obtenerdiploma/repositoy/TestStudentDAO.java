package com.meli.obtenerdiploma.repositoy;

import com.meli.obtenerdiploma.exception.StudentNotFoundException;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.IStudentRepository;
import com.meli.obtenerdiploma.service.IStudentService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.event.annotation.BeforeTestExecution;

import javax.security.auth.Subject;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
public class TestStudentDAO {
    @Autowired
    IStudentDAO studentDAO;
    @Autowired
    IStudentRepository studentRepository;

    @BeforeEach
    void setup(){

        StudentDTO user = new StudentDTO(1L, "juan","soy juan",0.0, getList());
        studentDAO.save(user);
    }

    @AfterEach
    void deleteConfig(){
        studentDAO.delete(1L);
    }
    @Test
    @DisplayName("Camino Feliz crear estudiante...")
    void readStudentByID(){
        Long id = 1L;
        StudentDTO espected = new StudentDTO(id, "juan","soy juan",0.0, getList());

        assertEquals(espected,studentDAO.findById(id));
    }
    @Test
    @DisplayName("Encontrar Estudiante por ID, camino triste :(")
    void studentFindByID(){

        long id = 3L;
        assertThrows(StudentNotFoundException.class, ()-> studentDAO.findById(id));
    }

    @Test
    @DisplayName("Modifico info del estudiante")
    void modifyDataFromStudent(){
        Long id = 1L;

        StudentDTO user = new StudentDTO(1L, "Rogelio","soy juan",0.0, getList());
        studentDAO.save(user);
        user.setStudentName("Rogelio");
        studentDAO.save(user);
        StudentDTO espected = new StudentDTO(id, "Rogelio","soy juan",0.0, getList());

        assertEquals(espected,studentDAO.findById(id));



    }

    @Test
    @DisplayName("Estudiante no existe")
    void studentNotExist(){

        StudentDTO stu = new StudentDTO(55L,"Rogelio","soy juan",0.0, getList());
        assertEquals(studentDAO.exists(stu),false);

    }

    @Test
    @DisplayName("Estudiante existe")
    void studentExist(){

        StudentDTO stu = new StudentDTO(1L,"Rogelio","soy juan",0.0, getList());
        assertEquals(studentDAO.exists(stu),true);

    }

    @Test
    @DisplayName("Estudiante no se puede eliminar")
    void studentNotDelete(){

    long id = 55L;
    assertEquals(studentDAO.delete(id),false);

    }


    @Test
    @DisplayName("Estudiante existe")
    void studentDelete(){

        long id = 1L;
        assertEquals(studentDAO.delete(id),true);

    }




    List<SubjectDTO> getList(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Quimica", 7.0));
        subjects.add(new SubjectDTO("Matematica", 8.0));
        subjects.add(new SubjectDTO("Lengua", 9.0));
        subjects.add(new SubjectDTO("Fisica", 9.0));
        subjects.add(new SubjectDTO("Artistica", 7.0));
        return subjects;
    }
}
