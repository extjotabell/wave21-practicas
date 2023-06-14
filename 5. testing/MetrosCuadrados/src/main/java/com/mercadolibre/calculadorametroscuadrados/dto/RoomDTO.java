package com.mercadolibre.calculadorametroscuadrados.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class RoomDTO {
  private String name;
  private Integer width;
  private Integer length;

  public Integer getSquareFeet() {
    Integer result = 0;
    if(this.width != null && this.length != null)
      result = this.width * this.length;
    return result;
  }
}
