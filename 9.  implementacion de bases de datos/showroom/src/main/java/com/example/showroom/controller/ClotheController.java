package com.example.showroom.controller;

import com.example.showroom.model.DTO.ClotheDTO;
import com.example.showroom.model.entity.Clothe;
import com.example.showroom.service.IClotheService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clothes")
public class ClotheController implements IClotheController{

    private final IClotheService clotheService;

    public ClotheController(IClotheService clotheService) {
        this.clotheService = clotheService;
    }

    @Override
    public ResponseEntity<Clothe> save(Clothe clothe) {
        return ResponseEntity.ok(clotheService.save(clothe));
    }

    @Override
    public List<Clothe> findAll() {
        return clotheService.findAll();
    }

    @Override
    public Clothe findById(Integer id) {
        return clotheService.findById(id);
    }

    @Override
    public Clothe updateById(Integer id, Clothe clothe) {
        return clotheService.updateById(id, clothe);
    }

    @Override
    public void deleteById(Integer id) {
        clotheService.deleteById(id);
    }

    @Override
    public List<Clothe> findBySize(String size) {
        return clotheService.findBySize(size);
    }

    @Override
    public List<Clothe> findByName(String name) {
        return clotheService.findByName(name);
    }
}
