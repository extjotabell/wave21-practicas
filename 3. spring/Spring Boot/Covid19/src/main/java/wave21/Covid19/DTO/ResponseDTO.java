package wave21.Covid19.DTO;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDTO {
    private String idPersona;
    private List<String> sintomas;
}
