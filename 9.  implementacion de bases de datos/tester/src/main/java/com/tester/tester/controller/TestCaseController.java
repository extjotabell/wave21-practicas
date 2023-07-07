package com.tester.tester.controller;

import com.tester.tester.model.TestCase;
import com.tester.tester.repository.ITestCaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    @Autowired
    private ITestCaseRepository testCaseRepository;

    @PostMapping("/new")
    public ResponseEntity<TestCase> createTestCase(@RequestBody TestCase testCase){
        return ResponseEntity.ok(testCaseRepository.save(testCase));
    }

    @GetMapping("")
    public ResponseEntity<List<TestCase>> getAllTestCases(@RequestParam(required = false, value = "last_update") String last_update){
        if(last_update == null){
            return ResponseEntity.ok(testCaseRepository.findAll());
        }
        System.out.println(last_update);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(last_update, formatter);
        List<TestCase> testCases = testCaseRepository.findAll().stream().filter(testCase -> testCase.getLast_update().isAfter(date)).toList();
        return ResponseEntity.ok(testCases);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getTestCaseById(@PathVariable Long id){
        return ResponseEntity.ok(testCaseRepository.findById(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteTestCaseById(@PathVariable Long id){
        testCaseRepository.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }

}
