package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Document(indexName = "obrasLiterarias")
@TypeAlias("obraLiteraria")
public class ObraLiteraria {
    @Id
    private String id;
    @Field(fielddata = true, type = FieldType.Text)
    private String nombre;
    @Field()
    private String autor;
    @Field()
    private Integer cantPaginas;
    @Field()
    private Integer editorial;
    @Field()
    private LocalDate primeraPublicacion;


    //Getters & Setter
    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setCantPaginas(Integer cantPaginas) {
        this.cantPaginas = cantPaginas;
    }

    public void setEditorial(Integer editorial) {
        this.editorial = editorial;
    }

    public void setPrimeraPublicacion(LocalDate primeraPublicacion) {
        this.primeraPublicacion = primeraPublicacion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getCantPaginas() {
        return cantPaginas;
    }

    public Integer getEditorial() {
        return editorial;
    }

    public LocalDate getPrimeraPublicacion() {
        return primeraPublicacion;
    }
}
