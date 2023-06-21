package com.example.be_java_hisp_w21_g1.DTO.Request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserIdDTO {

    @NotNull(message = "User_id can't be empty")
    @Positive(message = "User_id can't be less than 0")
    Integer user_id;
}
