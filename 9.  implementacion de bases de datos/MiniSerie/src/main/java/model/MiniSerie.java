package model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import jakarta.persistence.Entity;

@Getter
@Setter

@Entity
public class MiniSerie {

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    String name;

    double rating;

    int amount_of_awards;
}
