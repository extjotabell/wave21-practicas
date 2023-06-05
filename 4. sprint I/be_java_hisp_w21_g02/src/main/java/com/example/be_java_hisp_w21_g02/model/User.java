package com.example.be_java_hisp_w21_g02.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String username;
    private Set<Integer> following;
    private Set<Integer> followers;
    private List<Post> posts;

    public boolean isSeller(){
        return !posts.isEmpty();
    }

    public boolean follow(int userIdToFollow) {
        return following.add(userIdToFollow);
    }

    public void beFollowed(int userId) {
        followers.add(userId);
    }

    public boolean unFollow(int userIdToUnFollow) {
        return following.remove(userIdToUnFollow);
    }

    public void unBeFollowed(int userId) {
        followers.remove(userId);
    }

    public boolean verifyFollower(int userIdToUnFollow) {
        return following.contains(userIdToUnFollow);
    }
}
