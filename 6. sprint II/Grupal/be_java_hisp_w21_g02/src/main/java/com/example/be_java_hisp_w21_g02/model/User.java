package com.example.be_java_hisp_w21_g02.model;

import lombok.*;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class User {
    private Integer id;
    private String username;
    private Set<Integer> following;
    private Set<Integer> followers;
    private List<Post> posts;

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
}
