package com.jewelry.jewelry.controller;

import com.jewelry.jewelry.dto.request.JewelryRequestDto;
import com.jewelry.jewelry.dto.response.JewelryResponseDto;
import com.jewelry.jewelry.dto.response.ResponseDto;
import com.jewelry.jewelry.service.IJewelryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JewelryController {
    private final IJewelryService _iJewelryService;

    public JewelryController(IJewelryService iJewelryService) {
        this._iJewelryService = iJewelryService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto<List<JewelryResponseDto>>> getAllItems() {
        return new ResponseEntity<>(new ResponseDto<>(this._iJewelryService.getAllItems()), HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<ResponseDto<String>> addItem(@RequestBody JewelryRequestDto item) {
        Long id = this._iJewelryService.addItem(item);
        String responseMessage = "Joya agregada correctamente con el id: " + id;
        return new ResponseEntity<>(new ResponseDto<>(responseMessage), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDto<String>> deleteItem(@PathVariable Long id) {
        this._iJewelryService.deleteItem(id);
        String responseMessage = "Joya eliminada correctamente";
        return new ResponseEntity<>(new ResponseDto<>(responseMessage), HttpStatus.OK);
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<ResponseDto<JewelryResponseDto>> updateItem(@PathVariable("id_modificar") Long id, @RequestBody JewelryRequestDto item) {
        return new ResponseEntity<>(new ResponseDto<>(this._iJewelryService.updateItem(id, item)), HttpStatus.OK);
    }
}
