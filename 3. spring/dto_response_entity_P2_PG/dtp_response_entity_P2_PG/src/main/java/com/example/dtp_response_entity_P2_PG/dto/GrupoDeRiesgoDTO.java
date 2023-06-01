package com.example.dtp_response_entity_P2_PG.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GrupoDeRiesgoDTO implements Serializable {
    PersonasDTO persona;
    List<SintomasDTO> sintoma;
}
