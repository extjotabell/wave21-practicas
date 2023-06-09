package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import com.meli.obtenerdiploma.util.TestUtilsGenerator;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {

    @Autowired
    MockMvc mockMvc;
    @Mock
    IObtenerDiplomaService service;

    @InjectMocks
    ObtenerDiplomaController controller;

    @Test
    public void obtenerDiploma() {
        // arrange
        StudentDTO stu = TestUtilsGenerator.getStudentWith3Subjects("Marco");

        // act
        controller.analyzeScores(stu.getId());

        // assert
        verify(service, atLeastOnce()).analyzeScores(stu.getId());
    }

    @Test
    void intTestObtenerDiplomaJuanOk()throws Exception{
        List<SubjectDTO> testSubjectDTO = new ArrayList<>();
        testSubjectDTO.add(new SubjectDTO("Matematica",9.0));
        testSubjectDTO.add(new SubjectDTO("Fisica",7.0));
        testSubjectDTO.add(new SubjectDTO("Quimica",6.0));
        StudentDTO testStudentDto= new StudentDTO(1L,"Juan","El alumno Juan ha obtenido un promedio de 7.33. Puedes mejorar.",7.333333333333333,
                testSubjectDTO);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String responseJson = writer.writeValueAsString(testStudentDto);
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}",1))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
        assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
    }





}
