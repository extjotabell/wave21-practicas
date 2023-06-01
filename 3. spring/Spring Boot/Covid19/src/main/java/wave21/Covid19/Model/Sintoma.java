package wave21.Covid19.Model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Sintoma {
    private String codigo;
    private String nombre;
    private Integer nivelDeGravedad;
}
