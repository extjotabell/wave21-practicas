package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.GreaterThan;
import org.mockito.internal.matchers.LessThan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ObtenerDiplomaControllerTests {
    @Autowired
    MockMvc mockMvc;

    @Test
    public void testanalyzeScoresNotApproveds() throws Exception {
        Double promedio = (8 + 8 + 8) / 3.0;
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", 1L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Juan"))
                // Aquí está el link: https://stackoverflow.com/questions/32199577/spring-mockmvcresultmatchers-jsonpath-lower-greater-than
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(promedio))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(containsString("Puedes mejorar")))
                .andReturn();

        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void testanalyzeScoresApproved() throws Exception {
        Double promedio = (10 + 10 + 10) / 3.0;
        MvcResult mvcResult = mockMvc.perform(get("/analyzeScores/{studentId}", 2L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Pedro"))
                // Aquí está el link: https://stackoverflow.com/questions/32199577/spring-mockmvcresultmatchers-jsonpath-lower-greater-than
                .andExpect(MockMvcResultMatchers.jsonPath("$.averageScore").value(promedio))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value(containsString("Felicitaciones")))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}