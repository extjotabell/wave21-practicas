package wave21.StarWars.repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import wave21.StarWars.model.Personaje;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Getter
public class StarWarsRepository {

    List<Personaje> personajes;
    public StarWarsRepository() {
        personajes = new ArrayList<>();
        loadData();
    }

    public List<Personaje> findAllByName(String name){
        List<Personaje> aRetornar = new ArrayList<>();
        for(Personaje p : personajes){
            if(p.getName().equals(name)){
                aRetornar.add(p);
            }
        }
        return aRetornar;
    }

    private boolean matchWith(String name, Personaje personaje) {
        return personaje.getName().toUpperCase().contains(name.toUpperCase());
    }


    public void loadData(){
        personajes.add(new Personaje("Luke Skywalker", 172, 77, "blond", "fair", "blue", "19BBY", "male", "Tatooine", "Human"));
    }

/*
    private List<Personaje> loadDataBase() {
        File file = null;
        try {
            file = ResourceUtils.getFile("classpath:starwars_characters.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personaje>> typeRef = new TypeReference<>() {};
        List<Personaje> characters = null;
        try {
            characters = objectMapper.readValue(file, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return characters;
    }
*/

}
