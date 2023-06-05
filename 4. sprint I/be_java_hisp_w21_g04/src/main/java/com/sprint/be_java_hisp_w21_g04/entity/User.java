package com.sprint.be_java_hisp_w21_g04.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private int user_id;
    private String user_name;
    //¿Quiénes me siguen?
    private List<Integer> followers;
    //¿A quién sigo?
    private List<Integer> followed;

}