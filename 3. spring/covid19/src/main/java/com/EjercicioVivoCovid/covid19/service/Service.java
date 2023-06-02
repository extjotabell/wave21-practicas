package com.EjercicioVivoCovid.covid19.service;

import com.EjercicioVivoCovid.covid19.dto.PersonDTO;
import com.EjercicioVivoCovid.covid19.dto.PersonSymptomDTO;
import com.EjercicioVivoCovid.covid19.dto.SymptomDTO;

import java.util.ArrayList;
import java.util.List;

public class Service {

    public ArrayList<SymptomDTO> symptomDTOArrayList = new ArrayList<>();
    public ArrayList<PersonSymptomDTO> personSymptomDTOArrayList = new ArrayList<>();
    public Service() {
        SymptomDTO symptomDTO1 = new SymptomDTO(1,"fiebre", 3);
        SymptomDTO symptomDTO2 = new SymptomDTO(2,"dolor de cabeza", 2);
        SymptomDTO symptomDTO3 = new SymptomDTO(3,"mal estomacal", 4);
        symptomDTOArrayList.add(symptomDTO1);
        symptomDTOArrayList.add(symptomDTO2);
        symptomDTOArrayList.add(symptomDTO3);

        PersonDTO personDTO1 = new PersonDTO(1,"Juan", "Perez", 30);
        PersonDTO personDTO2 = new PersonDTO(2,"Jose", "Diaz", 65);
        PersonDTO personDTO3 = new PersonDTO(3,"Manuel", "Vazquez", 71);

        PersonSymptomDTO personSymptomDTO1 = new PersonSymptomDTO(personDTO1, symptomDTOArrayList);
        PersonSymptomDTO personSymptomDTO2 = new PersonSymptomDTO(personDTO2, symptomDTOArrayList);
        PersonSymptomDTO personSymptomDTO3 = new PersonSymptomDTO(personDTO3, symptomDTOArrayList);
        personSymptomDTOArrayList.add(personSymptomDTO1);
        personSymptomDTOArrayList.add(personSymptomDTO2);
        personSymptomDTOArrayList.add(personSymptomDTO3);
    }

    public SymptomDTO existSymptom(String name){
        SymptomDTO symp = new SymptomDTO();
        for (SymptomDTO symptom: symptomDTOArrayList) {
            if(symptom.getName().equals(name)){
                symp = symptom;
            }
        }
        return symp;
    }
    public ArrayList<SymptomDTO> symptomlist(){
        return symptomDTOArrayList;
    }

    public ArrayList<PersonSymptomDTO> personWithRisk(){
        ArrayList<PersonSymptomDTO> personsRisk = new ArrayList<>();
        for (PersonSymptomDTO persons: personSymptomDTOArrayList ) {
            if(persons.getPersonDTO().getAge() > 60 && !persons.getSymptomDTO().isEmpty()){
                personsRisk.add(persons);
            }
        }
        return personsRisk;
    }





}
