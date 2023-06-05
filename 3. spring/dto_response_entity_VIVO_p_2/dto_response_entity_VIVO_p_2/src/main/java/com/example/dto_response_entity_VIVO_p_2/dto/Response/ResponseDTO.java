package com.example.dto_response_entity_VIVO_p_2.dto.Response;

import com.example.dto_response_entity_VIVO_p_2.entity.Deporte;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    String nombre;
    String apellido;
    Deporte deporte;
}
