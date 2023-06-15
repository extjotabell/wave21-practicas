package com.meli.obtenerdiploma.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDTO {
    private String name;
    //private String description;
    List<String> description;

}
