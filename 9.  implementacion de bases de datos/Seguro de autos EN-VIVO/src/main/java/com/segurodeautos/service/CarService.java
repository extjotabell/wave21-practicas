package com.segurodeautos.service;

import com.segurodeautos.dto.request.CarDTO;
import com.segurodeautos.dto.response.*;
import com.segurodeautos.model.Car;
import com.segurodeautos.repository.CarInsuranceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CarService {

    CarInsuranceRepository repository;

    private final ModelMapper modelMapper;

    public  CarService(ModelMapper modelMapper, CarInsuranceRepository repository){
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    public MessageDTO createCar(CarDTO carDTO){
        Car response = repository.save(modelMapper.map(carDTO, Car.class));
        return new MessageDTO(String.format("Se ha creado con el id %s", response.getId()));
    }

    public List<CarResponseDTO> findAll(){
        List<Car> cars = repository.findAll();
        List<CarResponseDTO> result = cars.stream().map(car -> modelMapper.map(car, CarResponseDTO.class)).toList();

        return  result;
    }

    public List<String> getLicensesPlate(){
        return repository.getAllLicensesPlate();
    }

    public List<LicenseBrandDTO> getLicenseAndBrandOrderByYear(){
        List<Object> response = repository.getAllLicensePlatAndBrandOrderByYear();
        List<LicenseBrandDTO> result = new ArrayList<>();
        response.forEach(item -> {
            Object[] items = (Object[]) item;
            result.add(new LicenseBrandDTO((String) items[0], (String) items[1]));
        });
        return result;
    }

    public List<String> getAllLicensePlateWhere4WheelsAnThisYear(int year){
        return repository.getAllLicensePlateWhere4WheelsAnThisYear(year);
    }

    public List<LicenseBrandModelDTO> getLicenseAndBrandAndModelAccidentGreater10000(){
        List<Object> response = repository.getLicenseAndBrandAndModelAccidentGreater10000();
        List<LicenseBrandModelDTO> result = new ArrayList<>();
        response.forEach(item -> {
            Object[] items = (Object[]) item;
            result.add(new LicenseBrandModelDTO((String) items[0], (String) items[1], (String) items[2]));
        });
        return result;
    }

    public VehiculoSiniestroDTO getLicenseAndBrandAndModelAccidentGreater10000Sum(){
        try{
            List<Object> response = repository.getLicenseAndBrandAndModelAccidentGreater10000();
            List<LicenseBrandModelDTO> result = new ArrayList<>();
            Long total = (Long) repository.getLicenseAndBrandAndModelAccidentGreater10000Sum();
            response.forEach(item -> {

                Object[] items = (Object[]) item;
                result.add(new LicenseBrandModelDTO((String) items[0], (String) items[1], (String) items[2]));
            });
            return new VehiculoSiniestroDTO(result,total);
        }catch (InvalidDataAccessResourceUsageException e){
            return new VehiculoSiniestroDTO(Collections.EMPTY_LIST,0L);
        }
    }
}
