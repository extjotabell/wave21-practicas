package com.example.be_java_hisp_w21_g1.DTO.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FollowPostDTO {

    @NotEmpty(message = "El  id no puede estar vacío.")
    @PositiveOrZero(message = "El id debe ser mayor a cero")
    int userId;

    int userIdToFollow;
}
