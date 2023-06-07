package com.example.be_java_hisp_w21_g1.Model;

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
    int user_id;
    String user_name;
    List<User> followers;
    List<User> followed;
    List<Post> posts;

    public boolean isSeller(){
        return posts.size()>0;
    }

    public int followersCount() {
        return followers.size();
    }

    //este método me suena más que tiene que ir en el repositorio, pero por ahora lo dejo aca
    // para ser consistente con el followersCount
    public int getPostOnSaleCount() {
        return posts.stream().filter(p -> p.inOnSale()).toList().size();
    }
}
