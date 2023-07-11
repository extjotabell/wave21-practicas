package com.obrasliterarias.controller;

import com.obrasliterarias.model.dto.ObraDTO;
import com.obrasliterarias.service.IObraService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/obras")
public class ObrasLiterariasController {

    private IObraService service;

    public ObrasLiterariasController(IObraService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<?> getAllObras(){
        return new ResponseEntity<>(service.getAllObras(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createEmpleado(@RequestBody ObraDTO obraDTO){
        return new ResponseEntity<>(service.createObra(obraDTO), HttpStatus.CREATED);
    }


    // Retornar las obras de un autor dado por el usuario.
    @GetMapping("/autorParam/{autor}")
    public ResponseEntity<?> autorParam(@PathVariable String autor){
        return new ResponseEntity<>(service.autorParam(autor), HttpStatus.OK);
    }

    // Retornar las obras que contengan palabras dadas por el usuario en sus títulos.
    @GetMapping("/containsTitle/{title}")
    public ResponseEntity<?> containsTitle(@PathVariable String title){
        return new ResponseEntity<>(service.containsTitle(title), HttpStatus.OK);
    }

    // Retornar las obras con más cantidad de páginas que las indicadas por el usuario.
    @GetMapping("/obrasPagesGreaterThanParam/{cantidad}")
    public ResponseEntity<?> obrasPagesGreaterThanParam(@PathVariable Integer cantidad){
        return new ResponseEntity<>(service.obrasPagesGreaterThanParam(cantidad), HttpStatus.OK);
    }

    // Retornar las obras que fueron publicadas antes y después de un año dado por el usuario (crear 2 endpoints).
    @GetMapping("/obrasYearGreaterThanParam/{year}")
    public ResponseEntity<?> obrasYearGreaterThanParam(@PathVariable Integer year){
        return new ResponseEntity<>(service.obrasYearGreaterThanParam(year), HttpStatus.OK);
    }

    @GetMapping("/obrasYearLowerThanParam/{year}")
    public ResponseEntity<?> obrasYearLowerThanParam(@PathVariable Integer year){
        return new ResponseEntity<>(service.obrasYearLowerThanParam(year), HttpStatus.OK);
    }

    // Retornar las obras de una misma editorial.
    @GetMapping("/obrasSameEditorialThanParam/{editorial}")
    public ResponseEntity<?> obrasSameEditorialThanParam(@PathVariable String editorial){
        return new ResponseEntity<>(service.obrasSameEditorialThanParam(editorial), HttpStatus.OK);
    }
}
