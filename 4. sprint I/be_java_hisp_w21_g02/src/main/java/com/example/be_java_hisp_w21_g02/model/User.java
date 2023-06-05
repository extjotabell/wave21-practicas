package com.example.be_java_hisp_w21_g02.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private List<Integer> following;
    private List<Integer> followers;
    private List<Post> posts;

    public boolean isSeller(){
        // TODO
        return true;
    }
}
