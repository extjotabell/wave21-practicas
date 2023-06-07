package com.example.be_java_hisp_w21_g02.repository;
import com.example.be_java_hisp_w21_g02.model.User;
import com.example.be_java_hisp_w21_g02.model.Post;

import java.util.List;
import java.util.Set;

public interface IUserRepository {
    User getUser(int userIdToFollow);
    void persistFollows(User persistedUser, User persistedFollowUser);
    void createPost(Post post);
    List<User> getUsers(Set<Integer> users);
    List<User> listFollowingPosts2Weeks(int userId);

    List<Post> getPostsByRange(double minimumPrice, double maximumPrice);
}