package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TestCaseDTO {
  Long id;
  String description;
  Boolean tested;
  Boolean passed;
  int tries;
  LocalDate lastUpdate;
}
