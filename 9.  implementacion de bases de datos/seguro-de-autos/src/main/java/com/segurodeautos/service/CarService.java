package com.segurodeautos.service;

import com.segurodeautos.dto.request.AccidentDTO;
import com.segurodeautos.dto.request.CarDTO;
import com.segurodeautos.dto.response.CarResponseDTO;
import com.segurodeautos.dto.response.MessageDTO;
import com.segurodeautos.model.Car;
import com.segurodeautos.repository.CarInsuranceRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
//        cars.forEach(car -> {
//            CarDTO modelMapper.map(car, CarResponseDTO.class);
//            car.getAccidents()
//                    .stream()
//                    .map(accident -> modelMapper.map(accident, AccidentDTO.class));
//        });
    }
}
