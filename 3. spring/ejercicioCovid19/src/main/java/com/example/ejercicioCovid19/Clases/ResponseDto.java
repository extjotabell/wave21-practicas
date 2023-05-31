package com.example.ejercicioCovid19.Clases;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto implements Serializable {
    private String nombre;
    private String apellido;

}
