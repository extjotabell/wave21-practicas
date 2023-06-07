package com.example.be_java_hisp_w21_g1_dominguez.Model;

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
    List<PromoPost> promoPosts;

    public boolean isSeller(){
        return posts.size()>0;
    }

    public int followersCount() {
        return followers.size();
    }
}
