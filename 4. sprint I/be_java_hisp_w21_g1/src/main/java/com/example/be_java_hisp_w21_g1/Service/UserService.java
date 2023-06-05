package com.example.be_java_hisp_w21_g1.Service;

import com.example.be_java_hisp_w21_g1.DTO.Request.PostProductDTO;
import com.example.be_java_hisp_w21_g1.Model.Post;
import com.example.be_java_hisp_w21_g1.Repository.UserRepository;
import com.example.be_java_hisp_w21_g1.Utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    UserRepository userRepository;

    public void createPost(PostProductDTO postProductDTO) {
        int postId = userRepository.findUserById(postProductDTO.getUser_id()).getPosts().size();
        Post post = Mapper.DTOtoPost(postProductDTO,postId);
        userRepository.addPostToUser(post, postProductDTO.getUser_id());
    }


}
