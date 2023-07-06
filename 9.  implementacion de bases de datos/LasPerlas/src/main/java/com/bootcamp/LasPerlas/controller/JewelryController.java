package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.DTO.request.JewelDTORequest;
import com.bootcamp.LasPerlas.DTO.response.JewelryResponseDTO;
import com.bootcamp.LasPerlas.DTO.response.MessageDTO;
import com.bootcamp.LasPerlas.DTO.response.UpdatedJewelDTO;
import com.bootcamp.LasPerlas.service.JewerlyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly/")
public class JewelryController {
    private JewerlyService jewerlyService;

    public JewelryController(JewerlyService jewerlyService) {
        this.jewerlyService = jewerlyService;
    }

    @PostMapping("new")
    public ResponseEntity<MessageDTO> createJewel(@RequestBody JewelDTORequest createJewelDTO){
        MessageDTO response = jewerlyService.createJewel(createJewelDTO);
        response.setMessage(HttpStatus.CREATED.toString());
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("")
    public ResponseEntity<JewelryResponseDTO> getAllJewerly(){
        JewelryResponseDTO jewelryResponseDTO = jewerlyService.getAllJewerly();
        jewelryResponseDTO.setStatusCode(HttpStatus.OK.value());
        return ResponseEntity.ok(jewelryResponseDTO);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteJewel(@PathVariable long id){
        jewerlyService.deleteJewel(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UpdatedJewelDTO> updateJewel(@PathVariable long id, @RequestBody JewelDTORequest body){
        JewelDTO response = jewerlyService.updateJewel(id,body);
        return ResponseEntity.ok(new UpdatedJewelDTO(HttpStatus.))

    }
}
