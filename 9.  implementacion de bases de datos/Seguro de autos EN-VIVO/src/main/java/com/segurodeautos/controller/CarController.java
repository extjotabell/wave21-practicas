package com.segurodeautos.controller;

import com.segurodeautos.dto.request.CarDTO;
import com.segurodeautos.dto.response.CarResponseDTO;
import com.segurodeautos.dto.response.ListResponseDTO;
import com.segurodeautos.dto.response.MessageDTO;
import com.segurodeautos.service.CarService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CarController {
    CarService service;

    public CarController(CarService service){
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<MessageDTO> createCar(@RequestBody CarDTO carRequestDTO){
        MessageDTO result = service.createCar(carRequestDTO);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

    @GetMapping("/licensePlate")
    public ResponseEntity<ListResponseDTO<String>> getAllLicensePlates(){
//        return new ResponseEntity<>(service.findAllLincensePlates(), HttpStatus.OK);
        return null;
    }

    @GetMapping("/cars")
    public ResponseEntity<List<CarResponseDTO>> findAll(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/licenses")
    public ResponseEntity<?> findAllLicenses(){
        return new ResponseEntity<>(service.getLicensesPlate(), HttpStatus.OK);
    }

    @GetMapping("/licenses/brands")
    public ResponseEntity<?> findAllLicensesBrands(){
        return new ResponseEntity<>(service.getLicenseAndBrandOrderByYear(), HttpStatus.OK);
    }

    @GetMapping("/licenses/4wheels/year")
    public ResponseEntity<?> licenses4WheelsThisYear(){
        return new ResponseEntity<>(service.getAllLicensePlateWhere4WheelsAnThisYear(LocalDate.now().getYear()), HttpStatus.OK);
    }

    @GetMapping("/licenses/brands/model/10000")
    public ResponseEntity<?> getLicenseAndBrandAndModelAccidentGreater10000(){
        return new ResponseEntity<>(service.getLicenseAndBrandAndModelAccidentGreater10000(), HttpStatus.OK);
    }

    @GetMapping("/licenses/brands/model/10000/sum")
    public ResponseEntity<?> getLicenseAndBrandAndModelAccidentGreater10000Sum(){
        return new ResponseEntity<>(service.getLicenseAndBrandAndModelAccidentGreater10000Sum(), HttpStatus.OK);
    }

}
