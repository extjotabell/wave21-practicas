package com.cardealership.cardealership.Repository;

import com.cardealership.cardealership.Dto.CarRequestDto;
import com.cardealership.cardealership.Entity.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDealershipRepositoryImpl implements ICarDealershipRepository {
    private List<Car> cars;

    public CarDealershipRepositoryImpl(){
        this.cars = new ArrayList<>();
    }

    @Override
    public void agregar(Car car) {
        this.cars.add(car);
    }

    @Override
    public List<Car> getAll() {
        return this.cars;
    }

    @Override
    public List<Car> getByDate(Integer model) {
        return this.cars.stream().filter(car -> Integer.parseInt(car.getModel()) >= model).toList();
    }

    @Override
    public List<Car> getByPrice(Double price) {
        return this.cars.stream().filter(car -> car.getPrice() >= price).toList();
    }

    @Override
    public Car getById(Long id) {
        return this.cars.stream().filter(car -> car.getId().equals(id)).findFirst().orElse(null);
    }
}
