package com.example.crud_jpa_qa_tester.controller;

import com.example.crud_jpa_qa_tester.entity.TestCase;
import com.example.crud_jpa_qa_tester.service.ITestCaseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
public class TestCaseController {

    ITestCaseService service;

    public TestCaseController(ITestCaseService service) {
        this.service = service;
    }

    @PostMapping("/testcases/new")
    public ResponseEntity<Long> createTestCase(@RequestBody TestCase testCase) {
        TestCase newTestCase = service.saveTestCase(testCase);
        return ResponseEntity.ok(newTestCase.getId_case());
    }

    @GetMapping("/testcases")
    public ResponseEntity<List<TestCase>> getAllTestCases(@RequestParam (value = "last_update", required = false) LocalDate last_update) {
        if(last_update != null) {
            List<TestCase> testCaseList = service.findAllTestCase();
            testCaseList.stream()
                    .filter(n -> n.getLast_update().equals(last_update))
                    .toList();
            return ResponseEntity.ok(testCaseList);
        } else {
            List<TestCase> testCaseList = service.findAllTestCase();
            return ResponseEntity.ok(testCaseList);
        }

    }

    @GetMapping("/testcases/{id}")
    public ResponseEntity<Optional<TestCase>> getAllTestCases(@PathVariable Long id) {
        return ResponseEntity.ok(service.findOneTestCase(id));
    }

    @PutMapping("/testcases/{id}")
    public ResponseEntity<String> updateTestCase(@PathVariable Long id,
                                                 @RequestBody TestCase testCase) {
        return ResponseEntity.ok(service.updateTestCase(id, testCase));
    }

    @DeleteMapping("/testcases/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id) {
        return ResponseEntity.ok(service.deleteTestCase(id));
    }
}
