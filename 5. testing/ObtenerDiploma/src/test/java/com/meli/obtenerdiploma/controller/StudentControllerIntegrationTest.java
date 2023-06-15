package com.meli.obtenerdiploma.controller;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;

import com.meli.obtenerdiploma.service.IStudentService;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@ExtendWith(MockitoExtension.class)
public class StudentControllerIntegrationTest {


    @Autowired
    MockMvc mockMvc;

    @Mock
    StudentDAO studentDao;

    @Mock
    private IStudentService studentService;

    @InjectMocks
    private StudentController studentController;

    private StudentDTO createStudentDTO() {
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(1L);
        studentDTO.setStudentName("John Doe");
        studentDTO.setMessage("Congratulations!");
        studentDTO.setAverageScore(9.5);
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(createSubjectDTO("Mathematics", 8.5));
        subjects.add(createSubjectDTO("Physics", 9.0));
        subjects.add(createSubjectDTO("Chemistry", 9.5));
        studentDTO.setSubjects(subjects);
        return studentDTO;
    }

    private SubjectDTO createSubjectDTO(String name, Double score) {
        SubjectDTO subjectDTO = new SubjectDTO();
        subjectDTO.setName(name);
        subjectDTO.setScore(score);
        return subjectDTO;
    }




// /registerStudent
    @Test
    void testRegisterStudent() {
        // Arrange
        StudentDTO studentDTO = createStudentDTO();

        // Act
        ResponseEntity<?> response = studentController.registerStudent(studentDTO);

        // Assert
        assertEquals(ResponseEntity.ok(null), response);
        verify(studentService, times(1)).create(studentDTO);

    }

    @Test
    // /getStudent/{id}
    void testIntegrationGetStudent() throws Exception{
        StudentDAO repo = new StudentDAO();
        SubjectDTO subject1 = new SubjectDTO("Math", 10D);
        SubjectDTO subject2 = new SubjectDTO("Science", 7D);
        SubjectDTO subject3 = new SubjectDTO("History", 9D);
        SubjectDTO subject4 = new SubjectDTO("Biology", 5D);

        List<SubjectDTO> subjects1 = Arrays.asList(subject1,subject2,subject3,subject4);
        List<SubjectDTO> subjects2 = Arrays.asList(subject1,subject4);


        StudentDTO studentDto = new StudentDTO(1L, "Juan",null,null, new ArrayList<>());
        studentDto.setSubjects(subjects1);
        StudentDTO studentDto2 = new StudentDTO(2L, "Pepe",null,null, new ArrayList<>());
        studentDto2.setSubjects(subjects2);


        repo.save(studentDto);
        repo.save(studentDto2);

        MvcResult mvcResult = mockMvc.perform(get("/student/getStudent/{id}",1L))
                .andExpect(status().isOk())
                .andReturn();

       String jsonResponse = mvcResult.getResponse().getContentAsString();

        ClassPathResource resource = new ClassPathResource("juan.json");
        String expectedJson = new String(Files.readAllBytes(Paths.get(resource.getURI())));

        JSONAssert.assertEquals(expectedJson, jsonResponse, false);



    }



    ///removeStudent/{id}
    @Test
    void testIntegrationRemoveStudent() throws Exception {
            int id = 1;

            var request = get("/student/removeStudent/"+id);
            MvcResult result = mockMvc.perform(request).andDo(print()).andReturn();

            assertEquals(200, result.getResponse().getStatus());

    }

    //Agregar list students



}
