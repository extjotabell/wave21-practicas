package wave21.deportistas.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private Integer edad;
}
