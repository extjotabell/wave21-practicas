package com.mercadolibre.qatesters.controller;

import com.mercadolibre.qatesters.model.TestCase;
import com.mercadolibre.qatesters.repository.TestCaseRepository;
import lombok.Getter;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private final TestCaseRepository testCaseRepo;

    public TestCaseController(TestCaseRepository testCaseRepo) {
        this.testCaseRepo = testCaseRepo;
    }

    @PostMapping("/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase testCase){
        return ResponseEntity.ok(testCaseRepo.save(testCase));
    }

    @GetMapping
    public ResponseEntity<List<TestCase>> getAllTestCase(){
        return ResponseEntity.ok(testCaseRepo.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("No se encuentra ese ID")));
    }

}
