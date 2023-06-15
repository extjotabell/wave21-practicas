package com.meli.obtenerdiploma.controller;

import com.meli.obtenerdiploma.model.StudentDTO;
import com.meli.obtenerdiploma.service.IObtenerDiplomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
public class ObtenerDiplomaController {

    @Autowired
    IObtenerDiplomaService service;

    @PostMapping("/analyzeScores")
    public StudentDTO analyzeScores(@RequestBody @Valid StudentDTO rq /*, BindingResult bindingResult*/) {
        /*if (bindingResult.hasErrors()) {
            List<String> errores = new ArrayList<>();
            for (FieldError error : bindingResult.getFieldErrors()) {
                errores.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errores);
        }
        return ResponseEntity.ok((List<String>) service.analyzeScores(rq));
*/
         return service.analyzeScores(rq);
    }


}
