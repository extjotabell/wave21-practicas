package com.example_dto_response_entity_segundaparte.dto_response_entity_segundaparte;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class SportController {
    private List<Sport> sports;
    private List<Person> sportsPersons;

    public SportController() {
        Sport football = new Sport("Football", "Professional");
        Sport basketball = new Sport("Basketball", "Amateur");
        Sport tennis = new Sport("Tennis", "Semi-Professional");

        sports = new ArrayList<>();
        sports.add(football);
        sports.add(basketball);
        sports.add(tennis);

        Person john = new Person("John", "Doe", 28, football);
        Person jane = new Person("Jane", "Doe", 30, tennis);
        Person mark = new Person("Mark", "Twain", 34, basketball);

        sportsPersons = new ArrayList<>();
        sportsPersons.add(john);
        sportsPersons.add(jane);
        sportsPersons.add(mark);
    }

    @GetMapping("/findSports")
    public List<Sport> findAllSports() {
        return sports;
    }

    @GetMapping("/findSport/{name}")
    public ResponseEntity<Sport> findSportByName(@PathVariable String name) {
        System.out.println("name");
        System.out.println(name);
        Optional<Sport> sport = sports.stream()
                .filter(s -> s.getName().equalsIgnoreCase(name))
                .findFirst();

        if (sport.isPresent()) {
            return ResponseEntity.ok(sport.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findSportsPersons")
    public List<SportsPersonDTO> findAllSportsPersons() {
        return sportsPersons.stream()
                .map(p -> new SportsPersonDTO(p.getFirstName(), p.getLastName(), p.getSport().getName()))
                .collect(Collectors.toList());
    }
}
