package com.sprint.be_java_hisp_w21_g04.repository.post;

import com.sprint.be_java_hisp_w21_g04.entity.Post;
import com.sprint.be_java_hisp_w21_g04.entity.User;

import java.util.List;

public interface IPostRepository {
    void post(Post post);
    List<Post> getAll();
    public List<Post> getSellerFollowed(int user_id);
}
