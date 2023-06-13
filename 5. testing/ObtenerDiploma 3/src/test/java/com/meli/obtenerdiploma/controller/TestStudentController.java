package com.meli.obtenerdiploma.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.meli.obtenerdiploma.model.ErrorDTO;
import com.meli.obtenerdiploma.model.ResponseDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.model.SubjectDTO;
import com.meli.obtenerdiploma.repository.StudentDAO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@AutoConfigureMockMvc
@SpringBootTest
public class TestStudentController {

@Autowired
MockMvc mockMvc;



@Test
@DisplayName("Materia con calificacion 11")
void invalidNoteTest() throws Exception{
ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException","La nota máxima de la materia es de 10 pts.");
StudentDTO stu = new StudentDTO(4L, "Marta","soy marta",0.0, getListWithSubjectAVG10());
stu.getSubjects().get(0).setScore(11.0);

ObjectWriter writer = new ObjectMapper()
        .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
        .writer();

String jsonPayload = writer.writeValueAsString(stu);
String responseJson = writer.writeValueAsString(error);
MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
        .contentType(MediaType.APPLICATION_JSON)
        .content(jsonPayload))
        .andDo(print())
        .andExpect(content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.status().isBadRequest())
        .andReturn();
assertEquals(responseJson,mvcResult.getResponse().getContentAsString(StandardCharsets.UTF_8));
}





@Test
@DisplayName("La lista de materias no puede ser vacia")
void registerUserWithSubjectEmpty() throws Exception{
    ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException","La lista de materias no puede estar vacia.");
    StudentDTO stu = new StudentDTO(4L, "Marta","soy marta",0.0, new ArrayList<SubjectDTO>());
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    String jsonPayload = writer.writeValueAsString(stu);
    String responseJson = writer.writeValueAsString(error);
    MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload))
            .andDo(print())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andReturn();
    assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
}

@Test
@DisplayName("El nombre del estudiante tiene que arrancar con Mayuscula")
void registerUserWithBadName() throws Exception{
    ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException","El nombre del estudiante debe comenzar con mayuscula.");
    StudentDTO stu = new StudentDTO(4L, "marta","soy marta",0.0,  getListWithSubjectAVG10());
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    String jsonPayload = writer.writeValueAsString(stu);
    String responseJson = writer.writeValueAsString(error);
    MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload))
            .andDo(print())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.status().isBadRequest())
            .andReturn();
    assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
}

@Test
@DisplayName("Registrar un usuario valido")
void registerUserTest() throws Exception{
    long id_result = 2L;
    StudentDTO stu = new StudentDTO(4L, "Alan","soy Alan Brado",0.0, getListWithSubjectAVG10());
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    String jsonPayload = writer.writeValueAsString(stu);
    String responseJson = writer.writeValueAsString(new ResponseDTO(id_result,"El estudiante ha sido registrado correctamente"));
    MvcResult mvcResult = mockMvc.perform(post("/student/registerStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload))
            .andDo(print())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
}

@Test
@DisplayName("Obtener la lista de todos los estudiantes")
void getStudentTest() throws  Exception{
    List<StudentDTO> result = getAllStudents();

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    String expected = writer.writeValueAsString(result) ;
    MvcResult mvcResult = mockMvc.perform(get("/student/listStudents"))
            .andDo(print())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andReturn();
    assertEquals(expected,mvcResult.getResponse().getContentAsString());


}
@Test
public void testGetUser() throws Exception{
   mockMvc.perform(get("/student/getStudent/{id}", 1L))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andExpect(MockMvcResultMatchers.jsonPath("$.studentName").value("Marta"));
}

@Test
public void testGetUserNotFound() throws Exception{

    ErrorDTO error = new ErrorDTO("StudentNotFoundException","El alumno con Id 11 no se encuetra registrado.");

    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();
    String result = writer.writeValueAsString(error);

    MvcResult response = mockMvc.perform(get("/student/getStudent/{id}", 11L))
            .andDo(print())
            .andExpect(status().isNotFound())
            .andExpect(content().contentType("application/json"))
            .andReturn();

    assertEquals(result,response.getResponse().getContentAsString());

}

@Test
@DisplayName("Modificar el estudiante")
void testModifyStudent() throws Exception {
    StudentDTO stu = new StudentDTO(1L, "Marta","soy marta",0.0, getListWithSubjectAVG10());
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();

    String jsonPayload = writer.writeValueAsString(stu);
    String responseJson = writer.writeValueAsString(new ResponseDTO(stu.getId(),"El estudiante ha sido modificado correctamente"));
    mockMvc.perform(post("/student/modifyStudent")
            .contentType(MediaType.APPLICATION_JSON)
            .content(jsonPayload))
            .andDo(print())
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(mvcResult1 -> mvcResult1.getResponse().getContentAsString().equals(responseJson));

}

@Test
@DisplayName("Eliminar el estudiante")
void deleteStudentTest() throws Exception {
    ObjectWriter writer = new ObjectMapper()
            .configure(SerializationFeature.WRAP_ROOT_VALUE,false)
            .writer();
    String responseJson = writer.writeValueAsString(new ResponseDTO(1L,"El estudiante fue removido con exito"));

    MvcResult mvcResult =mockMvc.perform(get("/student/removeStudent/{id}",1L))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType("application/json"))
            .andReturn();

    assertEquals(responseJson,mvcResult.getResponse().getContentAsString());
}


List<SubjectDTO> getListWithSubjectAVG10(){
        List<SubjectDTO> subjects = new ArrayList<>();
        subjects.add(new SubjectDTO("Quimica", 10.0));
        subjects.add(new SubjectDTO("Matematica", 10.0));
        subjects.add(new SubjectDTO("Lengua", 10.0));
        subjects.add(new SubjectDTO("Fisica", 10.0));
        subjects.add(new SubjectDTO("Artistica", 10.0));
        return subjects;
    }

    public List<StudentDTO> getAllStudents(){
        StudentDAO repo = new StudentDAO();

        return repo.getStudents().stream().collect(Collectors.toList());

    }
}

