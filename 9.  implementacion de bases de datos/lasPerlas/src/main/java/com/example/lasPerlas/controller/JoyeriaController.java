package com.example.lasPerlas.controller;

import com.example.lasPerlas.dto.response.EditDto;
import com.example.lasPerlas.dto.response.ResponseDto;
import com.example.lasPerlas.model.Joya;
import com.example.lasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyeriaController {

    @Autowired
    private IJoyaService joyaService;

//    public JoyeriaController(IJoyaService joyaService) {
//        this.joyaService = joyaService;
//    }

    @PostMapping("/jewelry/new")
    public ResponseEntity<ResponseDto> createJewelry(@RequestBody Joya joya){
        joyaService.saveJoya(joya);
        String message = "Jewelry created" + " " + joya.getId();
        return new ResponseEntity<>(new ResponseDto(200, message),HttpStatus.OK);
    }

    @GetMapping("/jewelry")
    public List<Joya> getJewelry(){
        return joyaService.getJoyas();
    }

    @PostMapping("/jewelry/edit/{id}")
    public ResponseEntity<EditDto> editJewelry(@PathVariable Long id, @RequestBody Joya joya){
        Joya toEditJoya = joyaService.findJoya(id);
        toEditJoya.setName(joya.getName());
        toEditJoya.setMaterial(joya.getMaterial());
        toEditJoya.setWeight(joya.getWeight());
        toEditJoya.setParticularity(joya.getParticularity());
        toEditJoya.setHasWeight(joya.isHasWeight());
        toEditJoya.setSaleOrNo(joya.isSaleOrNo());
        joyaService.saveJoya(toEditJoya);
        String message = "Jewelry edited" + " " + toEditJoya.getId();
        return new ResponseEntity<>(new EditDto(200, message, joya),HttpStatus.OK);
    }

    @PostMapping("/jewelry/delete/{id}")
    public ResponseEntity<ResponseDto> deleteJewelry(@PathVariable Long id){
        joyaService.deleteJoya(id);
        String message = "Jewelry deleted" + " " + id;
        return new ResponseEntity<>(new ResponseDto(200, message),HttpStatus.OK);
    }
}
