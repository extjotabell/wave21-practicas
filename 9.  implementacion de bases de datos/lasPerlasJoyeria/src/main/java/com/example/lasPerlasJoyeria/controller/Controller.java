package com.example.lasPerlasJoyeria.controller;

import com.example.lasPerlasJoyeria.dto.JewelDTO;
import com.example.lasPerlasJoyeria.service.JewerlyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class Controller {

    private final JewerlyService jewerlyService;

    //inyeccion de dependencia por constructor
    public Controller( JewerlyService jj){

        this.jewerlyService = jj;
    }

    @GetMapping("/jewerly")
    public ResponseEntity<List<JewelDTO>> getJewelrlyList(){
        List<JewelDTO> lista = jewerlyService.getJewelryList();
        return ResponseEntity.ok(lista);
    }
    @GetMapping("/jewerly/new")
    public void newJewel(@RequestBody JewelDTO oneJewel){
        jewerlyService.saveJewel(oneJewel);
    }

    @GetMapping("/jewerly/delete/{id}")
    public void deleteJewel(@RequestParam Integer id){
        jewerlyService.deleteJewel(id);
    }
    @GetMapping("/jewerly/update/{id}")
    public void updateJewel(
            @RequestParam Integer id,
            @RequestBody JewelDTO jewelToUpdate
    ){
        JewelDTO jewelById = jewerlyService.findJewel(id);
        if(jewelById != null){

            JewelDTO jewelToSave = jewelToUpdate;
            jewelToSave.setId(id);

            jewerlyService.saveJewel(jewelToSave);
        }
        //tirar error si no lo encuentra

    }



}
