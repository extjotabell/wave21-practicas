package com.Empleados.Empleados.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "empleado")
public class Empleado {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;
    private String estado;
    private String departamento;
}
