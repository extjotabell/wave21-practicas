package com.mercadolibre.practicasspringapis.models;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Symptom {
    private int code;
    private String name;
    private String severity;
}
