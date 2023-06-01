package com.practicasIntegradoras.Deportistas.dto;

import lombok.*;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonSportDTO implements Serializable {

    String name;
    String surName;
    String sportName;

}
