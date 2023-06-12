package com.meli.obtenerdiploma.integration;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.IStudentDAO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaIntegrationTest {

    StudentDAO studentDAO = new StudentDAO();
    @Autowired
    MockMvc mockMvc;

    @BeforeEach
    public void beforEach() {
        SubjectDTO matematica = new SubjectDTO("Matematica", 10.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO geografia = new SubjectDTO("Geografia", 8.0);

        StudentDTO student = new StudentDTO(1L, "Juan", "", 9.0, List.of(matematica, musica, geografia));

        if (!studentDAO.exists(student)) {
            studentDAO.save(student);
        }
    }

    @Test
    void validarNotas() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 1L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.studentName").value("Juan"))
                .andExpect(jsonPath("$.message").value("El alumno Juan ha obtenido un promedio de 9. Puedes mejorar."))
                .andExpect(jsonPath("$.averageScore").value(9.0))
                .andExpect(jsonPath("$.subjects[0].name").value("Matematica"))
                .andExpect(jsonPath("$.subjects[0].score").value(10.0))
                .andExpect(jsonPath("$.subjects[1].name").value("Musica"))
                .andExpect(jsonPath("$.subjects[1].score").value(9.0))
                .andExpect(jsonPath("$.subjects[2].name").value("Geografia"))
                .andExpect(jsonPath("$.subjects[2].score").value(8.0));
    }

    @Test
    void estudianteNoEncontrado() throws Exception {
        this.mockMvc.perform(
                MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 20394L))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(jsonPath("$.description").value("El alumno con Id 20394 no se encuetra registrado."));
    }
}
