package com.obrasliterarias.model.entity;

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
@Document(indexName = "obras")
@TypeAlias("obra")
public class Obra {
    @Id
    private String id;
    @Field(fielddata = true, type = FieldType.Text)
    private String nombre;
    @Field(fielddata = true, type = FieldType.Text)
    private String autor;
    @Field()
    private Integer cantidadPaginas;
    @Field(fielddata = true, type = FieldType.Text)
    private String editorial;
    @Field()
    private Integer year;
}
