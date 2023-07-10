package com.example.practica1elasticsearch.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "empleados")
@TypeAlias("empleado")
@Data
public class Empleado {
    @Id
    private String id;
    @Field(fielddata = true, type = FieldType.Text)
    private String nombre;
    @Field(fielddata = true, type = FieldType.Text)
    private String apellido;
    @Field(fielddata = true, type = FieldType.Integer)
    private int edad;
    @Field(fielddata = true, type = FieldType.Text)
    private String ciudad;
}
