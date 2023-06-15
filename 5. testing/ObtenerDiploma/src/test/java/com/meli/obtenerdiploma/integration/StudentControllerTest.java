package com.meli.obtenerdiploma.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Create Student")
    void createStudent() throws Exception {

        SubjectDTO matematica = new SubjectDTO("Matematica", 10.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO geografia = new SubjectDTO("Geografia", 8.0);

        StudentDTO student = new StudentDTO(1L, "Juancito", "", 9.0, List.of(matematica, musica, geografia));

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/registerStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(student)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Get Student")
    void getStudent() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/getStudent/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Juancito"));
    }

    @Test
    @DisplayName("Get All Students")
    void getAllStudents() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].studentName").value("Juan"));
    }

    @Test
    @DisplayName("Modify Student")
    void modifyStudent() throws Exception {
        SubjectDTO matematica = new SubjectDTO("Matematica", 10.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO geografia = new SubjectDTO("Materia nueva", 8.0);

        StudentDTO student = new StudentDTO(1L, "Juancito", "", 9.0, List.of(matematica, musica, geografia));

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        this.mockMvc.perform(MockMvcRequestBuilders.post("/student/modifyStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(ow.writeValueAsString(student)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    @DisplayName("Delete Student")
    void deleteStudent() throws Exception {
        this.mockMvc.perform(
                        MockMvcRequestBuilders.get("/student/removeStudent/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.studentName").value("Juancito"));
    }
}
