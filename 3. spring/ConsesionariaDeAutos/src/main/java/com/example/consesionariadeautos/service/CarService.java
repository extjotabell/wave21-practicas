package com.example.consesionariadeautos.service;

import com.example.consesionariadeautos.dto.request.CarRequestDTO;
import com.example.consesionariadeautos.dto.response.CarResponseDTO;
import com.example.consesionariadeautos.model.Car;
import com.example.consesionariadeautos.repository.CarRepository;
import com.example.consesionariadeautos.service.sequence.CarSequence;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {
    private CarRepository carRepository;
    private ModelMapper modelMapper;

    public CarService(CarRepository carRepository, ModelMapper modelMapper){
        this.carRepository = carRepository;
        this.modelMapper = modelMapper;
    }

    public CarResponseDTO addCar(CarRequestDTO carRequestDTO){
        Car car = modelMapper.map(carRequestDTO, Car.class);
        car.setId(CarSequence.getNextValue());

        carRepository.addCar(car);

        return modelMapper.map(car, CarResponseDTO.class);
    }

    public List<CarResponseDTO> getCars(){
        return carRepository.getCars().stream()
                .map(car -> modelMapper.map(car, CarResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<CarResponseDTO> getCarsByDate(LocalDate since, LocalDate to){
        return carRepository.getCarsByDate(since, to).stream()
                .map(car -> modelMapper.map(car, CarResponseDTO.class))
                .collect(Collectors.toList());
    }

    public List<CarResponseDTO> getCarsByPrice(String since, String to){
        return carRepository.getCarsByPrice(since, to).stream()
                .map(car -> modelMapper.map(car, CarResponseDTO.class))
                .collect(Collectors.toList());
    }

    public CarResponseDTO getCarById(Integer id){
        Car car = carRepository.getCarById(id);
        return car == null ? null : modelMapper.map(carRepository.getCarById(id), CarResponseDTO.class);
    }
}
