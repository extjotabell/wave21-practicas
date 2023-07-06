package com.Tester.demoDBTester.controller;

import com.Tester.demoDBTester.model.Testcase;
import com.Tester.demoDBTester.repository.ITestCaseRepository;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/testcase")
public class TestcaseController {

    private ITestCaseRepository testCaseRepository;

    public TestcaseController(ITestCaseRepository testCaseRepository) {
        this.testCaseRepository = testCaseRepository;
    }

    @PostMapping("/new")
    private ResponseEntity<Testcase> createTestcase(@RequestBody Testcase testcase){
        Testcase testcase1 = testCaseRepository.save(testcase);
        return ResponseEntity.ok(testcase1);
    }

    @GetMapping("/getAll")
    private ResponseEntity<List<Testcase>> getAllTestcase(){
        List<Testcase> testcaseList = testCaseRepository.findAll();
        return ResponseEntity.ok(testcaseList);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Testcase> getTestcaseById(@PathVariable Long id){
       Testcase testcase = testCaseRepository.findById(id).orElse(null);
        return ResponseEntity.ok(testcase);
    }

    @PutMapping("/modify/{id}")
    private ResponseEntity<Testcase> modifyTestcaseById(@PathVariable Long id,
                                                        @RequestParam ("description") String newDescription,
                                                        @RequestParam ("tested") Boolean newTested,
                                                        @RequestParam("passed") Boolean newPassed,
                                                        @RequestParam("number_of_tries") Integer numberOfTries,
                                                        @RequestParam("last_update") @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate newLastUpdate){
        Testcase testcase = testCaseRepository.findById(id).orElse(null);
        testcase.setDescription(newDescription);
        testcase.setTested(newTested);
        testcase.setPassed(newPassed);
        testcase.setNumber_of_tries(numberOfTries);
        testcase.setLast_update(newLastUpdate);
        testCaseRepository.save(testcase);
        return ResponseEntity.ok(testcase);
    }
    @DeleteMapping("/delete/{id}")
    private ResponseEntity<String> deleteTestcaseById(@PathVariable Long id){
        testCaseRepository.deleteById(id);
        return ResponseEntity.ok("Se ha eliminado con exito");
    }

    @GetMapping("/search")
    private ResponseEntity<List<Testcase>> getTestcaseByLastUpdate(@RequestParam @DateTimeFormat(pattern = "dd/MM/yyyy") LocalDate last_update){
        List<Testcase> testcaseList = testCaseRepository.findAll().stream().filter(testcase -> testcase.getLast_update().isAfter(last_update)).toList();
        return ResponseEntity.ok(testcaseList);
    }
}
