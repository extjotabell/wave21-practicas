package com.bootcamp.grupo3.socialmeli.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.annotation.processing.Generated;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private int id;
    private String name;
    private List<User> followers;
    private List<User> followed;

}
