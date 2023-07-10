package com.elasticsearch.ejEmpleados.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(indexName = "empleados")
@TypeAlias("empleados")
public class Empleado {
    @Id
    @Field(type =FieldType.Text)
    private String id= UUID.randomUUID().toString();
    @Field(fielddata = true, type = FieldType.Text)
    private String nombre;
    @Field(type =FieldType.Text)
    private String edad;
    @Field(type =FieldType.Text)
    private String ciudad;
    @Field(type =FieldType.Text)
    private String estado;
}
