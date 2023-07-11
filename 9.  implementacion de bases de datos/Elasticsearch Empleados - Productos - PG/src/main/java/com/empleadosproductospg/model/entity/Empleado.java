package com.empleadosproductospg.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Document(indexName = "empleados")
@TypeAlias("empleado")
public class Empleado {
    @Id
    private String id;
    @Field(fielddata = true, type = FieldType.Text)
    private String nombre;
    @Field(fielddata = true, type = FieldType.Text)
    private String apellido;
    @Field(fielddata = true, type = FieldType.Text)
    private String edad;
    @Field(fielddata = true, type = FieldType.Text)
    private String ciudad;
}
