package com.meli.obtenerdiploma.integration.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @BeforeAll
    static void  previousSavings(){

        StudentDAO repo = new StudentDAO();
        SubjectDTO subject1 = new SubjectDTO("Math", 10D);
        SubjectDTO subject2 = new SubjectDTO("Science", 7D);
        SubjectDTO subject3 = new SubjectDTO("History", 9D);
        SubjectDTO subject4 = new SubjectDTO("Biology", 5D);

        List<SubjectDTO> subjects1 = Arrays.asList(subject1,subject2,subject3,subject4);
        List<SubjectDTO> subjects2 = Arrays.asList(subject1,subject4);


        StudentDTO studentDto = new StudentDTO(1L, "Juan",null,null, subjects1);
        StudentDTO studentDto2 = new StudentDTO(2L, "Pepe",null,null, subjects2);



        repo.save(studentDto);
        repo.save(studentDto2);


    }

    @Test
    void integrationAnalyzeScoreOK() throws Exception {
        //"/analyzeScores/{studentId}
        mockMvc.perform(get("/analyzeScores/{studentId}",1))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(7.0))
                .andReturn();
    }

    @Test
    void integrationAnalyzeScoreStudentIdNotFound() throws Exception {
        //"/analyzeScores/{studentId}
        mockMvc.perform(get("/analyzeScores/{studentId}",0))
                .andExpect(status().isNotFound())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("StudentNotFoundException"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("El alumno con Id 0 no se encuetra registrado."))
                .andReturn();
    }

}
