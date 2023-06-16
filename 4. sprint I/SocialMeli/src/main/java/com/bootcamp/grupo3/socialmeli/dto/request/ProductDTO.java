package com.bootcamp.grupo3.socialmeli.dto.request;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ProductDTO {

    @NotNull(message = "El id del producto no puede estar vacío.")
    @Positive(message = "El id del producto debe ser mayor a cero")
    private Integer productId;

    @NotEmpty( message = "El nombre del producto no puede estar vacío.")
    @Size(max=40, message = "La longitud no puede superar los 40 caracteres.")
    @Pattern(regexp =  "[\\w\\s]+", message = "El nombre no puede poseer caracteres especiales.")
    private String productName;

    @NotEmpty( message = "El tipo no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp =  "[\\w\\s]+", message = "El tipo no puede poseer caracteres especiales.")
    private String type;

    @Size(max=25, message = "La longitud no puede superar los 25 caracteres.")
    @NotEmpty( message = "La marca no puede estar vacía.")
    @Pattern(regexp =  "[\\w\\s]+", message = "La marca no puede poseer caracteres especiales.")
    private String brand;

    @NotEmpty( message = "El color no puede estar vacío.")
    @Size(max = 15, message = "La longitud no puede superar los 15 caracteres.")
    @Pattern(regexp =  "[\\w\\s]+", message = "El color no puede poseer caracteres especiales.")
    private String color;

    @Size(max = 80, message = "La longitud no puede superar los 80 caracteres.")
    @Pattern(regexp =  "[\\w\\s]+", message = "Las notas no pueden poseer caracteres especiales.")
    private String notes;
}
