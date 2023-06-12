package wave21.StarWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import wave21.StarWars.model.Personaje;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Repository
@Getter
public class StarWarsRepository {

    List<Personaje> personajes;
    public StarWarsRepository() {
        personajes = getPersonajesJSON();
    }

    public List<Personaje> findAllByName(String name){
        return personajes.stream().filter(p -> p.getName().contains(name)).toList();
    }

    public List<Personaje> getPersonajesJSON() {
        File file = new File("classpath:starwars_characters.json");
        try{
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeReference = new TypeReference<List<Personaje>>() {};
        List<Personaje> characters = null;
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try {
            characters = mapper.readValue(file, typeReference);
        }
        catch (IOException e){
            e.printStackTrace();
        }

        return characters;
    }
}

