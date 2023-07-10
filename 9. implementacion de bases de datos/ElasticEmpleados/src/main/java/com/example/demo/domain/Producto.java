package com.example.demo.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Getter
@Setter
@Document(indexName = "products")
@TypeAlias(value = "product")
public class Producto {
  @Id
  private String id;
  @Field(type = FieldType.Text)
  private String name;
  @Field(type = FieldType.Text)
  private String tipo;
  @Field(type = FieldType.Double)
  private Double precio;
}
