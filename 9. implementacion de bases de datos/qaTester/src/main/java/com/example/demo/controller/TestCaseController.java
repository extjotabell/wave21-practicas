package com.example.demo.controller;

import com.example.demo.dto.MessageDTO;
import com.example.demo.dto.TestCaseDTO;
import com.example.demo.dto.TestCaseIdDTO;
import com.example.demo.service.ITestCaseService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TestCaseController {

  @Autowired
  ITestCaseService testCaseService;

  @PostMapping("/testCase")
  ResponseEntity<TestCaseIdDTO> createTestCase(@RequestBody @Valid final TestCaseDTO testCase) {
    TestCaseIdDTO id = testCaseService.createTestCase(testCase);
    return ResponseEntity.ok().body(id);
  }

  @DeleteMapping("/testCase/{id}")
  ResponseEntity<MessageDTO> createTestCase(@PathVariable final long id) {
    testCaseService.deleteTestCase(id);
    return ResponseEntity.ok().body(new MessageDTO("deleted successfully"));
  }

  @GetMapping("/testCase")
  ResponseEntity<List<TestCaseDTO>> listTestCase() {

    List<TestCaseDTO> tests = testCaseService.getAllTestCase();
    return ResponseEntity.ok().body(tests);
  }

  @GetMapping("/testCase/{id}")
  ResponseEntity<TestCaseDTO> getByIdTestCase(@PathVariable final long id) {
    TestCaseDTO testCase = testCaseService.findById(id);
    return ResponseEntity.ok().body(testCase);
  }
}
