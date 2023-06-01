package com.example.consesionariadeautos.repository;

import com.example.consesionariadeautos.model.Car;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    private List<Car> cars = new ArrayList<>();

    public List<Car> getCars(){
        return this.cars;
    }

    public List<Car> getCarsByDate(LocalDate since, LocalDate to){
        return this.cars.stream()
                .filter(car -> car.getManufacturingDate().isAfter(since) && car.getManufacturingDate().isBefore(to))
                .collect(Collectors.toList());
    }

    public List<Car> getCarsByPrice(String since, String to){
        return this.cars.stream()
                .filter(car -> Integer.parseInt(car.getPrice()) >= Integer.parseInt(since) && Integer.parseInt(car.getPrice()) <= Integer.parseInt(to))
                .collect(Collectors.toList());
    }

    public Car getCarById(int id){
        return this.cars.stream()
                .filter(car -> car.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addCar(Car car){
        this.cars.add(car);
    }
}
