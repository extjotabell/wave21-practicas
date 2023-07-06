package com.JoyeriaLasPerlas.demoDBJoyeria.controller;

import com.JoyeriaLasPerlas.demoDBJoyeria.model.Joya;
import com.JoyeriaLasPerlas.demoDBJoyeria.service.IJoyaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    private IJoyaService joyaService;

    public JoyaController(IJoyaService joyaService) {
        this.joyaService = joyaService;
    }

    @PostMapping("/new")
    public ResponseEntity<String> createJoya (@RequestBody Joya joya){
        joyaService.saveJoya(joya);
        return ResponseEntity.ok("La joya fue creado con el id "+ joya.getN_Identificatorio());
    }

    @GetMapping
    public ResponseEntity<List<Joya>> getJoyas (){
        List<Joya> joyaList = joyaService.getJoya();
        return ResponseEntity.ok(joyaList);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Joya> editJoya (@PathVariable Integer id,
                                                @RequestParam("nombre") String newNombre,
                                                @RequestParam ("material") String newMaterial,
                                                @RequestParam("peso") Double newPeso,
                                                @RequestParam("particularidad") String newParticularidad,
                                                @RequestParam("poseePiedra") Boolean newPoseePiedra,
                                                @RequestParam("ventaONo") Boolean newVenta) {
        Joya joya = joyaService.findJoya(id);
        joya.setNombre(newNombre);
        joya.setMaterial(newMaterial);
        joya.setPeso(newPeso);
        joya.setParticularidad(newParticularidad);
        joya.setPosee_piedra(newPoseePiedra);
        joya.setVentaONo(newVenta);
        joyaService.saveJoya(joya);
        return ResponseEntity.ok(joya);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJoya (@PathVariable Integer id){
        joyaService.deleteJoya(id);
        return ResponseEntity.ok("La joya fue vendida");
    }
}
