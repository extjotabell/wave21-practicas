package com.example.be_java_hisp_w21_g1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    int user_id;
    String user_name;
    ArrayList<User> followers;
    ArrayList<User> followed;
    ArrayList<Post> publication;

    boolean isSeller(){
        return publication.size()>0;
    }
}
