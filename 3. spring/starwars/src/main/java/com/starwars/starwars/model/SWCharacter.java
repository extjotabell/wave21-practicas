package com.starwars.starwars.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SWCharacter {

   private String name;
   private String height;
   private String mass;
   private String hair_color;
   private String skin_color;
   private String eye_color;
   private String birthYear;
   private String gender;
   private String homeworld;
   private String species;




}
