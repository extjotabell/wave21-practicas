package com.cardealership.cardealership.Service;

import com.cardealership.cardealership.Dto.CarRequestDto;
import com.cardealership.cardealership.Dto.CarResponseDto;
import com.cardealership.cardealership.Entity.Car;

import java.util.List;

public interface ICarDealershipService {
    void addCar(CarRequestDto car);
    List<CarResponseDto> getAll();
    List<CarResponseDto> getByDate(Integer model);
    List<CarResponseDto> getByPrice(Double price);
    CarResponseDto getById(Long id);
}
