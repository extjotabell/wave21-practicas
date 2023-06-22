package com.example.be_java_hisp_w21_g1.DTO.Request;

import com.example.be_java_hisp_w21_g1.DTO.Response.ProductDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
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
public class PostProductDTO {

  @NotNull(message = "User_id can't be empty")
  @Positive(message = "User_id can't be less than 0")
  Integer user_id;

  @JsonFormat(pattern="dd-MM-yyyy")
  @NotNull(message = "The date cannot be null")
  LocalDate date;

  @Valid
  ProductDTO product;

  @NotNull(message = "Category can't be empty")
  Integer category;

  @NotNull(message = "Price cannot be null")
  @Range(max = 10000000, message = "Price cannot be higher than 10.000.000")
  Double price;
}
