package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class ObtenerDiplomaControllerTests {

    @Autowired
    MockMvc mockMvc;

    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    static StudentDAO studentDAO = new StudentDAO();
    StudentDTO student;

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @BeforeEach
    public void beforEach() {
       SubjectDTO matematicas = new SubjectDTO("matematicas", 1.0);
        SubjectDTO musica = new SubjectDTO("Musica", 9.0);
        SubjectDTO ingles =    new SubjectDTO("Ingles",    2.0);

        student =new StudentDTO(1L, "Juan","El alumno " +
                "Juan ha obtenido un promedio de 4,00. Puedes mejorar.", 4.0, List.of(matematicas, musica, ingles) );

        if( ! studentDAO.exists( student ) )
            studentDAO.save( student );

    }

    @Test
    public void obtenerDiplomaIntrgrationOk() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", 1))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath( "$.studentName").value("Juan"))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

    @Test
    public void obtenerDiplomaIntrgrationNoId() throws Exception {
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", 22))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath( "$.name").value("StudentNotFoundException"))
                .andReturn();

        assertEquals("application/json", mvcResult.getResponse().getContentType());
    }

}
