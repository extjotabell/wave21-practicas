package com.bootcamp.autos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@AllArgsConstructor
@Getter @Setter
public class ListVehiculoPatenteDTO {
    private List<String> patentes;
}
