package wave21.Covid19.DTO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SintomaDTO {
    private String codigo;
    private String nombre;
    private int nivelDeGravedad;
}
