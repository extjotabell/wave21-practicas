package com.mercadolibre.starwars.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class CharacterDTO {
  private String name;
  private String hair_color;
  private String skin_color;
  private String eye_color;
  private String birth_year;
  private String gender;
  private String homeworld;
  private String species;
  private Integer height;
  private Integer mass;
}
