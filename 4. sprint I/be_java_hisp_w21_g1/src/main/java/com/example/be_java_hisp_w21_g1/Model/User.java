package com.example.be_java_hisp_w21_g1.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    int user_id;
    String user_name;
    List<User> followers;
    List<User> followed;
    List<Post> posts;

    boolean isSeller(){
        return posts.size()>0;
    }
}
