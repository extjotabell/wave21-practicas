package com.example.demo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "productos")
@TypeAlias("producto")
public class Producto {
    @Id
    private String id;
    @Field(fielddata = true, type = FieldType.Text)
    private String nombre;
    @Field(fielddata = true, type = FieldType.Text)
    private String tipo;
    @Field(type = FieldType.Integer)
    private Integer precioVenta;
    @Field(type = FieldType.Integer)
    private Integer precioCosto;
    @Field(type = FieldType.Integer)
    private Integer cantDisp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Integer precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Integer precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Integer getCantDisp() {
        return cantDisp;
    }

    public void setCantDisp(Integer cantDisp) {
        this.cantDisp = cantDisp;
    }
}
