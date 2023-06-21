package com.example.be_java_hisp_w21_g1.DTO.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserIdDTO {

    @NotEmpty(message = "El  id no puede estar vacío.")
    @PositiveOrZero(message = "El id debe ser mayor a cero")
    int user_id;
}
