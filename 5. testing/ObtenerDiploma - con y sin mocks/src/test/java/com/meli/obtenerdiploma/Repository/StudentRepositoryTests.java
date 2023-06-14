package com.meli.obtenerdiploma.Repository;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.repository.StudentRepository;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class StudentRepositoryTests {

    /*Se requiere crear los tests unitarios necesarios para cubrir el
     comportamiento de la capa de repositorio StudentDAO y StudentRepository.
     Tener en cuenta múltiples escenarios y “casos borde” de cada comportamiento.
    Casos nulos, vacíos, inválidos.
    Agregar un alumno.
    Buscar un alumno por Id.
    Modificar los datos de un alumno.
    Eliminar un alumno.
    Listar todos los alumnos.
*/
    @Test
    //esto esta correctamente testeado?
    public void allStudentsAreOk() {
        StudentRepository repository = new StudentRepository();
        Set<StudentDTO> actual = repository.findAll();


        List<StudentDTO> expected = new ArrayList<>();
        expected.add(new StudentDTO(1L, "Juan", null,null,List.of(new SubjectDTO("Matemática", 9d), new SubjectDTO("Física", 7d), new SubjectDTO("Química",6d))));
        expected.add(new StudentDTO(2L, "Pedro", null,null,List.of(new SubjectDTO("Matemática", 10d), new SubjectDTO("Física", 8d), new SubjectDTO("Química",4d))));

        //assert
        //assertEquals(null, expected.toString(),actual.toString());


    }

    //no sé como testear esto
    @Test
    public void fileIsNotFound() {

    }

    //me falta probar la otra excepcion pero no sé como generarla

}
