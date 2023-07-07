package com.example.segurosApi.repository;

import com.example.segurosApi.dto.response.RespPatentAndBrandAndModelDto;
import com.example.segurosApi.dto.response.RespPatentsListAndModelDto;
import com.example.segurosApi.model.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehiculo, Long> {

}
