package com.movies.elasticDemo.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.*;
import java.util.List;

@Getter@Setter
@Document(indexName = "blog")
public class Articulo {

    @Id
    private String id;

    private String titulo;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Autor> autores;


}
