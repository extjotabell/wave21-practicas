package com.example.be_java_hisp_w21_g1_dominguez.DTO.Request;

import com.example.be_java_hisp_w21_g1_dominguez.Model.Product;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostProductDTO {
  int user_id;
  @JsonFormat(pattern="dd-MM-yyyy")
  LocalDate date;
  Product product;
  int category;
  Double price;
}
