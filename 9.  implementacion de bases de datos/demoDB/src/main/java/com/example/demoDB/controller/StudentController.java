package com.example.demoDB.controller;

import com.example.demoDB.model.Student;
import com.example.demoDB.service.IStudentService;
import com.example.demoDB.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    private IStudentService studentService;

    public StudentController(IStudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createStudent (Student stu){
        studentService.saveStudent(stu);
        return ResponseEntity.ok("El estudiante fue creado correctamente");
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents (){
        List<Student> studentList = studentService.getStudent();
        return ResponseEntity.ok(studentList);
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Student> editStudent (@PathVariable long id,
                                                @RequestParam ("name") String newName,
                                                @RequestParam ("lastname") String newLastname) {
        Student stu = studentService.findStudent(id);
        stu.setName(newName);
        stu.setLastname(newLastname);
        studentService.saveStudent(stu);
        return ResponseEntity.ok(stu);
    }

    @PostMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent (@PathVariable long id){
        studentService.deleteStudent(id);
        return ResponseEntity.ok("El estudiante fue borrado correctamente");
    }
}
