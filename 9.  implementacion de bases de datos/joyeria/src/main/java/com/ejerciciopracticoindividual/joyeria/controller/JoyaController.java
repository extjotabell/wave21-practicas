package com.ejerciciopracticoindividual.joyeria.controller;

import com.ejerciciopracticoindividual.joyeria.dto.JoyaDTO;
import com.ejerciciopracticoindividual.joyeria.service.JoyaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    private JoyaService joyaService;

    public JoyaController(JoyaService joyaService){
        this.joyaService=joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> crearJoya(@RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(joyaService.guardar(joyaDTO));
    }

    @GetMapping("")
    public ResponseEntity<List<JoyaDTO>> mostrarJoyas(){
        return ResponseEntity.ok(joyaService.listar());
    }

    @DeleteMapping("/delete/{id}")
    public void borradoLogico(@PathVariable Integer id){
        joyaService.borrar(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<JoyaDTO> actualizarJoya(@PathVariable Integer id,
                                                  @RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyaService.guardar(id,joyaDTO));
    }
}
