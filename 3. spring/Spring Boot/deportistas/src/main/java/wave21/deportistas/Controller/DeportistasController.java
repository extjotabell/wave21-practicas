package wave21.deportistas.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wave21.deportistas.DTO.DeporteDTO;
import wave21.deportistas.DTO.PersonaDTO;
import wave21.deportistas.DTO.ResponseDTO;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DeportistasController {


    //Inicializo las colecciones de clases con algunos objetos.
    private final List<DeporteDTO> deportes = new ArrayList<>();
    private final List<PersonaDTO> personas = new ArrayList<>();

    public DeportistasController(){
        deportes.add(new DeporteDTO("Football", 2));
        deportes.add(new DeporteDTO("Yoga", 1));
        deportes.add(new DeporteDTO("HIIT", 3));
        personas.add(new PersonaDTO("Javier", "Rydel", 24));
        personas.add(new PersonaDTO("Marcelo", "Perez", 30));
        personas.add(new PersonaDTO("Fabian", "Rodriguez", 35));
    }

    @GetMapping(path = "/findSports")
    public String verDeportes(){
        String aRetornar = "";
        for (DeporteDTO deporte : deportes){
             aRetornar += deporte.toString() + "\n";
        }
        return aRetornar;
    }

    @GetMapping(path = "findSport/{name}")
    public ResponseEntity<String> existeDeporte(@PathVariable String name){
        for(DeporteDTO deporte : deportes){
            if(deporte.getNombre().equals(name)){
                String respuesta = "Nivel de " + name + ": " + deporte.getNivel().toString();
                return ResponseEntity.ok(respuesta);
            }
        }
        return ResponseEntity.ok("No se encontro al deporte");
    }

    @GetMapping(path = "/findSportsPerson")
    public ResponseEntity<String> verPersonasDeportistas(){
        String personasDeportivas = "";
        int i = 0;
        for(PersonaDTO persona : personas){
            ResponseDTO personaDeportiva = new ResponseDTO(persona.getNombre(), deportes.get(i).getNombre());  //Asocio arbitrariamente a cada persona con un deporte en base a su indice.
            personasDeportivas += personaDeportiva.toString(); // + "\n";
        }
        return ResponseEntity.ok(personasDeportivas);
    }
}

/* Ver todos los deportes que tenemos cargados.
PATH: /findSports

Consultar si existe un deporte ingresando su nombre. De existir, se deberá mostrar el nivel del mismo. Utilizar la clase ResponseEntity para devolver la respuesta.
PATH: /findSport/{name}

Visualizar a las personas deportistas. Queremos que se vea un listado con el nombre y el apellido de la persona y el nombre del deporte que realiza (no es necesario que se vea la edad ni el nivel del deporte realizado). Para este punto es importante valerse de un DTO.
PATH: /findSportsPersons
*/