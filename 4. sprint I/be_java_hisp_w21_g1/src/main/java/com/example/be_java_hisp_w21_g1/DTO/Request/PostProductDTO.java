package com.example.be_java_hisp_w21_g1.DTO.Request;

import com.example.be_java_hisp_w21_g1.Model.Product;
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
  boolean hasPromo;
  double discount;
  public PostProductDTO(int user_id, LocalDate date, Product product, int category, Double price) {
    this.user_id = user_id;
    this.date = date;
    this.product = product;
    this.category = category;
    this.price = price;
    this.hasPromo = false;
    this.discount = 0.0;
  }
}
