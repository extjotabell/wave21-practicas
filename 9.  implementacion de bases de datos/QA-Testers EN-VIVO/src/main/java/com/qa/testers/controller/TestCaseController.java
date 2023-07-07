package com.qa.testers.controller;

import com.qa.testers.dto.request.TestCaseRequestDTO;
import com.qa.testers.dto.response.TestCaseResponseDTO;
import com.qa.testers.model.TestCase;
import com.qa.testers.repository.TestCaseRepository;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping("/api/testcases")
public class TestCaseController {

    private TestCaseRepository repository;

    private ModelMapper mapper;

    public TestCaseController(TestCaseRepository repository){
        this.repository = repository;
        this.mapper = new ModelMapper();
    }

    @PostMapping("/new")
    public ResponseEntity<?> createTestCase(@RequestBody TestCaseRequestDTO testCaseDTO){
        TestCase testCase = mapper.map(testCaseDTO, TestCase.class);
        TestCase response = repository.save(testCase);
        String result = String.format("TestCase created with id: %s", response.getIdCase());
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> getAllTestCases(){
        List<TestCaseResponseDTO> result = repository.findAll().stream().map(testCase -> mapper.map(testCase,
                TestCaseResponseDTO.class)).toList();
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTestCaseById(@PathVariable Long id){
        TestCaseResponseDTO result = mapper.map(repository.findById(id), TestCaseResponseDTO.class);
        if (result!=null){
            return new ResponseEntity<>(result, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putTestCaseById(@PathVariable Long id, @RequestBody TestCaseRequestDTO requestDTO){
        TestCase response = repository.findById(id).orElseThrow();
        response.setDescription(requestDTO.getDescription());
        response.setTested(requestDTO.getTested());
        response.setLastUpdate(requestDTO.getLastUpdate());
        response.setNumberOfTries(requestDTO.getNumberOfTries());
        response.setPassed(requestDTO.getPassed());
        repository.save(response);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTestCaseById(@PathVariable Long id) {
        boolean flag = repository.existsById(id);
        if(flag){
            repository.deleteById(id);
            return new ResponseEntity<>("Eliminado exitosamente", HttpStatus.OK);
        }else {
            return new ResponseEntity<>("No existe", HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/update")
    public ResponseEntity<?> getAllByDate(@RequestParam(name = "last_update") String lastUpdate) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate localDate = LocalDate.parse(lastUpdate, formatter);
            List<TestCase> result = repository.findAll().stream().filter(testCase -> testCase.getLastUpdate()
                    .isAfter(localDate)).toList();

            return new ResponseEntity<>(result, HttpStatus.OK);
        }catch (DateTimeParseException ex){
            return new ResponseEntity<>("Formato de fecha invalido", HttpStatus.BAD_REQUEST);
        }
    }
}