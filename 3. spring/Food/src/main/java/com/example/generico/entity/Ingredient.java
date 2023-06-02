package com.example.generico.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.ModelAttribute;

@Getter
@Setter
public class Ingredient {
  Integer id;
  String name;
  int calories;
}
