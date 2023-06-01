package wave21.Covid19.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Persona {
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
}
