package com.EjercicioVivoCovid.covid19.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PersonSymptomDTO {

    PersonDTO personDTO;
    ArrayList<SymptomDTO> symptomDTO;
}
