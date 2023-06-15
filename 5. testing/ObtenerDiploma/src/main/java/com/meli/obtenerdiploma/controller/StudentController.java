package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.dto.response.ResponseDTO;
import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService studentService;

    @PostMapping("/registerStudent")
    public ResponseEntity<ResponseDTO> registerStudent(@RequestBody @Valid StudentDTO stu) {
        return ResponseEntity.ok(this.studentService.create(stu));
    }

    @GetMapping("/getStudent/{id}")
    public StudentDTO getStudent(@PathVariable Long id) {
        return this.studentService.read(id);
    }

    @PutMapping("/modifyStudent")
    public ResponseEntity<StudentDTO> modifyStudent(@RequestBody @Valid StudentDTO stu) {
        Optional<StudentDTO> response = this.studentService.update(stu);
        return ResponseEntity.ok(response.get());
    }

    @GetMapping("/removeStudent/{id}")
    public ResponseEntity<ResponseDTO> removeStudent(@PathVariable Long id) {
        return ResponseEntity.ok(this.studentService.delete(id));
    }

    @GetMapping("/listStudents")
    public Set<StudentDTO> listStudents() {
        return this.studentService.getAll();
    }

}
