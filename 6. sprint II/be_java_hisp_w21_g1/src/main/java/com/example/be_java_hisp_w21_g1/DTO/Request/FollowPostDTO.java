package com.example.be_java_hisp_w21_g1.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

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
