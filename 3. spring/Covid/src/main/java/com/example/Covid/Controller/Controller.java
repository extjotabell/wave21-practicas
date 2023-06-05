package com.example.Covid.Controller;

import com.example.Covid.Persona;
import com.example.Covid.PersonasRiesgoDTO;
import com.example.Covid.Sintoma;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping
@RestController
public class Controller {
    List<Persona> personas;
    List<Sintoma> sintomas;

    @GetMapping({"/findSymptom"})
    public ResponseEntity<String> findSymptom()
    {
        String sintoma = "";
        for(int i = 0; i<sintomas.size(); i++)
        {
            sintoma += sintomas.get(i).toString();
        }
        return new ResponseEntity<>(sintoma, HttpStatus.OK);
    }

    @GetMapping({"/findSymptom/{name}"})
    public ResponseEntity<String> findSymptomByName(@PathVariable String name)
    {
        String stringResponse = "";
        Optional<Sintoma> sintoma = sintomas.stream().filter(x->x.getNombre().equals(name)).findFirst();
        if (sintoma.isPresent()) {
            return new ResponseEntity<>(sintoma.get().getGravedad(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping({"/findRiskPerson"})
    public ResponseEntity<List<PersonasRiesgoDTO>> findRiskPerson()
    {
        List<PersonasRiesgoDTO> retorno = new ArrayList<>();
        List<Persona> personasStream = (List<Persona>) personas.stream().filter(x->x.getEdad()>60);
        for (int i = 0; i<personasStream.size(); i++)
        {
            Persona p = personasStream.get(i);
            PersonasRiesgoDTO pr = new PersonasRiesgoDTO(p.getNombre(), p.getApellido());
            retorno.add(pr);
        }
        return new ResponseEntity<>(retorno, HttpStatus.OK);
    }
}
