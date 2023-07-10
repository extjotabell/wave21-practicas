package com.example.qatesters.controller;

import com.example.qatesters.model.TestCase;
import com.example.qatesters.repository.TestCaseRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        return ResponseEntity.ok(testCaseRepo.findById(id).orElseThrow(()-> new RuntimeException("No se encuentra ese ID")));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<TestCase> editTestCase(@PathVariable Long id,
                                                 @RequestParam String description,
                                                 @RequestParam Boolean tested,
                                                 @RequestParam Boolean passed,
                                                 @RequestParam Integer numberOfTries){
        TestCase toEditTestCase = testCaseRepo.findById(id).orElseThrow(()-> new RuntimeException("No se encuentra ese ID"));
        toEditTestCase.setDescription(description);
        toEditTestCase.setTested(tested);
        toEditTestCase.setPassed(passed);
        toEditTestCase.setNumberOfTries(numberOfTries);
        return ResponseEntity.ok(testCaseRepo.save(toEditTestCase));
    }


    @PostMapping("/delete/{id}")
    public ResponseEntity<String> deleteTestCase(@PathVariable Long id){
        testCaseRepo.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado el caso de prueba con ID: " + id);
    }

    @GetMapping("/byDate")
    public ResponseEntity<List<TestCase>> getTestCasesByDate(@RequestParam String date){
        LocalDate parsedDate = LocalDate.parse(date);
        return ResponseEntity.ok(testCaseRepo.findByLastUpdate(parsedDate));
    }
}