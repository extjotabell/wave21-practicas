package com.example.excepciones_P1_VIVO.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogRequestDTO {
    Integer id;
    String titulo;
    String nombreAutor;
    String fechaPublicacion;
}
