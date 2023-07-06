package com.joyeria.lasperlas.controller;

import com.joyeria.lasperlas.dto.request.JoyaRequestDTO;
import com.joyeria.lasperlas.model.Joya;
import com.joyeria.lasperlas.service.IJoyeriaService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class JoyeriaController {

    private IJoyeriaService service;

    ModelMapper mapper;

    public JoyeriaController(IJoyeriaService service){
        this.service = service;
        this.mapper = new ModelMapper();
    }

    @GetMapping("/jewerly")
    public List<Joya> getJoyas () {
        return service.getJoyas().stream().filter(Joya::getVentaONo).toList();
    }

    @PostMapping("/jewerly/new")
    public ResponseEntity<?> createJoya(@RequestBody JoyaRequestDTO joyaDTO) {
        Joya joya = mapper.map(joyaDTO, Joya.class);
        joya.setVentaONo(true);
        Joya response = service.saveJoya(joya);
        return new ResponseEntity<>(String.format("La joya fue agregada correctamente con el nro identificatorio %s",
                response.getNroIdentificatorio()), HttpStatus.OK);
    }

    @DeleteMapping("/jewerly/delete/{id}")
    public ResponseEntity<?> deleteStudent (@PathVariable long id) {
        Joya response = service.findJoya(id);
        response.setVentaONo(false);
        service.saveJoya(response);
        return new ResponseEntity<>("La joya fue borrada correctamente", HttpStatus.OK);
    }

    @PatchMapping ("/jewerly/update/{id}")
    public ResponseEntity<?> editJoya (@PathVariable long id,
                                @RequestBody JoyaRequestDTO joya) {
        Joya response = service.findJoya(id);
        response.setNombre(joya.getNombre());
        response.setMaterial(joya.getMaterial());
        response.setPeso(joya.getPeso());
        response.setParticularidad(joya.getParticularidad());
        response.setPoseePiedra(joya.getPoseePiedra());
        service.saveJoya(response);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }
}
