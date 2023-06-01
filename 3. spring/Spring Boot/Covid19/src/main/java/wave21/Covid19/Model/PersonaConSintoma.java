package wave21.Covid19.Model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaConSintoma {
    private String idPersona;
    private List<String> sintomas;
}
