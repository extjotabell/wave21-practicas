package wave21.Covid19.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wave21.Covid19.DTO.PersonaDTO;
import wave21.Covid19.DTO.ResponseDTO;
import wave21.Covid19.DTO.SintomaDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Covid19Controller {
    private final List<PersonaDTO> personas = new ArrayList<>();
    private final List<SintomaDTO> sintomas = new ArrayList<>();
    private final List<ResponseDTO> grupoDeRiesgo= new ArrayList<>();

    public Covid19Controller(){
        personas.add(new PersonaDTO("1", "Javier", "Rydel", 24));
        personas.add(new PersonaDTO("2", "Marcelo", "Perez", 30));
        personas.add(new PersonaDTO("3", "Fabian", "Fernandez", 33));
        sintomas.add((new SintomaDTO("1", "Gripe", 1)));
        sintomas.add((new SintomaDTO("2", "Sinusitis", 2)));
        sintomas.add((new SintomaDTO("3", "Fiebre", 3)));

        grupoDeRiesgo.add(new ResponseDTO("1", Arrays.asList("1","2") ));
        grupoDeRiesgo.add(new ResponseDTO("2", Arrays.asList("2","3") ));
        grupoDeRiesgo.add(new ResponseDTO("3", Arrays.asList("3") ));
    }

    @GetMapping(path = "/findSymptom")
    public List<SintomaDTO> viewSymptoms(){
        return sintomas;
    }

    @GetMapping(path = "/findSymptom/{name}")
    public ResponseEntity<String> getSymptomLevel(@PathVariable String name){
        for(SintomaDTO sintoma : sintomas){
            if(sintoma.getNombre().equals(name)){
                return ResponseEntity.ok("La gravedad del sintoma es: " + sintoma.getNivelDeGravedad());
            }
        }
        return new ResponseEntity<String>("No existe un sintoma con ese nombre!",HttpStatus.NOT_FOUND);
    }

    @GetMapping(path = "/findRiskPerson")
    public ResponseEntity<String> findRiskPerson(){
        for(ResponseDTO deRiesgo : grupoDeRiesgo){

            PersonaDTO personadeRiesgo = new PersonaDTO();
            for(PersonaDTO persona : personas){
                if (persona.getId().equals(deRiesgo.getIdPersona())){
                    personadeRiesgo = persona;
                }
            }
            if(personadeRiesgo.getEdad() > 60 && deRiesgo.getSintomas().size() >= 1){
                return new ResponseEntity<String>("Nombre: " + personadeRiesgo.getNombre() + "\nApellido: " + personadeRiesgo.getApellido(), HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("No hay pacientes de riesgo!",HttpStatus.NOT_FOUND);
    }
}
