package com.example.generico.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Persona {
  Integer id;
  String nombre;
  String apellido;
  int edad;
  float peso;
  float altura;
  String habilidades;
}
