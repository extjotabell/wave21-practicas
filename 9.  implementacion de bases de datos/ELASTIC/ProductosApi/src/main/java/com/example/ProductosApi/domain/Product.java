package com.example.ProductosApi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "products")
@TypeAlias("Product")
public class Product {
    @Id
    private String id;
    @Field(fielddata = true, type = FieldType.Text)
    private String name;
    @Field(fielddata = true, type = FieldType.Text)
    private String type;
    @Field(type = FieldType.Double)
    private Double salePrice;
    @Field(type = FieldType.Double)
    private Double costPrice;
    @Field(type = FieldType.Integer)
    private Integer amount;
}
