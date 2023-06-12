package wave21.StarWars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wave21.StarWars.dto.PersonajeDTO;
import wave21.StarWars.model.Personaje;
import wave21.StarWars.repository.StarWarsRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class StarWarsService {
    /*@Autowired
    StarWarsRepository repository;*/

    public StarWarsRepository repository;

    public StarWarsService(StarWarsRepository repository) {
        this.repository = repository;
    }

    public List<Personaje> listAll(){
        return repository.getPersonajesJSON();
    }
    public List<PersonajeDTO> find(String name){
        List<Personaje> personajes = repository.findAllByName(name);
        List<PersonajeDTO> personajesDTOS = new ArrayList<>();
        for (Personaje p : personajes){
            PersonajeDTO personajeDTO = new PersonajeDTO(p.getName(), p.getHeight(), p.getMass(), p.getGender(), p.getHomeworld(), p.getSpecies());
            personajesDTOS.add(personajeDTO);
        }
        return personajesDTOS;
    }
}
