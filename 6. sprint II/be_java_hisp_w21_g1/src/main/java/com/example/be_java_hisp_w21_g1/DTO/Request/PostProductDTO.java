package com.example.be_java_hisp_w21_g1.DTO.Request;

import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;
import com.example.be_java_hisp_w21_g1.Model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;


import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Valid
public class PostProductDTO {

  @NotNull(message = "El id no puede estar vacío.")
  @Positive(message = "El id debe ser mayor a cero")
  int user_id;

  @JsonFormat(pattern="dd-MM-yyyy")
  @NotNull(message = "The date cannot be null")
  LocalDate date;

  @Valid ProductDTO product;
  int category;
  @NotNull(message = "Price cannot be null")
  @Range(max = 10000000, message = "Price cannot be higher than 10.000.000")

  Double price;
}
