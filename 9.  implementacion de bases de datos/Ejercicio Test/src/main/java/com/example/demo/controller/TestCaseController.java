package com.example.demo.controller;

import com.example.demo.model.TestCase;
import com.example.demo.service.ITestCaseService;
import com.example.demo.service.TestCaseService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@RestController("/api/")
public class TestCaseController {

    private final ITestCaseService testServ;

    public TestCaseController(ITestCaseService testServ){
        this.testServ = testServ;
    }
    @PostMapping("new/testcases")
    public Long createTest(@RequestBody TestCase test){
        return testServ.saveTest(test);
    }

    @GetMapping("/testcases")
    public List<TestCase> getTest(){
        return testServ.getTests();
    }

    @GetMapping("/testcases/{id}")
    public TestCase getTest(@PathVariable Long id){
        return testServ.getTestById(id);
    }

    @PutMapping("/testcases/{id}")
    public String updateTest(@PathVariable Long id, @RequestBody TestCase test){
        return testServ.updateTest(test, id);
    }

    @DeleteMapping("/testcases/{id}")
    public String deleteTest(@PathVariable Long id){
        return testServ.deleteTest(id);
    }
}
