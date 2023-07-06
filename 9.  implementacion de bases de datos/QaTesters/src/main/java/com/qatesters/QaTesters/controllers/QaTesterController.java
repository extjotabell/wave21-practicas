package com.qatesters.QaTesters.controllers;

import com.qatesters.QaTesters.entities.TestCase;
import com.qatesters.QaTesters.repositories.IQaTesterRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/testcases")
public class QaTesterController {

    private IQaTesterRepository _qaTesterRepository;

    public QaTesterController(IQaTesterRepository _qaTesterRepository) {
        this._qaTesterRepository = _qaTesterRepository;
    }

    @PostMapping("/new")
    public ResponseEntity<String> create(@RequestBody TestCase testCase){
        TestCase newTestCase = _qaTesterRepository.save(testCase);
        return ResponseEntity.ok("El caso de prueba fue guardado correctamente con el ID: " + newTestCase.getId_case());
    }

    @GetMapping("/")
    public ResponseEntity<List<TestCase>> getAll(){
        return ResponseEntity.ok(_qaTesterRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TestCase> getById(@PathVariable Long id){
        return ResponseEntity.ok(_qaTesterRepository.findById(id).orElse(null));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        if(_qaTesterRepository.existsById(id)){
            _qaTesterRepository.deleteById(id);
            return ResponseEntity.ok("Se elimino el Test Correctamente");
        }
        return (ResponseEntity<String>) ResponseEntity.notFound();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateById(@PathVariable Long id, @RequestBody TestCase testCase){
        if(_qaTesterRepository.existsById(id)){
            _qaTesterRepository.save(testCase);
            return ResponseEntity.ok("Se actualizo el Test Correctamente");
        }

        return (ResponseEntity<String>) ResponseEntity.notFound();

    }
}
