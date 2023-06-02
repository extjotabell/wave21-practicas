package com.bootcamp.concesionariadeautosoptionalenvivo.dto.request;

import lombok.Data;

@Data
public class VehicleRequestDTO {
    private String brand;
    private String model;
    private String manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private ServiceRequestDTO[] services;
    private String countOfOwners;
}
