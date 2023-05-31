package com.deportistas.deportistas.DTOS;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DeportistaDTO implements Serializable {
    private String nombreCompleto;
    private String deporte;
}
