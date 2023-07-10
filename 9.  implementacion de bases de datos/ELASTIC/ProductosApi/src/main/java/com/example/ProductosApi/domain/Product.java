package com.example.ProductosApi.domain;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@Document(indexName = "Products")
public class Product {
    @Id
    private String id;
    @Field(fielddata = true, type = FieldType.Text)
    private String name;
    @Field(fielddata = true, type = FieldType.Text)
    private String type;
    @Field(fielddata = true, type = FieldType.Double)
    private Double salePrice;
    @Field(fielddata = true, type = FieldType.Double)
    private Double costPrice;
    @Field(fielddata = true, type = FieldType.Integer)
    private Integer amount;
}
