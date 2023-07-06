package com.bootcamp.h2.controller;

import com.bootcamp.h2.dto.StudentDTO;
import com.bootcamp.h2.dto.response.StudentListDTO;
import com.bootcamp.h2.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

@Autowired
    private StudentService stuService;

@PostMapping("/create")
public ResponseEntity<String> createStudent(@RequestBody StudentDTO student){
    stuService.save(student);
    return ResponseEntity.ok("Se ha creado el usuario exitosamente");
}

@GetMapping("/findAll")
public ResponseEntity<StudentListDTO> findAllStudent(){

    return ResponseEntity.ok(stuService.findall());
}

@GetMapping("/findByID/{id}")
public ResponseEntity<StudentDTO> findStudentByID(@PathVariable Long id){

    return ResponseEntity.ok(stuService.findbyId(id));
}


}
