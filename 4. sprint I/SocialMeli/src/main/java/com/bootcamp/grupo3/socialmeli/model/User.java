package com.bootcamp.grupo3.socialmeli.model;

import lombok.*;

import javax.annotation.processing.Generated;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private int id;
    private String name;
    private List<User> followers;
    private List<User> followed;
}
