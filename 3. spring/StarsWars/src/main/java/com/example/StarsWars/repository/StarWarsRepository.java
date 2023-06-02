package com.example.StarsWars.repository;

import com.example.StarsWars.entity.Personaje;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;

@Repository

public class StarWarsRepository {
            private ArrayList<Personaje> personajesList;

            public StarWarsRepository(){
                this.personajesList = new ArrayList<>();
                initData();
            }

            public void initData(){
                Personaje luke = new Personaje("Luke Skywalker", 80, 50, "blonde", "white", "green",
                        "15/02/2021", "m", "marte", "rat");
                Personaje darth = new Personaje("Darth Vader", 50, 50, "black", "blak", "yellow",
                        "15/02/2010", "m", "jupiter", "rat");
                Personaje darth2 = new Personaje("Darth Maul", 120, 50, "blonde", "white", "green",
                        "15/02/2000", "m", "saturno", "rat");

                personajesList.addAll(Arrays.asList(luke,darth,darth2));
            }

            public ArrayList<Personaje> returnPersonajesList(){
                return personajesList;
            }

            public ArrayList<Personaje> filterByName(String name) {
                ArrayList<Personaje> personajesByName = new ArrayList<>();
                for (Personaje personaje: personajesList ) {
                    if(personaje.getName().toLowerCase().contains(name.toLowerCase())){
                        personajesByName.add(personaje);
                    }
                }
                return personajesByName;
            }
}
