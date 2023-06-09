package com.meli.obtenerdiploma.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class StudentControllerTestIntegration {

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testRegisterStudent () throws Exception{

        //StudentDTO student = new StudentDTO();

        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(new SubjectDTO("Programación", 5.0)
                , new SubjectDTO("Matemáticas", 7.0)));

        StudentDTO student = new StudentDTO(10L,"JJ","El alumno JJ ha obtenido un promedio de 6.0. Puedes mejorar.",6.0,subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/registerStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                        .andDo(print())
                        .andExpect(status().isOk());


    }

    @Test
    public void testGetStudent () throws Exception{

        mockMvc.perform(get("/student/getStudent/{studentId}",9L))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.message").value("El alumno JJ ha obtenido un promedio de 6.0. Puedes mejorar."));

    }

    @Test
    public void testModifyStudent () throws Exception{

        List<SubjectDTO> subjects = new ArrayList<>(Arrays.asList(new SubjectDTO("Programación", 5.0)
                , new SubjectDTO("Matemáticas", 7.0)));

        StudentDTO student = new StudentDTO(10L,"JJ","El alumno JJ ha obtenido un promedio de 6.0. Puedes mejorar.",6.0,subjects);

        ObjectWriter writer = new ObjectMapper()
                .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
                .writer();

        String jsonPayload = writer.writeValueAsString(student);

        mockMvc.perform(post("/student/modifyStudent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                        .andDo(print())
                        .andExpect(status().isOk());

    }

    @Test
    public void testRemoveStudent () throws Exception{

        mockMvc.perform(get("/student/removeStudent/{studentId}",2L))
                .andDo(print())
                .andExpect(status().isOk());

    }

    @Test
    public void testListStudents () throws Exception{

        mockMvc.perform(get("/student/listStudents"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"));

    }

}
