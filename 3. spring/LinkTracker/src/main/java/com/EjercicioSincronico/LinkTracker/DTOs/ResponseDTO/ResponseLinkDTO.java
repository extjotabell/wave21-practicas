package com.EjercicioSincronico.LinkTracker.DTOs.ResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor @AllArgsConstructor
public class ResponseLinkDTO {
    private Integer id;
    private String url;
    private String password;
}
