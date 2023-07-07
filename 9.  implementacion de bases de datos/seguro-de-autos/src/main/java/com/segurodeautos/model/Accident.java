package com.segurodeautos.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Entity
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate accidentDate;
    private Double economicLost;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
