package com.example.ejemplo_jpa.controller;

import com.example.ejemplo_jpa.dto.StudentDTO;
import com.example.ejemplo_jpa.model.Student;
import com.example.ejemplo_jpa.repository.StudentRepository;
import com.example.ejemplo_jpa.service.IStudentService;
import com.example.ejemplo_jpa.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {
    private final ModelMapper mapper = new ModelMapper();
    //implemento la interface
    @Autowired
    private IStudentService stuServ;

    @GetMapping ("/students")
    public List<StudentDTO> getStudents () {

        List<StudentDTO> studentList = stuServ.getStudents();
        return studentList;

    }

    @PostMapping ("/create")
      public String createStudent(@RequestBody Student student) {
        stuServ.saveStudent(student);
        return "El estudiante fue agregado correctamente";
    }

    //acá también puedo poner un objeto y lo relaciona a la id
    // (si se llaman igual ambos parámetros)
    @PostMapping("delete/{id}")
    public String deleteStudent (@PathVariable long id) {
        stuServ.deleteStudent(id);
        return "El estudiante fue borrado correctamente";
    }

    @PostMapping ("edit/{id}")
    public StudentDTO editStudent (@PathVariable long id,
                                @RequestParam ("name") String newName,
                                @RequestParam ("lastname") String newLastname) {
        StudentDTO stu = stuServ.findStudent(id);
        //esto puede ir en el service
        stu.setLastname(newName);
        stu.setName(newLastname);
        Student newStudent = mapper.map(stu, Student.class);
        stuServ.saveStudent(newStudent);
        return stu;
    }






}
