package com.mercadolibre.practicasspringapis.dtos.covid19;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SymptomDTO implements Serializable {

    private int code;
    private String name;
    private String severity;

}
