package controller;

import com.EjercicioVivoCovid.covid19.dto.PersonSymptomDTO;
import com.EjercicioVivoCovid.covid19.dto.SymptomDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import service.Service;

import java.util.ArrayList;

@RestController
@RequestMapping("/covid")
public class Controller {

    Service service = new Service();


    @GetMapping("findSymptom")
    public ResponseEntity<ArrayList<SymptomDTO>> sintomas(){

        return new ResponseEntity<>(service.symptomlist(), HttpStatus.OK);
    }

    @GetMapping("findSymptom")
    public ResponseEntity<Integer> sintomas(@RequestParam String name){
        SymptomDTO symptom = service.existSymptom(name);
        Integer level_symptom = symptom.getLevel_of_gravity();
        return new ResponseEntity<>(level_symptom, HttpStatus.OK);
    }

    @GetMapping("findRiskPerson")
    public ResponseEntity<ArrayList<PersonSymptomDTO>> personWithRisk(){
        return new ResponseEntity<>(service.personWithRisk(), HttpStatus.OK);
    }
}
