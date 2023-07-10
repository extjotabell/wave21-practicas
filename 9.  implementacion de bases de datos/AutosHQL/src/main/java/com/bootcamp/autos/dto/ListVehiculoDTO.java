package com.bootcamp.autos.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class ListVehiculoDTO {
    private List<VehiculoDTO> vehiculos;
}
