package com.sprint.be_java_hisp_w21_g04.entity;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int userId;
    private String userName;
    //¿Quiénes me siguen?
    private List<Integer> followers;
    //¿A quién sigo?
    private List<Integer> followed;
}