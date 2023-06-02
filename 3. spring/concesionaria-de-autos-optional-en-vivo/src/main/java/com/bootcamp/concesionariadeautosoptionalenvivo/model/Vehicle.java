package com.bootcamp.concesionariadeautosoptionalenvivo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {
    private int id;
    private String brand;
    private String model;
    private LocalDateTime manufacturingDate;
    private int numberOfKilometers;
    private int doors;
    private double price;
    private String currency;
    private List<Service> services;
    private int countOfOwners;
}
