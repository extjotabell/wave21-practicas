package com.cardealership.cardealership.Service;

import com.cardealership.cardealership.Dto.CarRequestDto;
import com.cardealership.cardealership.Dto.CarResponseDto;
import com.cardealership.cardealership.Entity.Car;
import com.cardealership.cardealership.Repository.ICarDealershipRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarDealershipServiceImpl implements ICarDealershipService{
    private ICarDealershipRepository _repository;
    private ModelMapper modelMapper;
    public CarDealershipServiceImpl(ICarDealershipRepository repository){
        this._repository = repository;
        this.modelMapper = new ModelMapper();
    }
    @Override
    public void addCar(CarRequestDto car) {
        this._repository.agregar(modelMapper.map(car, Car.class));
    }

    @Override
    public List<CarResponseDto> getAll() {
        return this._repository.getAll().stream().map(car -> modelMapper.map(car, CarResponseDto.class)).toList();
    }

    @Override
    public List<CarResponseDto> getByDate(Integer model) {
        return this._repository.getByDate(model).stream()
                .map(car -> modelMapper.map(car, CarResponseDto.class)).toList();
    }

    @Override
    public List<CarResponseDto> getByPrice(Double price) {
        return this._repository.getByPrice(price).stream()
                .map(car -> modelMapper.map(car, CarResponseDto.class)).toList();
    }

    @Override
    public CarResponseDto getById(Long id) {
        return modelMapper.map(this._repository.getById(id), CarResponseDto.class);
    }
}
