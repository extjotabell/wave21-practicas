package com.mercadolibre.calculadorametroscuadrados.dto;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class HouseDTO {
  private String name;
  private String address;
  private List<RoomDTO> rooms;

}
