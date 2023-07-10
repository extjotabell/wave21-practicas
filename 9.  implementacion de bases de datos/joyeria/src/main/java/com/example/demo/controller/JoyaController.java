package com.example.demo.controller;

import com.example.demo.model.Joya;
import com.example.demo.repository.JoyaRepository;
import com.example.demo.service.IJoyaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JoyaController {
    private final IJoyaService joyaServ;

    public JoyaController(IJoyaService joyaServ){
        this.joyaServ = joyaServ;
    }

    @PostMapping("/jewerly/new")
    public Integer createJoya(@RequestBody Joya joya){
        return joyaServ.saveJoya(joya);
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas(){
        return joyaServ.getJoyas();
    }

    @PostMapping("/jewerly/update/{id_modificar}")
    public String updateJoya(@PathVariable Integer id_modificar, @RequestBody Joya joya){
        return joyaServ.updateJoya(joya, id_modificar);
    }

    @PostMapping("/jewerly/delete/{id}")
    public String deleteJoya(@PathVariable Integer id){
        return joyaServ.deleteJoya(id);
    }
}


