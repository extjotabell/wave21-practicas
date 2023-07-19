package com.practicaJPA.joyeria.controller;

import com.practicaJPA.joyeria.dto.JoyaDTO;
import com.practicaJPA.joyeria.dto.MessageDTO;
import com.practicaJPA.joyeria.service.interfaces.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("jewelry")
public class JoyaController {

    @Autowired
    IJoyaService joyaService;

    @PostMapping("/new")
    public ResponseEntity<JoyaDTO> createJoya(@RequestBody JoyaDTO joyaDTO){
        return ResponseEntity.ok(joyaService.saveJoya(joyaDTO));
    }

    @GetMapping("/")
    public ResponseEntity<List<JoyaDTO>> getJoyas (){
        return ResponseEntity.ok(joyaService.getAllJoya());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JoyaDTO> getById(@PathVariable Integer id){
        return ResponseEntity.ok(joyaService.getJoyayById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Integer id){
        return ResponseEntity.ok(joyaService.deleteJoya(id));
    }


}
