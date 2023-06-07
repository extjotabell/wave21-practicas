package com.example.be_java_hisp_w21_g02.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;

@Setter @Getter
@NoArgsConstructor @AllArgsConstructor
public class FollowersListDTO {
    private int userId;
    private String userName;
    private List<FollowerDTO> followers;
}
