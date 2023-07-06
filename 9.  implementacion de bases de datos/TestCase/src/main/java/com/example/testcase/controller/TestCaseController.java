package com.example.testcase.controller;

import com.example.testcase.dto.TestCaseDTO;
import com.example.testcase.service.TestCaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseService testCaseService;

    public TestCaseController(TestCaseService testCaseService){
        this.testCaseService=testCaseService;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCaseDTO> create(@RequestBody TestCaseDTO testCaseDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(testCaseService.create(testCaseDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<TestCaseDTO>> findAll(@RequestParam(required = false) LocalDate last_updated){
        return ResponseEntity.ok(testCaseService.findAll(last_updated));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCaseDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TestCaseDTO> updateById(@PathVariable Long id,
                                                  @RequestBody TestCaseDTO testCaseDTO){
        return ResponseEntity.ok(testCaseService.updateById(id,testCaseDTO));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        testCaseService.deleteById(id);
        return ResponseEntity.ok(null);
    }
}
