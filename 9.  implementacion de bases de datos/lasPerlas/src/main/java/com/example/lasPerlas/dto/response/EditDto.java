package com.example.lasPerlas.dto.response;


import com.example.lasPerlas.model.Joya;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditDto {
    private int statusCode;
    private String message;
    private Joya joya;
}
