package com.meli.obtenerdiploma.integrationtest;


import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootTest //me permite levantar el contexto de spring, para hacer pedidos http
@AutoConfigureMockMvc // nos permite usar el artefacto MockMvc de la libreria para hacer test
public class StudentControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Test de Integracion para traer todos los alumnos")
    void getAllStudentsTest() throws Exception {
        //arrange

        Set<StudentDTO> listaAlumnos = new HashSet<>();
        SubjectDTO m1 = new SubjectDTO("Matemática", 9D);
        SubjectDTO m2 = new SubjectDTO("Física", 7D);
        SubjectDTO m3 = new SubjectDTO("Quimica", 6D);
        StudentDTO s1 = new StudentDTO("Juan","", 0.0, List.of(m1,m2,m3) );

        SubjectDTO mm1 = new SubjectDTO("Matemática", 10D);
        SubjectDTO mm2 = new SubjectDTO("Física", 8D);
        SubjectDTO mm3 = new SubjectDTO("Quimica", 4D);
        StudentDTO s2 = new StudentDTO("Juan","", 0.0, List.of(mm1,mm2,mm3) );

        listaAlumnos.add(s1);
        listaAlumnos.add(s2);
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/student/listStudents");

        //los Expected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExcpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher bodyExpected = MockMvcResultMatchers.content().json(listaAlumnos.toString()) ;

        mockMvc.perform(request) // nos permite performar la solicitud htto

                .andExpect(statusExpected) //cotejar que coincida el status
                .andExpect(contentTypeExcpected) //cotejar que coincida el contentType
                .andExpect(bodyExpected) //cotejar que coincida el body
                .andDo(MockMvcResultHandlers.print());

    }
}
