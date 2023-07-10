package com.example.demo.controllers;

import com.example.demo.domain.ObraLiteraria;
import com.example.demo.services.ObraLiterariaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ObraLiterariaController {

    @Autowired
    private ObraLiterariaService obraLiterariaService;

    @PostMapping("/obrasLiterarias")
    public ObraLiteraria save(@RequestBody ObraLiteraria obraLiteraria){
        return obraLiterariaService.save(obraLiteraria);
    }

    @GetMapping("/obrasLiterarias/{autor}")
    public List<ObraLiteraria> findByEdad(@PathVariable String autor){
        return obraLiterariaService.getAllByAutor(autor);
    }

    @GetMapping("/obrasLiterarias")
    public List<ObraLiteraria> findAllObrasLierarias(){
        return obraLiterariaService.findAll();
    }
/*
    @GetMapping("/obrasLiterarias/params")
    public List<ObraLiteraria> (@RequestParam String nombre, @RequestParam String orden){
        return obraLiterariaService.getObraLiterariaByNombreAndOrder(nombre, orden)
    }

 */
}
