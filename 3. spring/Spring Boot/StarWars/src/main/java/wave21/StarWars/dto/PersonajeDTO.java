package wave21.StarWars.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonajeDTO {
    String name;
    Integer height;
    Integer mass;
    String gender;
    String homeworld;
    String species;
}
