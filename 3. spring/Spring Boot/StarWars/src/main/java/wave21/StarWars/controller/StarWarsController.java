package wave21.StarWars.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import wave21.StarWars.dto.PersonajeDTO;
import wave21.StarWars.service.StarWarsService;

import java.util.List;

@RestController
public class StarWarsController {

    /*@Autowired
    private StarWarsService service;*/

    private final StarWarsService service;

    public StarWarsController(StarWarsService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    public List<PersonajeDTO> find(@PathVariable String name){
        return service.find(name);
    }
}
