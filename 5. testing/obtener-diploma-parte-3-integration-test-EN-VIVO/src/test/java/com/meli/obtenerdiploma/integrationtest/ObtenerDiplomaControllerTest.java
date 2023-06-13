package com.meli.obtenerdiploma.integrationtest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.util.NestedServletException;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTest {

    @Autowired
    MockMvc mockMvc;

    ObjectWriter writer =  new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .writer();

    @Test
    public void analyzeScoresOKTest() throws Exception {
        //Arrange
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(2L);
        studentDTO.setStudentName("Pedro");
        studentDTO.setMessage("El alumno Pedro ha obtenido un promedio de 7.33. Puedes mejorar.");
        studentDTO.setAverageScore(7.333333333333333);
        studentDTO.setSubjects(Arrays.asList(new SubjectDTO("Matemática", 10.0),
                new SubjectDTO("Física", 8.0), new SubjectDTO("Química", 4.0)));
        //Request
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 2L);

        //Expected
        ResultMatcher statusExpected = MockMvcResultMatchers.status().isOk();
        ResultMatcher contentTypeExpected = MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON);
        ResultMatcher body = MockMvcResultMatchers.content().json(writer.writeValueAsString(studentDTO));

        mockMvc.perform(request).andDo(print())
                .andExpect(statusExpected)
                .andExpect(contentTypeExpected)
                .andExpect(body);
    }

    @Test
    public void analyzeScoresNOKTest() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/analyzeScores/{studentId}", 299L);
        assertThrows(NestedServletException.class, () ->{
            mockMvc.perform(request).andDo(print()).andReturn();
        });
    }
}
