package com.bootcamp.concesionariadeautosoptionalenvivo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Service {
    private LocalDateTime date;
    private int kilometers;
    private String descriptions;
}
