package com.segurodeautos.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licensePlate;
    private String carBrand;
    private String model;
    private LocalDate manufactureYear;
    private int numWheels;


    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private Set<Accident> accidents;
}
