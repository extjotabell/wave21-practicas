package com.bootcamp.deportista.dto;

import ch.qos.logback.core.model.processor.DependencyDefinition;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO {

    private String nombre ;
    private String apellido;
    private String deporte;


}
