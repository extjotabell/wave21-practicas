package com.bootcamp.test.controller;

import com.bootcamp.test.dto.TestCaseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bootcamp.test.service.TestCaseService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TestCaseController {

    private TestCaseService tcService;

    public TestCaseController(TestCaseService tcService) {
        this.tcService = tcService;
    }

    @PostMapping("/testcases/new")
    public ResponseEntity<TestCaseDTO> createTestCase(@RequestBody TestCaseDTO tc){
        return ResponseEntity.ok(tcService.saveTestCase(tc));

    }

    @GetMapping("/testcases")
    public ResponseEntity<List<TestCaseDTO>> getAllTestCase(){

        return ResponseEntity.ok(tcService.findAll());
    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<TestCaseDTO> getTest (@PathVariable Long id){
        return ResponseEntity.ok(tcService.findById(id));
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<String> updateTest(@PathVariable Long id, @RequestBody TestCaseDTO dto){

        tcService.update(id,dto);
        return ResponseEntity.ok("Se actualiza correctamente");
    }

    @DeleteMapping("/api/testcases/{id}")
    public ResponseEntity<String> deleteTest(@PathVariable Long id){
        tcService.deleteTestCase(id);
        return ResponseEntity.ok("Se ha eliminado el usuario correctamente");
    }
///api/testcases?last_update=’dd/mm/yyyy’
}
