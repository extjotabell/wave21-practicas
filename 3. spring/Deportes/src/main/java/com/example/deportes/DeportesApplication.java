package com.example.deportes;

import com.example.deportes.clase.Person;
import com.example.deportes.clase.Sport;
import com.example.deportes.clase.SportPerson;
import com.example.deportes.service.SportService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DeportesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeportesApplication.class, args);

        Person person = new Person("Matias", "Tato", 23);
        Person person1 = new Person("Pepito", "Gomez", 32);

        Sport sport = new Sport("Fulbo", "Avanzado");
        Sport sport1 = new Sport("Fulbo 5", "Bajo");

        SportService.sports.add(sport);
        SportService.sports.add(sport1);
        SportService.sportPersons.add(new SportPerson(person, List.of(sport, sport1)));
        SportService.sportPersons.add(new SportPerson(person1, List.of(sport1)));
    }

}
