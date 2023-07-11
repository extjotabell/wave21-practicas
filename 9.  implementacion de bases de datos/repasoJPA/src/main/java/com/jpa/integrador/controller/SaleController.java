package com.jpa.integrador.controller;

import com.jpa.integrador.dto.SuccessDTO;
import com.jpa.integrador.dto.request.SaleRequestDTO;
import com.jpa.integrador.dto.response.ClothesListResponseDTO;
import com.jpa.integrador.dto.response.SaleListResponseDTO;
import com.jpa.integrador.dto.response.SaleResponseDTO;
import com.jpa.integrador.service.ISaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/api")
public class SaleController {

    @Autowired
    ISaleService saleService;

    @PostMapping("/sale")
    public ResponseEntity<SuccessDTO> addSale(@RequestBody SaleRequestDTO dto){
        if(saleService.addSale(dto))
            return ResponseEntity.ok().body(new SuccessDTO("Se agrego una nueva venta", 201));
        else
            throw new RuntimeException();
    }

    @GetMapping("/sale")
    public ResponseEntity<SaleListResponseDTO> findAllSales(){
        return ResponseEntity.ok().body(saleService.findAllSales());
    }
    @GetMapping("/sale/{number}")
    public ResponseEntity<SaleResponseDTO> findOneSale(@PathVariable("number") Integer id){
        SaleResponseDTO responseDTO = saleService.findOneSale(id);
        return ResponseEntity.ok().body(responseDTO);
    }

    @PutMapping("/sale/{number}")
    public ResponseEntity<SuccessDTO> updateSale(@PathVariable("number") Integer id, @RequestBody SaleRequestDTO dto){
        if(saleService.updateSale(id, dto))
            return ResponseEntity.ok().body(new SuccessDTO("Se actualizo la venta", 200));
        else
            throw new RuntimeException();
    }

    @DeleteMapping("/sale/{number}")
    public ResponseEntity<SuccessDTO> deleteSale(@PathVariable("number") Integer id){
        if(saleService.deleteSale(id))
            return ResponseEntity.ok().body(new SuccessDTO("Se elimino la venta", 200));
        else
            throw new RuntimeException();
    }

    @GetMapping("/sale/byDate")
    public ResponseEntity<SaleListResponseDTO> findAllSalesByDate(@RequestParam("date") String date){
        SaleListResponseDTO list =  saleService.searchSaleByDate(LocalDate.parse(date));
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/sale/clothes/{number}")
    public ResponseEntity<ClothesListResponseDTO> findAllSalesBySaleId(@PathVariable("number") Integer id){
        ClothesListResponseDTO list =  saleService.searchClothesBySaleId(id);
        return ResponseEntity.ok().body(list);
    }
}
