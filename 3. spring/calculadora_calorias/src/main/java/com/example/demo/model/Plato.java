package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Plato {
    private String nombre;
    private int gramos;
    private List<String> ingredientes;
}
