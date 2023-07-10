package com.example.demo.domain;

import jakarta.persistence.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "empleados")
@TypeAlias(value = "empleado")
public class Empleado {
  @Id
  private String id;
  @Field(type = FieldType.Text)
  private String name;
}
