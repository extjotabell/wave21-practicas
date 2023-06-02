package com.cardealership.cardealership.Repository;

import com.cardealership.cardealership.Dto.CarRequestDto;
import com.cardealership.cardealership.Entity.Car;

import java.util.List;

public interface ICarDealershipRepository {
    void agregar(Car car);
    List<Car> getAll();
    List<Car> getByDate(Integer model);
    List<Car> getByPrice(Double price);
    Car getById(Long id);


}
